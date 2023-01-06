package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);

    }

    @Override
    public void start(Stage stage) throws Exception {
        // Define three different views
        // - First view: Define the UI elements inside the first layout
        Label firstViewTopLabel = new Label("First view!");
        Button firstViewCenterButton = new Button("To the second view!");
        // - First view: BorderPane layout
        BorderPane firstLayout = new BorderPane();
        // - Add UI elements inside the layout
        firstLayout.setTop(firstViewTopLabel);
        firstLayout.setCenter(firstViewCenterButton);
        // - First view: Align the UI elements within the layout
        BorderPane.setAlignment(firstViewTopLabel, Pos.TOP_CENTER);
        BorderPane.setAlignment(firstViewCenterButton, Pos.CENTER);
        // - Add layout inside the first scene
        Scene firstScene = new Scene(firstLayout);


        // - Second view: Define the UI elements inside the second layout
        Button secondViewTopButton = new Button("To the third view!");
        Label secondViewBottomLabel = new Label("Second view!");
        // - Second view: VBox layout
        // - Second view: Add UI elements inside the layout
        VBox secondLayout = new VBox(secondViewTopButton, secondViewBottomLabel);
        secondLayout.setSpacing(20);
        // - Add layout inside the second scene
        Scene secondScene = new Scene(secondLayout);

        // - Third view: Define the UI elements inside the third view
        Label thirdViewOriginText = new Label("Third view!");
        Button thirdViewEndButton = new Button("To the first view!");
        // - Third view: GridPane layout
        GridPane thirdLayout = new GridPane();
        // - Third view: Add UI elements inside the layout
        thirdLayout.add(thirdViewOriginText, 0, 0);
        thirdLayout.add(thirdViewEndButton, 1, 1);
        // - Add layout inside the third scene
        Scene thirdScene = new Scene(thirdLayout);


        // Event Handlers:
        // - First scene:
        firstViewCenterButton.setOnAction(actionEvent -> {
            stage.setScene(secondScene);
        });
        // - Second scene:
        secondViewTopButton.setOnAction(actionEvent -> {
            stage.setScene(thirdScene);
        });
        // - Third scene:
        thirdViewEndButton.setOnAction(actionEvent -> {
            stage.setScene(firstScene);
        });

        // Set the initial scene and show it
        stage.setScene(firstScene);
        stage.show();
    }
}
