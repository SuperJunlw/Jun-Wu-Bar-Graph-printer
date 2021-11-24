import Model.*;
import Controller.*;
import View.*;

import java.util.concurrent.*;

public class App
{
    public static void main(String[] args)
    {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        Model model = new Model();
        View view = new View(queue);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}
