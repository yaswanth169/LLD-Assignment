package org.example.fileparser;

public class FileParserUtility {
    // Requirements :
//    1. Support JSON
//    2. Support XML
//    3. Support CSV
//    4. Pick correct parser based on input

    // Example : if user uploads any type of json like user.json it should pick up the JsonParser , Similarly with the remainin parsers as well...
    // My first Understanding would be like :

    // if else cases like checking the file type and working with it ... if file type is json call the json object and work with it....
//    public void parse(String fileType) {
//        if (fileType.equals("json")) {
//            JsonParser parser = new JsonParser();
//            parser.parse();
//        } else if (fileType.equals("xml")) {
//            XmlParser parser = new XmlParser();
//            parser.parse();
//        } else if (fileType.equals("csv")) {
//            CsvParser parser = new CsvParser();
//            parser.parse();
//        }
//    }
    // Same if someone comes i need some support of the parsers like pdf etc... more..
    // again we will be focussing on the if else... increaidng them... if we clearly observe here its not just if else only there is a overload or object creation increments..
//    new JsonParser()
//    new XmlParser()
//    new CsvParser()

//    The client decides:
//    Which object to create
//    How to create it
//    When to create it : Too much responsibility right...


    // The first thing we can think of is : what is changing : here the chnaging thing is : object creation.. means there is always a same condition but different object creation...

//    Create different objects
//    based on some condition : our focus should only be on the Factory Pattern


//    1. Factory Pattern : I used a Factory Pattern to centralize the creation of parser objects (JsonParser, XmlParser, CsvParser) based on the input file type.
//    2. The parser object that needs to be created depends on the file type, and I wanted to avoid object creation logic being changed throughout the application.
//    3. if else... approach
}
