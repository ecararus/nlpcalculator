package com.eca.nlp.kb.transformer;

import com.eca.nlp.kb.exception.UnknownNumber;
import com.eca.nlp.kb.model.Number;

import java.util.function.Predicate;

import static com.eca.nlp.kb.Lexicon.numbers;

final class NumberTransformer implements LexicalTransformer {

    @SuppressWarnings("unchecked")
    @Override
    public String toArithmetical(String human) {
        Number number = numbers().stream().filter(humanLexiconFilter(human)).findAny().orElseThrow(() -> new UnknownNumber(human));
        return number.getArithmetical();
    }

    private Predicate<Number> humanLexiconFilter(String human) {
        return s -> s.getHuman().equalsIgnoreCase(human);
    }
}
