// rdmello
package edu.syr.hw6;

public class Bold extends TextDecorator {
    public Bold(TextElement textElement) {
        super(textElement);
    }

    @Override
    public String toMarkdown() {
        return "**" + textElement.toMarkdown() + "**";
    }
}