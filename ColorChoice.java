package paintCanvas;
import java.awt.*;

public class ColorChoice extends Choice {
    
    public ColorChoice() {
        this.addItem("blue");
        this.addItem("green");
        this.addItem("red");
        this.addItem("yellow");
        this.addItem("white");
    }
    
    public Color getColorFromString(String stringColor) {
        switch (stringColor) {
        case "blue":
            return Color.BLUE;
        case "green":
            return Color.GREEN;
        case "red":
            return Color.red;
        case "yellow":
            return Color.YELLOW;
        default:
            return Color.WHITE;
        }
    }
    
}
