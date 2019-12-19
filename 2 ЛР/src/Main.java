import Controller.Controller;
import View.MainWindow;

public class Main
{
    public static void main(String args[])
    {
        Controller controller=new Controller();
        MainWindow mainWindow=new MainWindow(controller);
    }
}
