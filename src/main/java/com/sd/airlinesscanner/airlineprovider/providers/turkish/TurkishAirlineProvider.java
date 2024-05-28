package com.sd.airlinesscanner.airlineprovider.providers.turkish;

import com.sd.airlinesscanner.airlineprovider.AirlineProvider;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.TurkishApiClient;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.converters.TurkishClientConverter;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.request.TurkishSearchFlightRequest;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service("turkish")
public class TurkishAirlineProvider implements AirlineProvider {


    final TurkishClientConverter clientConverter;
    final TurkishApiClient apiClient;
    @Override
    public Mono<SearchResponse> searchFlights(SearchRequest request) {
        TurkishSearchFlightRequest clientRequest =
                clientConverter.requestConverter().searchRequestToClientRequest(request);

        return apiClient.searchFlights(clientRequest)
                .map(clientConverter.responseConverter()::clientResponseToSearchResponse);
    }
}
