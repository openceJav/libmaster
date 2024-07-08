package com.opencejav.LibMaster.utils.generators;

import lombok.NonNull;

import java.security.SecureRandom;
import java.util.Random;

public class StringIdGenerator implements BaseIdGenerator<String> {
    private static StringIdGenerator instance;

    //region DEFAULT(S)
    private static final SecureRandom DEFAULT_NUMBER_GENERATOR = new SecureRandom();
    private static final String DEFAULT_PREFIX = ""; // TODO: Define Prefix
    private static final String DEFAULT_SUFFIX = ""; // TODO: Define Suffix
    private static final Integer DEFAULT_SIZE = 10;
    private static final Integer DEFAULT_DESIRED_LENGTH = 10;
    private static final char[] DEFAULT_ALLOWED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".toCharArray();
    //endregion

    private final int mask = (2 << (int) Math.floor(Math.log(DEFAULT_ALLOWED_CHARS.length - 1) / Math.log(2))) - 1;

    static {
        instance = new StringIdGenerator();
    }

    public static StringIdGenerator getInstance() {
        if (instance == null) {
            instance = new StringIdGenerator();
        }

        return instance;
    }

    // TODO: Work on This Method.
    private StringBuilder baseGenerate(Random random, int size, String prefix) {
        final StringBuilder sb = new StringBuilder(prefix);
        final int step = (int) Math.ceil(1.6 * mask * size / DEFAULT_ALLOWED_CHARS.length);

        while (sb.length() < size) {
            final byte[] bytes = new byte[step];
            random.nextBytes(bytes);

            for (int i = 0; i < step; i++) {
                final int index = bytes[i] & mask;

                sb.append(DEFAULT_ALLOWED_CHARS[index]);

                if (sb.length() == size) {
                    break;
                }
            }
        }

        return sb;
    }

    @Override
    public String generate() {
        return generate(DEFAULT_NUMBER_GENERATOR, DEFAULT_SIZE, DEFAULT_PREFIX, DEFAULT_SUFFIX);
    }

    @Override
    public String generate(Random random, int size) {
        return generate(random, size, DEFAULT_PREFIX, DEFAULT_SUFFIX);
    }

    @Override
    public String generate(Random random, int size, String prefix) {
        StringBuilder sb = baseGenerate(random, size, prefix);

        return sb.toString();
    }

    @Override
    public String generate(
            @NonNull Random random,
            int size,
            @NonNull String prefix,
            @NonNull String suffix) {
        StringBuilder sb = baseGenerate(random, size, prefix);
        return sb.append(suffix).toString();
    }

    // TODO: Work on This Method.
    @Override
    public String generate(
            @NonNull Random random,
            @NonNull String[] allowedChars,
            int size,
            @NonNull String prefix,
            @NonNull String suffix) {
        final int step = (int) Math.ceil(1.6 * mask * size / allowedChars.length);
        final StringBuilder sb = new StringBuilder(prefix);

        while(sb.length() < size) {
            final byte[] bytes = new byte[step];
            random.nextBytes(bytes);

            for (int i = 0; i < step; i++) {
                final int index = bytes[i] & mask;

                sb.append(allowedChars[index]);

                if (sb.length() == size) {
                    break;
                }
            }
        }

        return sb.append(suffix).toString();
    }
}
