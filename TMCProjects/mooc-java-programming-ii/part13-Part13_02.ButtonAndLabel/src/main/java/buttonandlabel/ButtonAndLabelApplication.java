package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button buttonComponent = new Button("This is a button");
        Label textComponent = new Label("Text element");

        FlowPane componentGroup = new FlowPane();
        // Add the UI elements into the layout
        componentGroup.getChildren().add(textComponent);
        componentGroup.getChildren().add(buttonComponent);

        // Initialize the Scene
        Scene view = new Scene(componentGroup);

        // Set the scene in the stage and show it
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }
}
