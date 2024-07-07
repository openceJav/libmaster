package com.opencejav.LibMaster.utils.generators;

import com.opencejav.LibMaster.annotations.Base;

import java.util.Random;

@Base(className = "BaseIdGenerator")
public interface BaseIdGenerator<T> {
    T generate();
    T generate(final Random random, final int size);
    T generate(final Random random, final int size, final T prefix);
    T generate(final Random random, final int size, final T prefix, final T suffix);
    T generate(final Random random, T[] allowed, final int size, final T prefix, final T suffix);
}
