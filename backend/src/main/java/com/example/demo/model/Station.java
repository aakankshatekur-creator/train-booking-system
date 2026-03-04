package com.example.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "stations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Station {

    @Id
    @Column(name = "station_id")
    private Long stationId;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "station_code")
    private String stationCode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    public Station() {}

    public Long getStationId() { return stationId; }
    public void setStationId(Long stationId) { this.stationId = stationId; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }

    public String getStationCode() { return stationCode; }
    public void setStationCode(String stationCode) { this.stationCode = stationCode; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}