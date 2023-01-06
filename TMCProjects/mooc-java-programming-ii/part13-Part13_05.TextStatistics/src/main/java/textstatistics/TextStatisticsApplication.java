package textstatistics;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {

        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Initialize a layout
        BorderPane layout = new BorderPane();

        // Create the UI elements
        TextArea textArea = new TextArea("This is a text area");
        // Create three text components inside an HBox
        Label numberOfLetters = new Label("Letters: 0");
        Label numberOfWords = new Label("Words: 0");
        Label longestWord = new Label("The longest word is:");
        HBox textStatistics = new HBox(numberOfLetters, numberOfWords, longestWord);
        textStatistics.setSpacing(10);

        // Assign the elements to the layout
        layout.setCenter(textArea);
        layout.setBottom(textStatistics);
        // Set alignments
        BorderPane.setAlignment(textArea, Pos.TOP_CENTER);
        BorderPane.setAlignment(textStatistics, Pos.BOTTOM_CENTER);

        // Initialize the Scene
        Scene view = new Scene(layout);

        // Set the scene and show it
        stage.setScene(view);
        stage.show();
    }
}
