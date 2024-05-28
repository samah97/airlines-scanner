package com.sd.airlinesscanner.service;

import com.sd.airlinesscanner.airlineprovider.AirlineProvider;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import com.sd.airlinesscanner.config.AirlineProviderConfig;
import com.sd.airlinesscanner.exceptions.ProviderBeanNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightScannerService {

    private final AirlineProviderConfig airlineProviderConfig;
    private final ApplicationContext applicationContext;

    public Mono<SearchResponse> search(final SearchRequest searchRequest){
        List<String> providers = airlineProviderConfig.getProvidersList();
        return Flux.fromIterable(providers)
                .flatMap(provider-> Mono.just(provider)
                        .subscribeOn(createThreadPoolScheduler(providers.size())))
                .flatMap(p-> searchProvider(p, searchRequest))
                .reduce(new SearchResponse(), (totalResponse, providerResponse)->{
                   totalResponse.setNbrOfFlights( totalResponse.getNbrOfFlights() + providerResponse.getNbrOfFlights());
                   return totalResponse;
                });
    }

    private Mono<SearchResponse> searchProvider(final String provider,final SearchRequest searchRequest){
        try {
            AirlineProvider providerService = getProviderBean(provider);
            return providerService.searchFlights(searchRequest);
        } catch (ProviderBeanNotFound e) {
            log.error(e.getMessage());
        }
        return Mono.empty();
    }


    private AirlineProvider getProviderBean(String providerName) throws ProviderBeanNotFound {
        try{
            return applicationContext.getBean(providerName, AirlineProvider.class);
        }catch (NoSuchBeanDefinitionException exception){
            throw new ProviderBeanNotFound(providerName);
        }
    }

    Scheduler createThreadPoolScheduler(int providersSize){
        int poolSize = Math.min(providersSize, 20);
        return Schedulers.newParallel("custom", poolSize);
    }
}
