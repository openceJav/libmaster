package com.opencejav.LibMaster.enums;

import lombok.Getter;
import lombok.NonNull;

import java.util.Optional;


// TODO: Add Configurations for ResponseType
@Getter
public enum ResponseType {
    SUCCESS("", 1),
    FAILURE("", 1),
    WARNING("", 1),
    INFO("", 1),
    ERROR("", 1),
    HAVOC("", 1),
    UNKNOWN("", 1),
    NOT_FOUND("", 1),
    NOT_AVAILABLE("", 1),
    NOT_IMPLEMENTED("", 1),
    NOT_SUPPORTED("", 1),
    NOT_AUTHORIZED("", 1),
    NOT_AUTHENTICATED("", 1),


    // HTTP Status Codes
    OK("", 1),
    CREATED("", 1),
    ACCEPTED("", 1),
    NO_CONTENT("", 1),
    MOVED_PERMANENTLY("", 1),
    FOUND("", 1),
    SEE_OTHER("", 1),
    NOT_MODIFIED("", 1),
    TEMPORARY_REDIRECT("", 1),
    PERMANENT_REDIRECT("", 1),
    BAD_REQUEST("", 1),
    UNAUTHORIZED("", 1),
    FORBIDDEN("", 1);


    private final String name;
    private final Integer priority;

    ResponseType(
            @NonNull final String name,
            final Integer priority) {
        this.name = name;
        this.priority = priority;
    }


    public Optional<ResponseType> getResponseTypeByName(@NonNull final String name) {
        return null;
    }

    public Optional<ResponseType> getFirstResponseTypeByPriority(final Integer priority) {
        if (priority == null) { return Optional.empty(); }
        return null;
    }

    public Optional<ResponseType> getAllResponseTypeByPriority(final Integer priority) {
        return null;
    }
}
