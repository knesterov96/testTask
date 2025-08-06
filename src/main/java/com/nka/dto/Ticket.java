package com.nka.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Ticket {
    @SerializedName("origin")
    private String origin;
    @SerializedName("origin_name")
    private String originName;
    @SerializedName("destination")
    private String destination;
    @SerializedName("destination_name")
    private String destinationName;
    @SerializedName("departure_date")
    private String departureDate;
    @SerializedName("departure_time")
    private String departureTime;
    @SerializedName("arrival_date")
    private String arrivalDate;
    @SerializedName("arrival_time")
    private String arrivalTime;
    @SerializedName("carrier")
    private String carrier;
    @SerializedName("stops")
    private Integer stops;
    @SerializedName("price")
    private Double price;

    public Ticket() {
    }

    public Ticket(String origin, String originName, String destination, String destinationName, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String carrier, Integer stops, Double price) {
        this.origin = origin;
        this.originName = originName;
        this.destination = destination;
        this.destinationName = destinationName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getOrigin(), ticket.getOrigin()) && Objects.equals(getOriginName(), ticket.getOriginName()) && Objects.equals(getDestination(), ticket.getDestination()) && Objects.equals(getDestinationName(), ticket.getDestinationName()) && Objects.equals(getDepartureDate(), ticket.getDepartureDate()) && Objects.equals(getDepartureTime(), ticket.getDepartureTime()) && Objects.equals(getArrivalDate(), ticket.getArrivalDate()) && Objects.equals(getArrivalTime(), ticket.getArrivalTime()) && Objects.equals(getCarrier(), ticket.getCarrier()) && Objects.equals(getStops(), ticket.getStops()) && Objects.equals(getPrice(), ticket.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getOriginName(), getDestination(), getDestinationName(), getDepartureDate(), getDepartureTime(), getArrivalDate(), getArrivalTime(), getCarrier(), getStops(), getPrice());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "origin='" + origin + '\'' +
                ", originName='" + originName + '\'' +
                ", destination='" + destination + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}
