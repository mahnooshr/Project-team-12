package view;

import controller.menusControllers.ChatRoomController;

public class ChatRoomView extends MenuView{
    private static ChatRoomView chatRoomView = null;
    ChatRoomController chatRoomController = new ChatRoomController();
    public ChatRoomView() {
        super("chatroom menu");
    }

    public static ChatRoomView getInstance() {
        if(chatRoomView == null){
            chatRoomView = new ChatRoomView();
        }
        return chatRoomView;
    }
    @Override
    public void run() {

    }
}
