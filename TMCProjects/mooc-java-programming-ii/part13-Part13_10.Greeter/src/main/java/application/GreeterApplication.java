package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 1. Creating the view for asking the username
        // 1.1 Creating UI components
        Label instructionText = new Label("Enter your name and start.");
        TextField usernameField = new TextField();
        Button startButton = new Button("Start");
        Label errorMessage = new Label();

        // 1.2 Creating layout and adding UI components
        GridPane loginView = new GridPane();

        loginView.add(instructionText, 0, 0);
        loginView.add(usernameField, 0, 1);
        loginView.add(startButton, 0, 2);
        loginView.add(errorMessage, 0, 3);

        // 1.3 Styling the layout
        loginView.setPrefSize(300, 180);
        loginView.setAlignment(Pos.CENTER);
        loginView.setVgap(10);
        loginView.setHgap(10);
        loginView.setPadding(new Insets(20, 20, 20, 20));

        // 1.4 Creating the view itself and setting it to use the login layout
        Scene loginScene = new Scene(loginView);

        // 2. Creating a view for showing the welcome message
        Label welcomeText = new Label();

        // 2.2 Creating layout and adding UI components
        StackPane welcomeLayout = new StackPane(welcomeText);

        // 2.3 Styling the layout
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.setAlignment(Pos.CENTER);

        // 2.4 Creating the view itself and setting it to use the welcome layout
        Scene welcomeScene = new Scene(welcomeLayout);

        // 3. Event handlers
        // - Start button
        startButton.setOnAction(actionEvent -> {
            if (usernameField.getText().trim().isEmpty()) {
                errorMessage.setText("Please provide a valid username");
                return;
            }
            // Set the text of the welcome text in the welcome scene
            welcomeText.setText("Welcome " + usernameField.getText() + "!");
            stage.setScene(welcomeScene);
        });

        // 4. Set the initial scene and show it
        stage.setScene(loginScene);
        stage.show();
    }
}
