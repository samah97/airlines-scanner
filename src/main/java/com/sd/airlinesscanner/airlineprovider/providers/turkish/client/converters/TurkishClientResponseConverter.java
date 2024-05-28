package com.sd.airlinesscanner.airlineprovider.providers.turkish.client.converters;

import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.response.TurkishSearchFlightResponse;
import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.response.TurkishSearchFlightResponseUtils;
import com.sd.airlinesscanner.airlineprovider.response.SearchResponse;
import org.springframework.stereotype.Component;

@Component
public class TurkishClientResponseConverter {

    public SearchResponse clientResponseToSearchResponse(TurkishSearchFlightResponse response){

        return new SearchResponse().setNbrOfFlights(
                TurkishSearchFlightResponseUtils.extractFlightsNbr(response)
        );
    }

}
