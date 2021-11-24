package Controller;

import View.View;
import Model.Model;
import java.util.concurrent.BlockingQueue;

public class Controller
{
    BlockingQueue<Message> queue;
    View view;
    Model model;

    public Controller(BlockingQueue<Message> queue, Model model, View view)
    {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop()
    {
        while (view.isDisplayable()) {
            Message message = null;
            //takes the message in the front of the queue
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                // do nothing
            }
            //if update is clicked
            if(message.getClass() == UpdateMessage.class)
            {
                UpdateMessage updateMsg = (UpdateMessage) message;

                int redValue = Integer.parseInt(updateMsg.getRedValue());
                if(redValue < 0) //not allowing negative number
                {
                    redValue = 0;
                }
                model.setRedBarHeight(redValue); // update model

                int greenValue = Integer.parseInt(updateMsg.getGreenValue());
                if(greenValue < 0)
                {
                    greenValue = 0;
                }
                model.setGreenBarHeight(greenValue);

                int blueValue = Integer.parseInt(updateMsg.getBlueValue());
                if(blueValue < 0)
                {
                    blueValue = 0;
                }
                model.setBlueBarHeight(blueValue);

                view.updateBarView(model.getRedBarHeight(), model.getGreenBarHeight(), model.getBlueBarHeight()); // update view
            }
            //if reset is clicked
            else if(message.getClass() == ResetMessage.class)
            {
                model.setRedBarHeight(0);
                model.setGreenBarHeight(0);
                model.setBlueBarHeight(0);
                view.updateBarView(model.getRedBarHeight(), model.getGreenBarHeight(), model.getBlueBarHeight());
            }

        }
    }
}
