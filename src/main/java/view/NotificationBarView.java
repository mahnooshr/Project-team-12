package view;

import controller.menusControllers.NotificationBarController;

public class NotificationBarView extends MenuView{
    private static NotificationBarView notificationBarView = null;
    NotificationBarController notificationBarController = new NotificationBarController();
    public NotificationBarView() {
        super("notification bar");
    }

    public static NotificationBarView getInstance() {
        if (notificationBarView==null){
            notificationBarView = new NotificationBarView();
        }
        return notificationBarView;
    }

    @Override
    public void run() {

    }
}
