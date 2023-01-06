package ticTacToe.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.stream.IntStream;

public class TicTacToeView {
    // TODO: Move all the business logic to the logic package
    private String turn;
    private Button[][] gameBoard;
    private boolean gameOver;

    public TicTacToeView() {
        this.turn = "X";
        this.gameBoard = new Button[3][3];
        this.gameOver = false;
    }

    public Parent getView() {
        // 1. Create the layouts for the UI components
        // - Top layout: BorderPane
        BorderPane mainLayout = new BorderPane();
        //     |--> BorderPane central: GridPane
        GridPane centerLayout = new GridPane();

        // 2. Create the UI elements
        // - Top: when the game is over, it shall show "The end!"
        Label turnInfo = new Label("Turn: " + this.turn);
        turnInfo.setFont(Font.font("Monospaced", 40));

        // - Center: Buttons (3x3): initialize all positions to blank
        IntStream.range(0, this.gameBoard.length)
                .forEach(row -> {
                    IntStream.range(0, this.gameBoard.length)
                            .forEach(column -> {
                                this.gameBoard[row][column] = new Button("");
                                this.gameBoard[row][column].setFont(Font.font("Monospaced", 40));
                                // Set button size
                                this.gameBoard[row][column].setMinSize(80, 80);
                                this.gameBoard[row][column].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                                // 2.2. Assign the buttons to the GridPane()
                                centerLayout.add(this.gameBoard[row][column], row, column);
                            });
                });

        // 3. Assign the UI elements to its proper layout
        // - Top layout
        mainLayout.setTop(turnInfo);
        mainLayout.setCenter(centerLayout);
        //   |--> BorderPane central: UI elements already assigned during their initialization
        centerLayout.setPadding(new Insets(10, 10, 10, 10));
        centerLayout.setHgap(10);
        centerLayout.setVgap(10);
        centerLayout.setAlignment(Pos.CENTER);

        // 4. Event handlers:
        IntStream.range(0, this.gameBoard.length)
                .forEach(row -> {
                    IntStream.range(0, this.gameBoard.length)
                            .forEach(column -> {
                                //gameBoard[row][column].setOnAction(actionEvent -> {})
                                buttonOnClickHandler(this.gameBoard[row][column], turnInfo);
                            });
                });

        return mainLayout;
    }

    private void buttonOnClickHandler(Button button, Label turnInfo) {
        button.setOnAction(actionEvent -> {
            if(!this.gameOver) {
                String textInButton = button.getText();
                if (textInButton == null || textInButton.isEmpty() || textInButton.equals("")) {
                    // Set the button value
                    setButtonTurn(button);
                    // Check if the user has won
                    this.gameOver = gameOver();
                    // Change the user turn
                    if (this.gameOver) {
                        // End the game!
                        turnInfo.setText("The end!");
                        return;
                    }
                    changeTurn();
                    turnInfo.setText("Turn: " + this.turn);
                }
            }
        });
    }
    private void setButtonTurn(Button button) {
        String textInButton = button.getText();
        if (textInButton.isEmpty() || textInButton.equals("")) {
            button.setText(String.valueOf(this.turn));
        }
    }

    private void changeTurn() {
        if (this.turn.equals("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }

    /**
     * Check if there's a game over condition
     *  - A row with the same symbol
     *  - A column with the same symbol
     *  - A diagonal with the same symbol
     *  - No more empty spaces
     * @return
     */
    private boolean gameOver() {
        // Check rows, columns and diagonals
        String[] diagonal1Symbols = new String[this.gameBoard.length];
        String[] diagonal2Symbols = new String[this.gameBoard.length];

        // Initialize a boolean to find any available slot in the board
        boolean boardFinished = true;

        for (int row = 0; row < this.gameBoard.length; row++) {
            // Check if the row has a winning condition
            String[] rowSymbols = new String[this.gameBoard.length];
            String[] columnSymbol = new String[this.gameBoard.length];
            for (int column = 0; column < this.gameBoard.length; column++) {

                String value = this.gameBoard[row][column].getText();
                String transposedValue = this.gameBoard[column][row].getText();
                // Check if this slot is empty
                if (value == null || value.isEmpty() || value.equals("")
                    || transposedValue == null || transposedValue.isEmpty() || transposedValue.equals("")) {
                    boardFinished = false;
                }
                // Add the value to the rowSymbol array
                rowSymbols[column] = value;
                // Add the transposed value to the columnSymbol array
                columnSymbol[column] = transposedValue;

                // Add the button to the corresponding diagonal if so
                if (row == column) {
                    diagonal1Symbols[row] = value;
                }
                if (row + column == this.gameBoard.length - 1) {
                    diagonal2Symbols[row] = value;
                }
            }
            // Check the row and column
            if (sameSymbols(rowSymbols) || sameSymbols(columnSymbol)) {
                //System.out.println("Either a row or a column are winners!");
                return true;
            }
        }

        // Check diagonals
        if (sameSymbols(diagonal1Symbols) || sameSymbols(diagonal2Symbols)) {
            //System.out.println("One of the diagonals is a winner!");
            return true;
        }

        // Return the condition of boardFinished
        return boardFinished;
    }

    private boolean sameSymbols(String[] array) {
        String symbolFound = null;
        for (String symbol : array) {
            // Get out of the loop if an empty space is found
            if (symbol == null || symbol.isEmpty() || symbol.equals("")) {
                return false;
            }
            if (symbolFound == null) {
                symbolFound = symbol;
            } else {
                // Get out of the loop if there are different symbols
                if (!symbolFound.equals(symbol)) {
                    return false;
                }
            }
        }
        // Getting out of the loop means all Strings in the array are the same
        return true;
    }

    private String arrayToString(String[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i != array.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
