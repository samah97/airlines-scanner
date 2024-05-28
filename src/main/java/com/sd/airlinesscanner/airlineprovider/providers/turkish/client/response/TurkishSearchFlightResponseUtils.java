package com.sd.airlinesscanner.airlineprovider.providers.turkish.client.response;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TurkishSearchFlightResponseUtils {

    public static int extractFlightsNbr(TurkishSearchFlightResponse response){
        return response.getData()
                .getAvailabilityOTAResponse()
                .getCreateOTAAirRoute().getExtraOTAAvailabilityInfoListType()
                .getExtraOTAAvailabilityInfoList()
                .getExtraOTAFlightInfoListType().getExtraOTAFlightInfoList().size();
    }

}
