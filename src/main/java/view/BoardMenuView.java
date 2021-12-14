package view;

import controller.menusControllers.BoardMenuController;

public class BoardMenuView extends MenuView{
    private static BoardMenuView boardMenuView = null;
    BoardMenuController boardMenuController = new BoardMenuController();
    public BoardMenuView() {
        super("Board Menu");
    }

    public static BoardMenuView getInstance() {
        if (boardMenuView == null){
            boardMenuView = new BoardMenuView();
        }
        return boardMenuView;
    }

    @Override
    public void run() {

    }
}
