package com.sd.airlinesscanner.airlineprovider.providers.klm;

import com.sd.airlinesscanner.airlineprovider.AirlineProvider;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service("klm")
public final class KLMAirlineProvider implements AirlineProvider {

    @Override
    public Mono<SearchResponse> searchFlights(SearchRequest request) {
        log.info("Retrieving KLM flights");
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setNbrOfFlights(3);
        log.info("DONE Retrieving KLM flights, total = {}", searchResponse.getNbrOfFlights());
        return Mono.just(searchResponse);
    }
}
