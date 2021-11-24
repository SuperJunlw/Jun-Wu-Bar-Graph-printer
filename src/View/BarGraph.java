package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BarGraph extends JComponent
{
    int redHeight;
    int greenHeight;
    int blueHeight;

    public BarGraph(int redHeight, int greenHeight, int blueHeight)
    {
        this.redHeight = redHeight;
        this.greenHeight = greenHeight;
        this.blueHeight = blueHeight;
    }

    public void setHeight(int red, int green, int blue)
    {
        this.redHeight = red;
        this.greenHeight = green;
        this.blueHeight = blue;

        repaint();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(500,500);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        //to paint the bars

        Rectangle2D.Double redBar = new Rectangle2D.Double(125, 500-10*redHeight, 40, 10*redHeight);
        Rectangle2D.Double greenBar = new Rectangle2D.Double(225,500-10*greenHeight, 40, 10*greenHeight);
        Rectangle2D.Double blueBar = new Rectangle2D.Double(325, 500-10*blueHeight, 40, 10*blueHeight);

        g2.setColor(Color.red);
        g2.fill(redBar);
        g2.setColor(Color.green);
        g2.fill(greenBar);
        g2.setColor(Color.blue);
        g2.fill(blueBar);
    }
}

