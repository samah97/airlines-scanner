package com.sd.airlinesscanner.airlineprovider.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SearchResponse {

    int nbrOfFlights;

}
