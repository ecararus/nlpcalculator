package com.eca.nlp.kb.transformer;

/**
 * Transformer from human to arithmetical language.
 * E.G. "add" to "+" or "three" to "3"
 */
public interface LexicalTransformer {

    <T> T toArithmetical(String human);

}
