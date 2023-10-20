// rdmello
package edu.syr.hw6;

public class Runner {
    public static void main(String[] args) {
        TextElement[] pangram = new TextElement[9];
        pangram[0] = new TextElement("The");
        pangram[1] = new Italic(new TextElement("quick"));
        pangram[2] = new Bold(new TextElement("bold"));
        pangram[3] = new TextElement("fox");
        pangram[4] = new TextElement("jumps");
        pangram[5] = new TextElement("over");
        pangram[6] = new TextElement("the");
        pangram[7] = new StrikeThru(new TextElement("lazy"));
        pangram[8] = new TextElement("dog");

        StringBuilder justText = new StringBuilder();
        StringBuilder markdown = new StringBuilder();

        for (TextElement e : pangram) {
            justText.append(e.toString()).append(" ");
            markdown.append(e.toMarkdown()).append(" ");
        }

        System.out.println(justText.toString().trim());
        // The quick bold fox jumps over the lazy dog
        System.out.println(markdown.toString().trim());
        // The *quick* **bold** fox jumps over the ~~lazy~~ dog
    }
}
