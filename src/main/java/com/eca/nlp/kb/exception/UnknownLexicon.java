package com.eca.nlp.kb.exception;

public class UnknownLexicon extends RuntimeException {

    public UnknownLexicon() {
        super("Malformed expression");
    }

    public UnknownLexicon(String message) {
        super(message);
    }
}
