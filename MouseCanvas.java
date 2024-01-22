package paintCanvas;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MouseCanvas extends Canvas implements MouseMotionListener, MouseListener {
    Color currentColor = Color.BLUE; //default color = first color in the menu (cheating a bit :))
    Point startPosition;
    ArrayList<LineWithColor> listOfLines = new ArrayList<>();
   
    public MouseCanvas() {
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    public Rectangle defineRectangleFromLine(LineWithColor line) {
        Rectangle rectangleFromLine = new Rectangle();
        rectangleFromLine.x = Math.min(line.xStart, line.xEnd);
        rectangleFromLine.y = Math.min(line.yStart, line.yEnd);
        rectangleFromLine.width = Math.abs(line.xStart - line.xEnd);
        rectangleFromLine.height = Math.abs(line.yStart - line.yEnd);
        return rectangleFromLine;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        startPosition = e.getPoint();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        LineWithColor lineToPaint = new LineWithColor(currentColor);
        lineToPaint.xStart = startPosition.x;
        lineToPaint.yStart = startPosition.y;
        lineToPaint.xEnd = e.getPoint().x;
        lineToPaint.yEnd = e.getPoint().y;
        Rectangle clip = defineRectangleFromLine(lineToPaint);
        repaint(clip.x, clip.y, clip.width +1, clip.height +1);
        listOfLines.add(lineToPaint);
        //repaint(); gets annoying with increasing number of lines
        startPosition = e.getPoint();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        LineWithColor lineToPaint = new LineWithColor(currentColor);
        lineToPaint.xStart = startPosition.x;
        lineToPaint.yStart = startPosition.y;
        lineToPaint.xEnd = e.getPoint().x;
        lineToPaint.yEnd = e.getPoint().y;
        listOfLines.add(lineToPaint);
        //repaint(); paints everything - just in case something went wrong with the rectangles
        startPosition = e.getPoint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        /*
         * LineWithColor lineToPaint = new LineWithColor(currentColor);
         * lineToPaint.xStart = 0; lineToPaint.yStart = 0; lineToPaint.xEnd =
         * e.getPoint().x; lineToPaint.yEnd = e.getPoint().y;
         * listOfLines.add(lineToPaint); repaint();
         */
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
     
    }
    
    @Override 
    public void paint(Graphics g) {
        super.paint(g);
        for (LineWithColor line: listOfLines) {
            g.setColor(line.lineColor);
            g.drawLine(line.xStart, line.yStart, line.xEnd, line.yEnd);
        }
    }
    
}
