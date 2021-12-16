package view;

import controller.menusControllers.CalenderController;

public class CalenderMenuView extends MenuView{
    private static CalenderMenuView calenderMenuView = null;
    CalenderController calenderController = new CalenderController();
    public CalenderMenuView() {
        super("calender menu");
    }


    public static CalenderMenuView getInstance() {
        if (calenderMenuView == null){
            calenderMenuView = new CalenderMenuView();
        }
        return calenderMenuView;
    }

    @Override
    public void run() {

    }
}
