package view;

import controller.menuController.TaskPageController;
import controller.responses.TaskPageResponses;
import controller.Controller.UtilityController;

public class TaskPage extends Menu {
        private static view.TaskPage taskPage;
        TaskPageController taskPageController = new TaskPageController();
        TaskPageResponses responses;
        private TaskPage() {
            super("Task Page");
        }

        public static view.TaskPage getInstance() {
            if (taskPage == null)
                taskPage = new view.TaskPage();
            return taskPage;
        }

        @Override
        public void scanInput() {
            while (true) {
                String input = UtilityController.getNextLine();

                //else System.out.println("invalid command");
                if (super.isExit) {
                    super.isExit = false;
                    return;
                }
            }

        }


    }
