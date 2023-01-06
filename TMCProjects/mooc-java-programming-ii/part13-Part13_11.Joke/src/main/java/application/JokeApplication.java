package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class JokeApplication extends Application {

    private List<String[]> jokesList;
    private final Random random = new Random();
    private int currentJoke = 0;
    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 0. Prepare the list of jokes
        this.jokesList = new ArrayList<>();
        this.jokesList.add(new String[] {"What do you call a bear with no teeth?", "A gummy bear.", "Just like the candies"});
        this.jokesList.add(new String[] {"Why are fish so easy to weigh?", "Because they have their own scales", "The joke here is on the scales word, both being a measurement tool and a fish part"});
        this.jokesList.add(new String[] {"Why is that all cats dislike flying saucers?", "Because it is impossible for them to reach the milk.", "Cats usually drink milk in plates or saucers"});
        this.jokesList.add(new String[] {"Why is it that we don't eat clowns?", "They taste funny", "The joke's on the 'funny' word, if we consider clowns funny people..."});

        // 1. Create main layout
        BorderPane mainLayout = new BorderPane();

        // 1.1. First create the UI elements
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        // 1.2. Then create a menu for the main layout
        HBox jokesMenu = new HBox(jokeButton, answerButton, explanationButton);

        // 1.3. Adjust the menu
        jokesMenu.setPadding(new Insets(20, 20, 20, 20));
        jokesMenu.setSpacing(10);

        // 1.4. Add the menu to the main layout
        mainLayout.setTop(jokesMenu);

        // 2. Add subviews for each button
        // 2.1. Create subview labels
        // - Initialize with the first joke
        // (Optional - non-complying with tests) Select a random joke
        //AtomicReference<AtomicReferenceArray<String>> newJoke = new AtomicReference<>(new AtomicReferenceArray<>(pickRandomJoke()));
        AtomicReference<AtomicReferenceArray<String>> newJoke = new AtomicReference<>(new AtomicReferenceArray<>(this.jokesList.get(0)));
        Label jokeText = new Label(newJoke.get().get(0));
        Label answerText = new Label(newJoke.get().get(1));
        Label explanationText = new Label(newJoke.get().get(2));

        // 2.2. Create subview layouts
        StackPane jokeLayout = this.createView(jokeText);
        StackPane answerLayout = this.createView(answerText);
        StackPane explanationLayout = this.createView(explanationText);

        // 2.3. Event handlers:
        // - Joke button: randomly picks a new joke and shows it
        jokeButton.setOnAction(actionEvent -> {
            // (Optional) Update the joke to show
            //newJoke.set(new AtomicReferenceArray<>(pickRandomJoke()));
            //jokeText.setText(newJoke.get().get(0));
            //answerText.setText(newJoke.get().get(1));
            //explanationText.setText(newJoke.get().get(2));

            // Change the layout to the joke one
            mainLayout.setCenter(jokeLayout);
        });

        // - Answer button: shows the answer to that joke
        answerButton.setOnAction(actionEvent -> mainLayout.setCenter(answerLayout));

        // - Explanation button: shows the explanation to that joke
        explanationButton.setOnAction(actionEvent -> mainLayout.setCenter(explanationLayout));

        // 2.4. Set the initial view
        mainLayout.setCenter(jokeLayout);

        // 3. Create the main scene
        Scene scene = new Scene(mainLayout);
        // 2.5. Show the main scene
        stage.setScene(scene);
        stage.show();

    }

    private StackPane createView(Label label) {
        StackPane newJokeView = new StackPane(
                label
        );
        newJokeView.setPrefSize(300, 180);
        newJokeView.setAlignment(Pos.CENTER);

        return newJokeView;
    }

    private String[] pickRandomJoke() {
        // Pick a random number within the range of available jokes
        int numJokes = this.jokesList.size();
        int jokeNum = this.random.nextInt(this.jokesList.size());
        while (jokeNum == this.currentJoke) {
            jokeNum = this.random.nextInt(this.jokesList.size());
        }
        this.currentJoke = jokeNum;
        return this.jokesList.get(jokeNum);
    }
}
