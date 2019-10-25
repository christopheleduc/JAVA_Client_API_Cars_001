package com.vues_thymeleaf.vues_thymeleaf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private String modelName;

    public Car() {

    }

    public Car(String carName, String modelName) {
        this.carName = carName;
        this.modelName = modelName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
