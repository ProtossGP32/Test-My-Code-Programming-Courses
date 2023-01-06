package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {


    public static void main(String[] args) {

        launch(NotifierApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create a vertical layout and include the required UI elements
        TextField textField = new TextField();
        Button updateButton = new Button("Update");
        Label notificationText = new Label();
        VBox notifierLayout = new VBox(textField, updateButton, notificationText);

        // Define the actions of the interactive elements
        updateButton.setOnAction(actionEvent -> {
            notificationText.setText(textField.getText());
        });

        // Create the scene
        Scene scene = new Scene(notifierLayout);

        // Set the scene and show it
        stage.setScene(scene);
        stage.show();

    }
}
