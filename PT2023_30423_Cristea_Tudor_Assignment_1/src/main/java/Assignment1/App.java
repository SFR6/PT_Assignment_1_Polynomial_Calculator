package Assignment1;

import Assignment1.controllers.MainController;
import Assignment1.models.Polynomial;
import Assignment1.views.MainView;

public class App
{
    public static void main(String[] args)
    {
        MainView mainView = new MainView();

        MainController mainController = new MainController(mainView);
    }
}