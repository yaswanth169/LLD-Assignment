package org.example.fileparser;

public class ParserFactory {
    public static Parser getParser(String type) {
        if(type.equalsIgnoreCase("json")) {
            return new JsonParser();
        }

        if(type.equalsIgnoreCase("xml")) {
            return new XmlParser();
        }

        if(type.equalsIgnoreCase("csv")) {
            return new CsvParser();
        }
        throw new IllegalArgumentException(
                "Unsupported parser type: " + type
        );
    }
}