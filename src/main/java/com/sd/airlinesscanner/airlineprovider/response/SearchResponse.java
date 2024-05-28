package com.sd.airlinesscanner.airlineprovider.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class SearchResponse {


    int nbrOfFlights = 0;

}
