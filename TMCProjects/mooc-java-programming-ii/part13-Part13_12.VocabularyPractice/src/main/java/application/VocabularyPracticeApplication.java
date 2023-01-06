package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        // Init is similar to a constructor in that it initializes variables
        // 1. Create the dictionary that the application uses
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 2. Create the views ("subviews")
        PracticeView practiceView = new PracticeView(this.dictionary);
        InputView inputView = new InputView(this.dictionary);

        // 3. Create the higher level layout
        BorderPane layout = new BorderPane();

        // 3.1. Create the UI elements
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        // 3.2. Create the menu for the general layout and apply some alignment and padding
        HBox menu = new HBox(enterButton, practiceButton);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 3.3. Add the menu to the higher level layout
        layout.setTop(menu);

        // 4. Event Handlers: connect the subviews with the buttons
        // 4.1. enterButton shows the inputView
        enterButton.setOnAction(actionEvent -> layout.setCenter(inputView.getView()));
        // 4.2. practiceButton shows the practiceView
        practiceButton.setOnAction(actionEvent -> layout.setCenter(practiceView.getView()));

        // 5. First show the input view
        layout.setCenter(inputView.getView());

        // 6. Create the main view and add the high level layout
        Scene view = new Scene(layout, 400, 300);

        // 7. Show the application
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
