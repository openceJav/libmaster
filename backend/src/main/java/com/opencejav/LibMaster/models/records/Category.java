package com.opencejav.LibMaster.models.records;

import lombok.NonNull;

public record Category(
        long categoryId,
        @NonNull String categoryName,
        @NonNull String categoryDescription) {
    // TODO: Implement Category Record Logic
}
