package com.epam.workingwithregex;

public class TaskLauncher {

    // task 01
    private static final String TEXT = "The Java launcher launches Java by loading a given class (specified on the " +
            "command line or as an attribute in a JAR) and starting its public static void main(String[]) method. " +
            "Stand-alone programs must declare this method explicitly. The String[] args parameter is an array of " +
            "String objects containing any arguments passed to the class. The parameters to main are often passed " +
            "by means of a command line.\n" +
            "Printing is part of a Java standard library: The System class defines a public static field called out. " +
            "The out object is an instance of the PrintStream class and provides many methods for printing data to " +
            "standard out, including println(String) which also appends a new line to the passed string.\n" +
            "The string \"Hello World!\" is automatically converted to a String object by the compiler.";

    // task 02
    private static final String XML =
            "<notes>\n" +
                    "   <note id = \"1\">\n" +
                    "       <to>Вася</to>\n" +
                    "       <from>Света</from>\n" +
                    "       <heading>Напоминание</heading>\n" +
                    "       <body>Позвони мне завтра!</body>\n" +
                    "   </note>\n" +
                    "   <note id = \"2\">\n" +
                    "       <to>Петя</to>\n" +
                    "       <from>Маша</from>\n" +
                    "       <heading>Важное напоминание</heading>\n" +
                    "       </body>\n" +
                    "   </note>\n" +
                    "</notes>";
    private static final char SPECIFIED_CHARACTER = 'a';

    public static void main(String[] args) {
        // task 01
        System.out.println("// TASK 01 //\n\nThe original text:\n" + TEXT + "\n");
        System.out.println("The text with paragraphs sorted by the number of sentences:\n" + TextParser.
                sortParagraphsByNumberOfSentences(TEXT));
        System.out.println("The text with words in sentences sorted by the length:\n" + TextParser.
                sortWordsByLengthInSentences(TEXT));
        System.out.println("The text with words in sentences sorted by occurrences of character \"" +
                SPECIFIED_CHARACTER + "\":\n" + TextParser.sortWordsByNumberOfOccurrencesOfCharacter(TEXT,
                SPECIFIED_CHARACTER));

        // task 02
        System.out.println("// TASK 02 //\n");
        System.out.println(XmlParser.parse(XML));

    }
}
