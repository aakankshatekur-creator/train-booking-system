package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long train_id;

    private String train_name;

    // Constructors
    public Train() {
    }

    public Train(String train_name) {
        this.train_name = train_name;
    }

    // Getters and Setters
    public Long getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Long train_id) {
        this.train_id = train_id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
}
