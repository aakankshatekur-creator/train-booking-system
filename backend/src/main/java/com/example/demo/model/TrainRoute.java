package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import jakarta.persistence.Column;

@Entity
@Table(name = "train_routes")
public class TrainRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", referencedColumnName = "train_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Train train;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_station_id", referencedColumnName = "station_id")
    @JsonIgnoreProperties("routes")
    private Station fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", referencedColumnName = "station_id")
    @JsonIgnoreProperties("routes")
    private Station toStation;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "price")
    private BigDecimal price;

    public TrainRoute() {}

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }


    public Station getFromStation() {
        return fromStation;
    }

    public void setFromStation(Station fromStation) {
        this.fromStation = fromStation;
    }

    public Station getToStation() {
        return toStation;
    }

    public void setToStation(Station toStation) {
        this.toStation = toStation;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getTrainName() {
        return train != null ? train.getTrain_name() : null;
    }
    }