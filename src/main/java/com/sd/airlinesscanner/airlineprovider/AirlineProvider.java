package com.sd.airlinesscanner.airlineprovider;

import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import reactor.core.publisher.Mono;

public interface AirlineProvider {

    Mono<SearchResponse> searchFlights(SearchRequest request);

}
