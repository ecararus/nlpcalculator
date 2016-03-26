package com.eca.nlp.kb.model;

import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.Set;

import static java.util.Objects.requireNonNull;

public final class Operator implements Arithmetical {

    @NotNull
    private final String arithmetical;
    @NotNull
    private final Set<String> human;

    public Operator(String arithmetical, Set<String> human) {
        requireNonNull(arithmetical);
        requireNonNull(human);
        this.arithmetical = arithmetical;
        this.human = Collections.unmodifiableSet(human);
    }

    @Override
    public String getArithmetical() {
        return arithmetical;
    }

    public Set<String> getHuman() {
        return human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operator operator = (Operator) o;
        return getArithmetical().equals(operator.getArithmetical()) && getHuman().equals(operator.getHuman());
    }

    @Override
    public int hashCode() {
        int result = getArithmetical().hashCode();
        result = 31 * result + getHuman().hashCode();
        return result;
    }
}
