package com.opencejav.LibMaster.utils.validation;

import java.util.*;

public class Validator<T> implements Validatable<T> {
    private final T object;
    private final List<Throwable> exceptionsList;
    private final List<Rule<T>> rulesList;

    private Validator(T object) {
        this.object = object;
        this.exceptionsList = new Stack<>();
        this.rulesList = new Stack<>();
    }

    public static <T> Validator<T> of(T t) {
        return new Validator<>(Objects.requireNonNull(t));
    }

    @Override
    public Validator<T> addRule(Rule<T> rule) {
        if (rule.validate(object)) {
            exceptionsList.add(new IllegalArgumentException(rule.message()));
        }

        return this;
    }

    @Override
    public Validator<T> addRules(Iterable<Rule<T>> rules) {
        for (var rule : rules) {
            if (rule.validate(object)) {
                exceptionsList.add(rule.throwIfInvalid());
            }
        }

        return this;
    }

    @Override
    public boolean validate() {
        return exceptionsList.isEmpty();
    }

    @Override
    public Optional<Rule<T>> getFirstFailed() {
        return rulesList.stream()
                .filter(rule -> rule.validate(object))
                .findFirst()
                .or(Optional::empty);
    }

    @Override
    public Optional<List<Rule<T>>> getAllFailed() {
        return Optional.of(rulesList.stream()
                .filter(rule -> rule.validate(object))
                .toList());
    }
}
