package com.opencejav.LibMaster.models.records;

import lombok.NonNull;

public class Publisher {
    // TODO: Implement Publisher Record Logic
    private String publisherName;
    private String publisherAddress;
    private String publisherCity;
    private String publisherState;
    private String publisherCountry;

    public Publisher (
            String publisherName,
            String publisherAddress,
            String publisherCity,
            String publisherState,
            String publisherCountry
    ) {
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
        this.publisherCity = publisherCity;
        this.publisherState = publisherState;
        this.publisherCountry = publisherCountry;
    }

}
