package com.sd.airlinesscanner.airlineprovider.providers.klm.client;

import com.sd.airlinesscanner.airlineprovider.providers.klm.client.request.KLMSearchFlightRequest;
import com.sd.airlinesscanner.airlineprovider.providers.klm.client.response.KLMSearchFlightResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class KLMApiClient {

    WebClient client = WebClient.create("https://www.klm.nl/");



    public Mono<KLMSearchFlightResponse> searchFlights(KLMSearchFlightRequest request){
        return client.post()
                .uri("/gql/v1?bookingFlow=LEISURE")
                .bodyValue(request)
                .exchangeToMono(clientResponse -> {
                    if(clientResponse.statusCode().is2xxSuccessful() ){
                        return clientResponse.bodyToMono(KLMSearchFlightResponse.class);
                    } else if (clientResponse.statusCode().is4xxClientError()) {
                        return Mono.error(new RuntimeException("Client Error: can't fetch user"));
                    } else if (clientResponse.statusCode().is5xxServerError()) {
                        return Mono.error(new RuntimeException("Server Error: can't fetch user"));
                    } else {
                        return clientResponse.createError();
                    }
                });
//        return client.post()
//                .uri("/gql/v1?bookingFlow=LEISURE")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(request))
//                .retrieve()
//                .bodyToMono(KLMSearchFlightResponse.class);
    }
}
