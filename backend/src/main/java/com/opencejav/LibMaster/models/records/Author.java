package com.opencejav.LibMaster.models.records;

import lombok.NonNull;

public record Author(
        long authorId,
        @NonNull String authorName,
        @NonNull String authorEmail,
        @NonNull String authorPhone ) {
    // TODO: Implement Author Record Logic
}
