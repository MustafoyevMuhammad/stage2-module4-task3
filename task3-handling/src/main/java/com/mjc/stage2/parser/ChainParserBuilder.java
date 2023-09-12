package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        // Write your code here!
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        AbstractTextParser abstractTextParser = parsers.get(0);
        for (int i = 0; i < parsers.size(); i++) {
            if(abstractTextParser != null)
                abstractTextParser.setParser(parsers.get(i));
        }
        // Write your code here!
        return abstractTextParser;
    }
}
