package jabberpoint;

import java.awt.Color;
import java.awt.Font;

/**
 * <p>JabberPoint.JabberPoint.Style is for Indent, Color, Font and Leading.</p>
 * <p>Direct relation between style-number and item-level:
 * in JabberPoint.JabberPoint.Slide style if fetched for an item
 * with style-number as item-level.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 * @version 2.0 2024/04/07 Caterina Aresti & Joey Kramer
 */

public class Style {
    private static Style[] styles; // de styles

    private static final String FONTNAME = "Helvetica";
    int indent;
    Color color;
    Font font;
    int fontSize;
    int leading;

    public static void createStyles() {
        styles = new Style[5];
        // The styles are fixed.
        styles[0] = new Style(0, Color.red, 48, 20);    // style for item-level 0
        styles[1] = new Style(20, Color.blue, 40, 10);    // style for item-level 1
        styles[2] = new Style(50, Color.black, 36, 10);    // style for item-level 2
        styles[3] = new Style(70, Color.black, 30, 10);    // style for item-level 3
        styles[4] = new Style(90, Color.black, 24, 10);    // style for item-level 4
    }

    public static Style getStyle(int level) {
        if (level >= styles.length) {
            level = styles.length - 1;
        }
        return styles[level];
    }

    public Style(int indent, Color color, int points, int leading) {
        this.indent = indent;
        this.color = color;
        font = new Font(FONTNAME, Font.BOLD, fontSize = points);
        this.leading = leading;
    }

    public String toString() {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }
}