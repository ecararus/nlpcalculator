package com.eca.nlp.kb.transformer;

public final class LexicalState {

    private static final LexicalTransformer OPERATION_TRANSFORMER = new OperationTransformer();
    private static final LexicalTransformer NUMBER_TRANSFORMER = new NumberTransformer();

    private LexicalState() {
        throw new UnsupportedOperationException();
    }

    public static LexicalTransformer nextState(LexicalTransformer context) {
        return context instanceof NumberTransformer ? OPERATION_TRANSFORMER : NUMBER_TRANSFORMER;
    }
}
