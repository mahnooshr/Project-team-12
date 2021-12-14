package view;

import controller.menusControllers.ProfileController;
import controller.utilityController.UtilController;

public class ProfileMenuView extends MenuView {
    private static ProfileMenuView profileMenuView = null;
    ProfileController profileController = new ProfileController();

    public ProfileMenuView() {
        super("profile menu");
    }

    public static ProfileMenuView getInstance() {
        if (profileMenuView == null) {
            profileMenuView = new ProfileMenuView();
        }
        return profileMenuView;
    }

    @Override
    public void run() {
        while (true) {
            UtilController.printString(this.getName() + "\n");
            String command = UtilController.getInput();
            if (command.startsWith("Profile --change --oldPassword")){
                System.out.println();
            }else if (command.startsWith("Profile --change --username")){
                System.out.println();
            }else if (command.equals("Profile --showTeams")){
                System.out.println();
            }else if (command.startsWith("Profile -showTeam")){
                System.out.println();
            }else if (command.equals("Profile --show --myProfile")){
                System.out.println();
            }else if(command.equals("Profile show notifications")){
                System.out.println();
            }else if (command.equals("back")){
                System.out.println();
            }
            else {
                UtilController.printString("invalid command");
            }
            if (exit){
                exit = false;
                return;
            }
        }
    }
}
