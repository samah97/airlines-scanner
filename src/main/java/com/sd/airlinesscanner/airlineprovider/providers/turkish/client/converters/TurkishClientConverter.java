package com.sd.airlinesscanner.airlineprovider.providers.turkish.client.converters;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
@Component
public class TurkishClientConverter {

    private final TurkishClientRequestConverter requestConverter;

    private final TurkishClientResponseConverter responseConverter;

}
