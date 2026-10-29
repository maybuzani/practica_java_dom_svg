import java.awt.Graphics2D;
import java.awt.Color;

public abstract class FiguraSVG {
    protected Color strokeColor = Color.BLACK;
    protected Color fillColor = null;
    protected float strokeWidth = 1.0f;

    public abstract void dibujar(Graphics2D g2d);

    public void setStroke(String stroke) {
        if (stroke != null && !stroke.equals("none")) {
            this.strokeColor = parseColor(stroke);
        }
    }

    public void setFill(String fill) {
        if (fill != null && !fill.equals("none")) {
            this.fillColor = parseColor(fill);
        }
    }

    public void setStrokeWidth(String width) {
        if (width != null && !width.isEmpty()) {
            try {
                this.strokeWidth = Float.parseFloat(width);
            } catch (NumberFormatException e) {
                this.strokeWidth = 1.0f;
            }
        }
    }

    protected Color parseColor(String colorStr) {
        if (colorStr.startsWith("#")) {
            return Color.decode(colorStr);
        }
        switch (colorStr.toLowerCase()) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "yellow": return Color.YELLOW;
            case "orange": return Color.ORANGE;
            case "black": return Color.BLACK;
            case "white": return Color.WHITE;
            case "pink": return Color.PINK;
            case "purple": return new Color(128, 0, 128);
            case "navy": return new Color(0, 0, 128);
            case "lightblue": return new Color(173, 216, 230);
            case "lightgreen": return new Color(144, 238, 144);
            default: return Color.BLACK;
        }
    }
}