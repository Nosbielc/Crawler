package com.nosbielc.crawler.camelapidb.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PojoParaValidacao {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 5, max = 14)
    private String licensePlate;

    public PojoParaValidacao() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
