// rdmello
package edu.syr.hw6;

public class Italic extends TextDecorator {
    public Italic(TextElement textElement) {
        super(textElement);
    }

    @Override
    public String toMarkdown() {
        return "*" + textElement.toMarkdown() + "*";
    }
}
