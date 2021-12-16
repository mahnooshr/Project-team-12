package controller.menusControllers;

import view.*;

import java.util.HashMap;

public class TeamMenuController extends MenuController{

    private static final HashMap<String, MenuView> allMenus = new HashMap<>();

    static {
        allMenus.put("Scoreboard", ScoreboardView.getInstance());
        allMenus.put("Chatroom", ChatRoomView.getInstance());
        allMenus.put("RoadMaps", RoadMapsView.getInstance());
        allMenus.put("Board", BoardMenuView.getInstance());
    }



    public TeamMenuController(String name) {
        super(name);
    }


    public String menuEnter(String menuName) {
        if (allMenus.containsKey(menuName)){
            return "subMenu entered successfully";
        }
        else return "subMenu name does not exists";
    }


    public HashMap<String, MenuView> getAllMenus() {
        return allMenus;
    }
}
