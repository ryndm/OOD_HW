// rdmello
package edu.syr.hw6;

public class StrikeThru extends TextDecorator {
    public StrikeThru(TextElement textElement) {
        super(textElement);
    }

    @Override
    public String toMarkdown() {
        return "~~" + textElement.toMarkdown() + "~~";
    }
}