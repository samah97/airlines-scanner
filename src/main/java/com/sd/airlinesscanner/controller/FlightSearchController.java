package com.sd.airlinesscanner.controller;

import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import com.sd.airlinesscanner.service.FlightScannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class FlightSearchController {

    private final FlightScannerService flightScannerService;

    @PostMapping
    public Flux<SearchResponse> search(@RequestBody  SearchRequest request){
        return flightScannerService.search(request);
    }

}
