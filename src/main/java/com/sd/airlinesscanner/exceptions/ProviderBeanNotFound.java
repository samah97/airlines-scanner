package com.sd.airlinesscanner.exceptions;

public class ProviderBeanNotFound extends Exception{


    public ProviderBeanNotFound(String providerName){
        super("No bean defined for provider "+providerName);
    }


}
