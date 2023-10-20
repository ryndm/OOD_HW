// rdmello
package edu.syr.hw6;

public abstract class TextDecorator extends TextElement {
    protected TextElement textElement;

    public TextDecorator(TextElement textElement) {
        super(textElement.content);
        this.textElement = textElement;
    }


    @Override
    public abstract String toMarkdown();
}
