package com.sd.airlinesscanner.service;

import com.sd.airlinesscanner.airlineprovider.AirlineProvider;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import com.sd.airlinesscanner.config.AirlineProviderConfig;
import com.sd.airlinesscanner.dto.FlightInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightScannerService {

    private final AirlineProviderConfig airlineProviderConfig;
    private final ApplicationContext applicationContext;

    public Flux<SearchResponse> search(final SearchRequest searchRequest){
        List<String> providers = airlineProviderConfig.getProvidersList();

        return Flux.fromIterable(providers)
                .flatMap(provider-> searchProvider(provider, searchRequest));


    }

    private Mono<SearchResponse> searchProvider(String provider, SearchRequest searchRequest){
        AirlineProvider providerService = getProviderBean(provider);
        if(providerService != null){
            return providerService.searchFlights(searchRequest);
        }
        return Mono.empty();
    }


    private AirlineProvider getProviderBean(String providerName){
        try{
            return applicationContext.getBean(providerName, AirlineProvider.class);
        }catch (NoSuchBeanDefinitionException exception){
            log.info("No bean defined for provider "+providerName);
        }
        return null;
    }

    //        try{
//            ExecutorService executorService = Executors.newFixedThreadPool(10);
//            List<CompletableFuture<Void>> futures =  providers.stream()
//                            .map(provider-> CompletableFuture.runAsync( ()->
//                                    searchProvider(provider,searchRequest),executorService)
//                            )
//                            .toList();
//
//            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
//            executorService.shutdownNow();
//        }
//        catch (Exception e){
//            log.error(e.getMessage());
//        }
//        return new SearchResponse();


}
