package com.sd.airlinesscanner.airlineprovider.providers.turkish.client.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TurkishSearchFlightResponse {
    String status;
    String requestId;
    Message message;
    @JsonProperty("data")
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
    ResponseData data;

    @Getter
    @Setter
    public static class Message{
        String code;
        String description;
    }

    @Getter
    @Setter
    public static class ResponseData {
        private AvailabilityOTAResponse availabilityOTAResponse;


        @Getter
        @Setter
        public static class AvailabilityOTAResponse {
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            private CreateOTAAirRoute createOTAAirRoute;
            private boolean isMixCabin;

            @Getter
            @Setter
            @NoArgsConstructor
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            public static class CreateOTAAirRoute {

                private ExtraOTAAvailabilityInfoListType extraOTAAvailabilityInfoListType;
                @JsonProperty("OTA_AirAvailRS")
                private OTA_AirAvailRS otaAirAvailRS;

                @Getter
                @Setter
                public static class ExtraOTAAvailabilityInfoListType {
                    private ExtraOTAAvailabilityInfoList extraOTAAvailabilityInfoList;

                    @Getter
                    @Setter
                    public static class ExtraOTAAvailabilityInfoList {
                        private ExtraOTAFlightInfoListType extraOTAFlightInfoListType;
                        private boolean isAllFlightsFullCodeShare;
                        private boolean isIndeedHasMoreFlightsForAnotherPortInTheSameCity;
                        private String RPH;


                        @Getter
                        @Setter
                        public static class ExtraOTAFlightInfoListType {
                            private List<ExtraOTAFlightInfo> extraOTAFlightInfoList;

                            @Getter
                            @Setter
                            public static class ExtraOTAFlightInfo {
                                private boolean isPureAnadoluJetFlight;
                                private ExtraOTASegmentInfoListType extraOTASegmentInfoListType;
                                @JsonProperty("StandbyIndicator")
                                private boolean StandbyIndicator;
                                private boolean isElectronicTicketAvailable;
                                private boolean isMarketable;
                                private boolean isCodeShare;
                                private boolean isFullCodeShare;
                                private BookingPriceInfoType bookingPriceInfoType;
                                private boolean isDomestic;
                                private boolean isFullInternational;
                                private String flightNumber;
                                private boolean isFullAvailable;

                                @Getter
                                @Setter
                                public static class ExtraOTASegmentInfoListType {
                                    private ExtraOTASegmentInfoList extraOTASegmentInfoList;

                                    @Getter
                                    @Setter
                                    public static class ExtraOTASegmentInfoList {
                                        private boolean isAvailable;
                                        private boolean isConnected;
                                        private String segmentIndex;
                                        private boolean isAnadoluJetSegment;
                                        private boolean isDomestic;
                                        private boolean isStandBySeat;

                                        // Getters and Setters
                                    }
                                }

                                @Getter
                                @Setter
                                public static class BookingPriceInfoType {
                                    private String PTC_FareBreakdowns;

                                }
                            }
                        }
                        // Getters and Setters
                    }
                }

                @Getter
@               Setter
                public static class OTA_AirAvailRS {
                    @JsonProperty("Comment")
                    private String comment;
                    @JsonProperty("OriginDestinationInformation")
                    private OriginDestinationInformation originDestinationInformation;
                    @JsonProperty("Version")
                    private String version;
                    @JsonProperty("Warnings")
                    private Warnings warnings;

                    @Getter
                    @Setter
                    public static class OriginDestinationInformation {
                        @JsonProperty("OriginLocation")
                        private OriginLocation originLocation;
                        @JsonProperty("OriginDestinationOptions")
                        private OriginDestinationOptions originDestinationOptions;
                        @JsonProperty("DepartureDateTime")
                        private String DepartureDateTime;
                        @JsonProperty("ArrivalDateTime")
                        private String ArrivalDateTime;
                        @JsonProperty("RPH")
                        private String RPH;
                        @JsonProperty("DestinationLocation")
                        private DestinationLocation DestinationLocation;

                        @Getter
                        @Setter
                        public static class OriginLocation {
                            @JsonProperty("AlternateLocationInd")
                            private boolean AlternateLocationInd;
                            @JsonProperty("LocationCode")
                            private String LocationCode;

                            // Getters and Setters
                        }
                        @Getter
                        @Setter
                        public static class OriginDestinationOptions {
                            @JsonProperty("OriginDestinationOption")
                            private List<OriginDestinationOption> originDestinationOption;

                            @Getter
                            @Setter
                            public static class OriginDestinationOption {
                                @JsonProperty("FlightSegment")
                                private FlightSegment flightSegment;

                                @Getter
                                @Setter
                                public static class FlightSegment {
                                    @JsonProperty("DepartureAirport")
                                    private Airport DepartureAirport;
                                    @JsonProperty("Ticket")
                                    private String Ticket;
                                    @JsonProperty("ArrivalAirport")
                                    private Airport ArrivalAirport;
                                    @JsonProperty("Equipment")
                                    private Equipment Equipment;
                                    @JsonProperty("DepartureDateTime")
                                    private String DepartureDateTime;
                                    @JsonProperty("ArrivalDateTime")
                                    private String ArrivalDateTime;
                                    @JsonProperty("DateChangeNbr")
                                    private boolean DateChangeNbr;
                                    @JsonProperty("FlightNumber")
                                    private String FlightNumber;
                                    @JsonProperty("StopQuantity")
                                    private String StopQuantity;
                                    @JsonProperty("OperatingAirline")
                                    private OperatingAirline OperatingAirline;
                                    @JsonProperty("JourneyDuration")
                                    private String JourneyDuration;
                                    @JsonProperty("CodeshareInd")
                                    private boolean CodeshareInd;

                                    @Getter
                                    @Setter
                                    public static class Airport {
                                        @JsonProperty("LocationCode")
                                        private String LocationCode;

                                        // Getters and Setters
                                    }

                                    @Getter
                                    @Setter
                                    public static class Equipment {
                                        @JsonProperty("Value")
                                        private String Value;
                                        @JsonProperty("AirEquipType")
                                        private String AirEquipType;

                                        // Getters and Setters
                                    }

                                    @Getter
                                    @Setter
                                    public static class OperatingAirline {
                                        @JsonProperty("CompanyShortName")
                                        private String CompanyShortName;

                                        // Getters and Setters
                                    }

                                    // Getters and Setters
                                }
                            }
                        }
                        @Getter
                        @Setter
                        public static class DestinationLocation {
                            @JsonProperty("AlternateLocationInd")
                            private boolean AlternateLocationInd;
                            @JsonProperty("LocationCode")
                            private String LocationCode;

                            // Getters and Setters
                        }

                    }
                    @Getter
                    @Setter
                    public static class Warnings {
                        @JsonProperty("Warning")
                        private Warning Warning;

                        @Getter
                        @Setter
                        public static class Warning {
                            @JsonProperty("Type")
                            private String Type;
                            @JsonProperty("RPH")
                            private String RPH;
                            @JsonProperty("Code")
                            private String code;

                            // Getters and Setters
                        }
                    }
                }
            }
        }
    }

}


