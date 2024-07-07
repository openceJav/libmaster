package com.opencejav.LibMaster.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.opencejav.LibMaster.annotations.UtilityClass;

@Getter
@Setter
@NoArgsConstructor
@UtilityClass(className = "Range.java")
public class Range {
    //region DEFAULT(S)
    private static final Integer DEFAULT_MIN = 0;
    private static final Integer DEFAULT_MAX = 100;
    //endregion

    private int min;
    private int max;

    public Range(
            final Integer min,
            final Integer max) {
        this.min = checkMin();
        this.max = checkMax();
    }

    public static Range of(
            final Integer min,
            final Integer max) {
        return new Range(min, max);
    }

    private Integer checkMin() {
        if (min <= 0) return DEFAULT_MIN;
        if (min >= DEFAULT_MAX) return this.min - 1;
        return min;
    }

    private Integer checkMax() {
        if (max <= 0) return DEFAULT_MAX;
        if (max <= this.min) return this.min + 1;
        return max;
    }

    public boolean contains(final Integer value) {
        return (value >= this.min && value <= this.max);
    }

    public static boolean contains(
            final Integer value,
            final Integer min,
            final Integer max) {
        return (value >= min && value <= max);
    }
}
