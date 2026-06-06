package org.example;

import org.example.fileparser.Parser;
import org.example.fileparser.*;

public class Main {
    public static void main(String[] args) {
        Parser parser = ParserFactory.getParser("csv");
        parser.parse();
    }
}
