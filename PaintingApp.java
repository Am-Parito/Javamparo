package paintCanvas;

import java.awt.*;
import java.awt.event.*;

public class PaintingApp {
    public static void main(String[] args) {
        BasicFrame f = new BasicFrame("Paint Canvas");
        MouseCanvas drawing = new MouseCanvas();
        ColorChoice colorMenu = new ColorChoice();
        colorMenu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    String selectedColor = e.getItem().toString();
                    drawing.currentColor = colorMenu.getColorFromString(selectedColor);
                }
            }
        });
        Button reset = new Button("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing.listOfLines.clear();
                drawing.repaint();
            }
        });
        Panel p = new Panel();
        p.add(colorMenu);
        p.add(reset);
        f.add(drawing, BorderLayout.CENTER);
        f.add(p, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
