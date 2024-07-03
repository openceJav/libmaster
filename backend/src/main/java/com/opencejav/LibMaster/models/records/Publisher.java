package com.opencejav.LibMaster.models.records;

import lombok.NonNull;

public record Publisher(
        @NonNull String publisherName,
        @NonNull String publisherAddress,
        @NonNull String publisherCity,
        @NonNull String publisherState,
        @NonNull String publisherCountry) {
    // TODO: Implement Publisher Record Logic
}
