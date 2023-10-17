import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;

import javax.swing.border.Border;



public class source extends Panel{

    Panel topPanel,bottomPanel,
            bottomPanel_left,bottomPanel_mid,bottomPanel_right;


    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Rectangle(int x,int y,int width,int height));
    }
    
    public source(){

        setLayout (new GridLayout(2,3));

        topPanel = new Panel(new BorderLayout());
        Graphics object;
        int x = 10;
        int y = 10;
        Graphics rectangle = new drawRect(x,y,10,10);
        topPanel.add(rectangle);
    }
}