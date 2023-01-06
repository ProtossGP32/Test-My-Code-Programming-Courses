package textstatistics;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {


    public static void main(String[] args) {

        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Initialize a layout
        BorderPane layout = new BorderPane();

        // Create the UI elements
        TextArea textArea = new TextArea("");
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

        // EventHandlers
        // textArea: listener
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            // Count the number of letters
            int characters = newValue.length();
            int words = 0;
            String longest = "";
            // Count the number of words
            if (characters > 0) {
                String[] parts = newValue.split(" ");
                words = parts.length;
                // Retrieve the longest by using streams
                // - Sort words by its length: Comparator is (s2.length() - s1.length())
                //      - If both are equally long, return 0
                //      - If first is longer, return negative value
                //      - If second is longer, return positive value

                longest = Arrays.stream(parts)
                        .sorted((s1, s2) -> s2.length() - s1.length())
                        .findFirst()
                        .get();
            }

            // Set the new text elements' values
            numberOfLetters.setText("Letters: " + characters);
            numberOfWords.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });

        // Initialize the Scene
        Scene view = new Scene(layout);

        // Set the scene and show it
        stage.setScene(view);
        stage.show();
    }
}
