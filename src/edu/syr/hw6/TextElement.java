// rdmello
package edu.syr.hw6;

public class TextElement {
    protected String content;

    public TextElement(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    };

    public String toMarkdown() {
        return content;
    };
}