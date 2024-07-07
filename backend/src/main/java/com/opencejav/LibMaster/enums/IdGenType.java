package com.opencejav.LibMaster.enums;

import com.opencejav.LibMaster.utils.generators.BaseIdGenerator;
import com.opencejav.LibMaster.utils.generators.IntegerIdGenerator;
import com.opencejav.LibMaster.utils.generators.StringIdGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum IdGenType {
    INTEGER_BASED(IntegerIdGenerator::new),
    STRING_BASED(StringIdGenerator::new);

    private final Supplier<BaseIdGenerator<?>> constructor;
}
