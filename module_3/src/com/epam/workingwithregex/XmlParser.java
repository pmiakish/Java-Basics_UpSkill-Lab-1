package com.epam.workingwithregex;

import java.util.regex.*;

public class XmlParser {

    public static String parse(String xml) {
        StringBuilder parsedXML = new StringBuilder();
        Pattern openingTag = Pattern.compile("<[^/].+?>");
        Matcher matOpeningTag = openingTag.matcher(xml);
        while (matOpeningTag.find()) {
            String nameOfTag = defineNameOfTag(matOpeningTag.group());
            if (!nameOfTag.isEmpty()) {
                Pattern closingTag = Pattern.compile("</" + nameOfTag + ">");
                Matcher matClosingTag = closingTag.matcher(xml);
                if (matClosingTag.find(matOpeningTag.start())) {
                    parsedXML.append("--- the node \"").append(nameOfTag).append("\" ---\n");
                    String attributesOfTag = defineAttributesOfTag(matOpeningTag.group());
                    if (!attributesOfTag.isEmpty()) {
                        parsedXML.append("Attributes of tag: ").append(attributesOfTag).append("\n");
                    }
                    parsedXML.append(xml, matOpeningTag.end(), matClosingTag.start()).append("\n--- the end of ").
                            append("the node \"").append(nameOfTag).append("\" --- \n\n");
                }
            }
        }
        return parsedXML.toString();
    }

    private static String defineNameOfTag(String tag) {
        Pattern tagName = Pattern.compile("[A-Za-z0-1]+");
        Matcher matName = tagName.matcher(tag);
        return (matName.find()) ? matName.group() : "";
    }
    private static String defineAttributesOfTag(String tag) {
        Pattern attributes = Pattern.compile("(\\S+\\s*=\\s*\"\\S+\"\\s*)+");
        Matcher matAttributes = attributes.matcher(tag);
        return (matAttributes.find()) ? matAttributes.group() : "";
    }

}
