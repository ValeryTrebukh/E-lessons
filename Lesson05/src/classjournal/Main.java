package classjournal;

import classjournal.controller.JournalController;
import classjournal.model.JournalModel;
import classjournal.view.JournalView;

public class Main {

    public static void main(String[] args) {
        JournalModel model = new JournalModel();
        JournalView view = new JournalView();
        JournalController controller = new JournalController(model, view);

        controller.run();
    }
}
