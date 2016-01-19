package game;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Created by leandro on 17-1-2016.
 */
public class GameManager {
    int[] ttt = new int[9]; // 0 == no moves | 1 == human move | 2 == AI move
    int winner = 0; // 0 == no winneryet | 1 == human | 2 == AI
    boolean gameover = false; // true => we have a winner
    String message = ""; // message displayed to user

    public void theMove(int field, TextField[] fields, Label usermsg) {
        // field = player's move
        // fields = array to every TicTacToe tile
        // message = for displaying messages

        if (gameover) { return; }

        // if field already contains a move, do nothing
        if (ttt[field] != 0) return;

        // register human move
        ttt[field] = 1;
        fields[field].setText("X");

        // Check if human wins
        if (checkWin()) {
            usermsg.setText(message);
            usermsg.setTextFill(Color.web("Red"));
            return; // if human wins, stop the game
        }


        // AI implementation
        for (int i = 0; i < 9; i++) {
            if (ttt[i] == 0) {
                ttt[i] = 2;
                fields[i].setText("O");
                break;
            }
        }

        // Check if AI wins
        if (checkWin()) {
            usermsg.setText(message);
            return; // if human wins, stop the game
        }
    }

    boolean winningRow(int p0, int p1, int p2){
        // first check if ttt[p0] contains a player move AND if ttt[p0] == ttt[p1] == ttt[p2]
        if (ttt[p0] != 0 && ttt[p0] == ttt[p1] && ttt[p0] == ttt[p2]){
            winner = ttt[p0];
            return true;
        };
        return false;
    }

    public boolean checkWin() {
        // Check if someone has a winning position
        boolean winningPos = false;

        winningPos = winningRow(0, 1, 2) || winningRow(3, 4, 5) || winningRow(6, 7, 8)
                  || winningRow(0, 3, 6) || winningRow(1, 4, 7) || winningRow(2, 5, 8)
                || winningRow(0, 4, 8) || winningRow(2, 4, 6);
        if (winningPos) {
            message = "Game won by " + player(winner);
            gameover = true;
        }
        return winningPos;
    }

    public String player(int player){
        // Translate nr to player type: human OR AI
        switch (player){
            case 1: return "you";
            case 2: return "computer";
            default: return "When this message is printed something has gone really wrong!";
        }
    }

}
