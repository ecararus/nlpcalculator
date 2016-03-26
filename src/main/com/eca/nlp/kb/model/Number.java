package com.eca.nlp.kb.model;

import com.sun.istack.internal.NotNull;

import static java.util.Objects.requireNonNull;

public final class Number implements Arithmetical {

    @NotNull
    private final String arithmetical;
    @NotNull
    private final String human;

    public Number(String arithmetical, String human) {
        requireNonNull(arithmetical);
        requireNonNull(human);
        this.arithmetical = arithmetical;
        this.human = human;
    }

    @Override
    public String getArithmetical() {
        return arithmetical;
    }

    public String getHuman() {
        return human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;
        return getArithmetical().equals(number.getArithmetical()) && getHuman().equals(number.getHuman());
    }

    @Override
    public int hashCode() {
        int result = getArithmetical().hashCode();
        result = 31 * result + getHuman().hashCode();
        return result;
    }
}
