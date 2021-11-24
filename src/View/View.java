package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame
{
    BlockingQueue<Message> queue;
    JLabel redLabel;
    JTextField redTestField;
    JLabel greenLabel;
    JTextField greenTestField;
    JLabel blueLabel;
    JTextField blueTestField;
    JButton updateButton;
    JButton resetButton;
    BarGraph graph;

    public View(BlockingQueue<Message> queue)
    {
        this.queue = queue;
        this.graph = new BarGraph(0,0,0);

        this.redLabel = new JLabel("Red:");

        this.redTestField = new JTextField(5);
        this.redTestField.setText("0");

        this.greenLabel = new JLabel("Green");

        this.greenTestField = new JTextField(5);
        this.greenTestField.setText("0");

        this.blueLabel = new JLabel("Blue:");

        this.blueTestField = new JTextField(5);
        this.blueTestField.setText("0");

        this.updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            String redValue = redTestField.getText();
            String greenValue = greenTestField.getText();
            String blueValue = blueTestField.getText();
            try {
                Message message = new UpdateMessage(redValue, greenValue, blueValue);
                queue.put(message);
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

        this.resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            try {
                Message message = new ResetMessage();
                queue.put(message);
            } catch (InterruptedException exception) {
                // do nothing
            }
        });

        this.add(redLabel);
        this.add(redTestField);
        this.add(greenLabel);
        this.add(greenTestField);
        this.add(blueLabel);
        this.add(blueTestField);
        this.add(updateButton);
        this.add(resetButton);

        this.add(graph);

        this.setSize(600, 600);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void updateBarView(int redValue, int greenValue, int blueValue)
    {
       this.redTestField.setText(String.valueOf(redValue));
       this.greenTestField.setText(String.valueOf(greenValue));
       this.blueTestField.setText(String.valueOf(blueValue));

       this.graph.setHeight(redValue,greenValue,blueValue);
    }
}
