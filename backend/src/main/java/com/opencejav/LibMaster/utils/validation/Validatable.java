package com.opencejav.LibMaster.utils.validation;

import java.util.List;
import java.util.Optional;

public interface Validatable<T> {
    Validatable<T> addRule(Rule<T> rule);
    Validatable<T> addRules(Iterable<Rule<T>> rules);
    boolean validate();
    Optional<Rule<T>> getFirstFailed();
    Optional<List<Rule<T>>> getAllFailed();
}
