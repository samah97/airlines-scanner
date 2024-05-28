package com.sd.airlinesscanner.airlineprovider.providers.klm.client.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class KLMSearchFlightResponse {
    private DataContent data;
    private Extensions extensions;

    @Data
    @ToString
    public static class DataContent {
        private FlightOffers flightOffers;
    }

    @Data
    @ToString
    public static class FlightOffers {
        private List<Offer> offers;
        private String offersFromBooking;
        private Disclaimer disclaimer;
        private String contextInformation;
        private String itineraryInformation;
        private String alternativeItinerary;
        private boolean captcha;
        private int responseTime;
        private String negotiatedFareAvailable;
        private String nearestStationWarning;
        private String __typename;
    }

    @Data
    @ToString
    public static class Offer {
        private String _id;
        private String departureTime;
        private String arrivalTime;
        private String destinationCode;
        private String co2Compensation;
        private String travelCorridor;
        private String originCode;
        private String operatingFlight;
        private String operatingFlightLogo;
        private String operatingCarrier;
        private String flightNumber;
        private String uniqueKey;
        private int duration;
        private List<FlightProduct> flightProducts;
        private boolean isDirect;
        private String transferStops;
        private int dayChange;
        private String dayChangeStr;
        private String isLowestFare;
        private String acvCode;
        private String flightAmenityNumber;
        private List<Segment> segments;
        private String __typename;
    }

    @Data
    @ToString
    public static class FlightProduct {
        private List<Connection> connections;
        private String cabinClass;
        private String currency;
        private int seatsLeft;
        private String fareBasis;
        private boolean displayMailMySearch;
        private boolean isCorporateFare;
        private boolean isPromoFare;
        private boolean dynamicWaiver;
        private String promoFareTitle;
        private double displayPrice;
        private double displayPriceItinerary;
        private String displayType;
        private double totalBookingFee;
        private double totalPrice;
        private double totalPriceItinerary;
        private double totalTax;
        private double totalPenaltyFee;
        private String splitTaxDetails;
        private String totalTaxDetails;
        private String externalBookingLink;
        private List<PassengerDetail> passengerDetails;
        private Resources resources;
        private String __typename;
    }

    @Data
    @ToString
    public static class Connection {
        private List<Segment> segments;
        private String __typename;
    }

    @Data
    @ToString
    public static class Segment {
        private String departureTime;
        private String origin;
        private String originCode;
        private String originAirport;
        private String arrivalTime;
        private String destination;
        private String destinationCode;
        private String destinationAirport;
        private String carrierName;
        private String flightNumber;
        private String flightOnTime;
        private String equipmentCode;
        private String equipmentName;
        private String equipInformationText;
        private String operatingCarrier;
        private String operatingCarrierLogo;
        private int duration;
        private String marketingCarrier;
        private String marketingFlightNumber;
        private String transferTime;
        private String flightAmenityNumber;
        private String acvCode;
        private boolean airportChangeWarning;
        private String ratingStatistics;
        private String stopOvers;
        private String __typename;
    }

    @Data
    @ToString
    public static class PassengerDetail {
        private String passengerType;
        private int passengerId;
        private double displayPrice;
        private double displayPriceItinerary;
        private double totalPrice;
        private String __typename;
    }

    @Data
    @ToString
    public static class Resources {
        private String availableOffers;
        private String upsellOffers;
        private String ticketConditions;
        private String shoppingCart;
        private String taxBreakdown;
        private String relatedProducts;
        private String mailMySearch;
        private String flightDetails;
        private String priceDetails;
        private String specificRemarks;
        private String __typename;
    }

    @Data
    @ToString
    public static class Disclaimer {
        private String displayPriceText;
        private String totalPriceText;
        private String optionalUMTextRJF;
        private String __typename;
    }

    @Data
    @ToString
    public static class Extensions {
        private AviatoCacheControl aviatoCacheControl;
    }

    @Data
    @ToString
    public static class AviatoCacheControl {
        private boolean hasPrivateData;
    }
}
