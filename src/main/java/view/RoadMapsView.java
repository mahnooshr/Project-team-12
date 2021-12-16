package view;

import controller.menusControllers.RoadMapsController;

public class RoadMapsView extends MenuView{
    private static RoadMapsView roadMapsView = null;
    private static final RoadMapsController roadMapsController = new RoadMapsController();
    public RoadMapsView() {
        super("RoadMaps");
    }

    public static RoadMapsView getInstance() {
        if (roadMapsView==null){
            roadMapsView = new RoadMapsView();
        }
        return roadMapsView;
    }

    @Override
    public void run() {

    }
}
