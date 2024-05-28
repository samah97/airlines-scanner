package com.sd.airlinesscanner.airlineprovider.providers.klm;

import com.sd.airlinesscanner.airlineprovider.AirlineProvider;
import com.sd.airlinesscanner.airlineprovider.providers.klm.client.KLMApiClient;
import com.sd.airlinesscanner.airlineprovider.providers.klm.client.request.KLMSearchFlightRequest;
import com.sd.airlinesscanner.airlineprovider.providers.klm.client.response.KLMSearchFlightResponse;
import com.sd.airlinesscanner.airlineprovider.providers.klm.converters.KLMClientConverter;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service("klm")
public final class KLMAirlineProvider/* implements AirlineProvider */{

    private final KLMClientConverter clientConverter;
    private final KLMApiClient klmApiClient;



//    @Override
//    public SearchResponse searchFlights(SearchRequest searchRequest) {
//        log.info("Searching flights for KLM");
//        KLMSearchFlightRequest klmSearchFlightRequest = clientConverter.searchRequestToClientRequest(searchRequest);
//        klmApiClient.searchFlights(klmSearchFlightRequest)
//                .map(klmSearchFlightResponse -> {
//
//                    System.out.println(klmSearchFlightResponse.toString());
//                    return klmSearchFlightResponse;
//                })
//                .subscribe(System.out::println);
//        return new SearchResponse();
//    }
}
