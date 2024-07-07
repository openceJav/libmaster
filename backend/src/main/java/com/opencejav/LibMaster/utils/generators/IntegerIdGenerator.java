package com.opencejav.LibMaster.utils.generators;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.Random;

public class IntegerIdGenerator implements BaseIdGenerator<Integer> {
    private static IntegerIdGenerator instance;

    //region DEFAULT(S)
    private static final Integer DEFAULT_NUMBER = 0;
    private static final Integer DEFAULT_SIZE = 10;
    private static final Integer DEFAULT_PREFIX = 0;
    private static final Integer DEFAULT_SUFFIX = 0;
    private static final Integer[] DEFAULT_ALLOWED = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    //endregion

    static {
        instance = new IntegerIdGenerator();
    }

    public static IntegerIdGenerator getInstance() {
        if (instance == null) {
            instance = new IntegerIdGenerator();
        }

        return instance;
    }

    public BigInteger generateBigInteger() {
        return BigInteger.valueOf(generate());
    }

    @Override
    public Integer generate() {
        return 0; // TODO: Work on This Method.
    }

    @Override
    public Integer generate(@NonNull Random random, int size) {
        return 0;  // TODO: Work on This Method.
    }

    @Override
    public Integer generate(
            @NonNull Random random,
            int size,
            @NonNull Integer prefix) {
        return 0;  // TODO: Work on This Method.
    }

    @Override
    public Integer generate(
            @NonNull Random random,
            int size,
            @NonNull Integer prefix,
            @NonNull Integer suffix) {
        return 0;  // TODO: Work on This Method.
    }

    @Override
    public Integer generate(
            @NonNull Random random,
            Integer[] allowed,
            int size,
            @NotNull Integer prefix,
            @NotNull Integer suffix) {
        return 0;  // TODO: Work on This Method.
    }
}
