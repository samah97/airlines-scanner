package com.sd.airlinesscanner.airlineprovider.providers.turkish.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.request.TurkishSearchFlightRequest;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.response.TurkishSearchFlightResponse;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.response.TurkishSearchFlightResponseUtils;
import com.sd.airlinesscanner.config.AirlineProviderConfig;
import com.sd.airlinesscanner.util.custom_naming_strategies.CapitalizeFirstLetterStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class TurkishApiClient {

    private static final String BASE_URL = "https://api.turkishairlines.com/test";
    final AirlineProviderConfig airlineProviderConfig;
    final ObjectMapper objectMapper = initObjectMapper();
    WebClient client = initClient();

    ObjectMapper initObjectMapper(){
        ObjectMapper omp = new ObjectMapper();
        omp.setPropertyNamingStrategy(new CapitalizeFirstLetterStrategy());
        return omp;
    }

    private WebClient initClient(){
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .codecs(clientCodecConfigurer ->
                    clientCodecConfigurer.defaultCodecs().jackson2JsonEncoder(
                            new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON))
                ).build();
    }

    public Mono<TurkishSearchFlightResponse> searchFlights(TurkishSearchFlightRequest request){
        log.info("Retrieving TURKISH flights");
        logRequestBody(request);
        return client.post()
                .uri("/getAvailability")
                .headers(this::addHeaders)
                .bodyValue(request)
                .exchangeToMono(this::handleResponse);
    }

    private Mono<TurkishSearchFlightResponse> handleResponse(ClientResponse clientResponse) {
        if(clientResponse.statusCode().is2xxSuccessful() ){
            return clientResponse.bodyToMono(TurkishSearchFlightResponse.class)
                    .map(response -> {
                        logRequestBody(response);
                        log.info("DONE Retrieving TURKISH flights, total = {}",
                                TurkishSearchFlightResponseUtils.extractFlightsNbr(response)
                        );
                        return response;
                    });
        } else if (clientResponse.statusCode().is4xxClientError()) {
            return clientResponse.bodyToMono(String.class)
                    .flatMap(errorMessage->
                            Mono.error(new RuntimeException("Client Error:"+errorMessage))
                    );
        } else if (clientResponse.statusCode().is5xxServerError()) {
            return Mono.error(new RuntimeException("Server Error: can't fetch user"));
        } else {
            return clientResponse.createError();
        }
    }

    private void addHeaders(HttpHeaders httpHeaders) {
        httpHeaders.add("apiKey", airlineProviderConfig.getTurkish().getApiKey());
        httpHeaders.add("apiSecret", airlineProviderConfig.getTurkish().getApiSecret());
    }

    private void logRequestBody(Object object) {
        try {
            log.info("Request/Response Info: {}", objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }


}
