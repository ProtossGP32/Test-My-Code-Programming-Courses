package borderpane;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {


    public static void main(String[] args) {

        launch(BorderPaneApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create a new BorderPane
        BorderPane layout = new BorderPane();
        // Set some labels at the borders
        Label labelNorth = new Label("NORTH");
        Label labelEast = new Label("EAST");
        Label labelSouth = new Label("SOUTH");
        Label labelWest = new Label("WEST");
        Label labelCenter = new Label("CENTER");

        layout.setTop(labelNorth);
        layout.setRight(labelEast);
        layout.setBottom(labelSouth);
        layout.setLeft(labelWest);
        layout.setCenter(labelCenter);

        BorderPane.setAlignment(labelNorth, Pos.TOP_CENTER);
        BorderPane.setAlignment(labelEast, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(labelSouth, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(labelWest, Pos.CENTER_LEFT);
        BorderPane.setAlignment(labelCenter, Pos.CENTER);

        // Create a new Scene
        Scene view = new Scene(layout);

        // Set the scene and show it
        stage.setScene(view);
        stage.show();
    }
}
