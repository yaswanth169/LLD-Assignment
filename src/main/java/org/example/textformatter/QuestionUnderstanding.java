package org.example.textformatter;

public class QuestionUnderstanding {
//    Requirements :
//            1. Apply Bold
//            2. Apply Italic
//            3. Apply Underline
//            4. Allow multiple formats dynamically
//
//    My initial thinking is :
//    Suppose if i started thinking to create multiple classes like this :
//    class PlainText
//    class BoldText
//    etc..
//
//    and suddenly the requirement changes to Bold + Italic -> in this way we need to have the new class again right...
//    assume in this way if they ask n number of types.. then we should start creating all those..
//
//    Number of classes explodes-> if we add colors and all ... it will be like we will be keep adding the stuff..
//
//    Here if we observe clearly the changing one is : Formatting behavior.
//    In this way we want the :
//        Take an object
//        Wrap new behavior around it
//        Without changing original object
//
//    When ever we want to think of Add behavior dynamically and Combine behaviors the idea of pattern we should think of is Decorator Pattern...

//    Base Class -> Text
//
//    interface Text {
//        String format();
//    }
//        Plain Text -> implements the main...
//
//    class PlainText implements Text {
//
//        private String text;
//
//        public PlainText(String text) {
//            this.text = text;
//        }
//
//        public String format() {
//            return text;
//        }
//    }

//    Every decorator should also be a Text.
//
//    abstract class TextDecorator
//            implements Text {
//
//        protected Text text;
//
//        public TextDecorator(Text text) {
//            this.text = text;
//        }
//    }
//
//
//    class BoldDecorator
//            extends TextDecorator {
//
//        public BoldDecorator(Text text) {
//            super(text);
//        }
//
//        public String format() {
//            return "<b>" + text.format() + "</b>";
//        }
//    }
//
//    Italic Decorator
//    Underline Decorator
//
//
//    Text text = new PlainText("Hello");
//    System.out.println(text.format());

//    1. Decorator Pattern.
//    2. Formatting features such as Bold, Italic, and Underline can be added dynamically and combined in different ways.
//    Decorator allows adding behavior to an object without modifying the original class and avoids creating numerous subclasses for every formatting combinations
//    3. Chain of Responsibility : Apply formatting steps one after another through a processing chain, though Decorator is a cleaner fit because each formatter wraps and enhances the same object.


}
