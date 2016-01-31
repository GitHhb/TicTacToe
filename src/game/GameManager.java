package game;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Created by leandro on 17-1-2016.
 */
public class GameManager {
    String message = ""; // message displayed to user
    GameBoard game = new GameBoard(); // create new game
    String player1WinMsg = "You win";
    String player2WinMsg = "AI wins";

    public void theMove(int field, TextField[] fields, Label usermsg) {
        // field = player's move
        // fields = array to every TicTacToe tile
        // message = for displaying messages

        // Start with trying a move on field
        if (! game.makeMove(field, 1))
            // we can't make moves
            // (only valid reason should be the game has ended or the field is occupied)
            return;

        // Move made, now show move on the gameboard
        fields[field].setText("X");

        // Check if human wins
        if (game.checkWin()) {
            usermsg.setText(player1WinMsg);
            usermsg.setTextFill(Color.web("Red"));
            //fields[game.winningPos[game.winningRow][0]].setBackground(javafx.scene.layout.
            return; // if human wins, stop the game
        }

        // make AI move

        // AI implementation
        for (int i = 0; i < 9; i++) {
            if (game.ttt[i] == 0) {
                game.ttt[i] = 2;
                fields[i].setText("O");
                break;
            }
        }


        // Check if AI wins
        if (game.checkWin()) {
            usermsg.setText(player2WinMsg);
            return; // if human wins, stop the game
        }
    }

/*
    public String player(int player){
        // Translate nr to player type: human OR AI
        switch (player){
            case 1: return "you";
            case 2: return "computer";
            default: return "When this message is printed something has gone really wrong!";
        }
    }
*/
}
