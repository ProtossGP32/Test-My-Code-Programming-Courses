package ticTacToe;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ticTacToe.ui.TicTacToeView;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // UI and logic separated
        TicTacToeView ticTacTocView = new TicTacToeView();
        Parent mainLayout = ticTacTocView.getView();

        // 4. Create the scene
        Scene mainScene = new Scene(mainLayout, 280, 340);
        // 5. Set the scene and show it
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(mainScene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
