package myTry;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BasicFrame extends Frame {

    public BasicFrame(String title) {
        this.setTitle(title);
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter( ) {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }  
        });
    }
}

