package game;

import javafx.scene.control.TextField;

/**
 * Created by leandro on 17-1-2016.
 */
public class GameManager {
    int[] ttt = new int[9]; // 0 == no moves | 1 == human move | 2 == AI move

    public void theMove(int field, TextField[] fields) {
        if (ttt[field] != 0) return;
        ttt[field] = 1;
        fields[field].setText("X");

        // Check if human wins
        checkWin();

        for (int i = 0; i < 9; i++) {
            if (ttt[i] == 0) {
                ttt[i] = 2;
                fields[i].setText("O");
                break;
            }
        }

        // Check if AI wins
        checkWin();
    }

    boolean winningRow(int p0, int p1, int p2){
        return (ttt[p0] == ttt[p1] && ttt[p0] == ttt[p2]);
    }

    public boolean checkWin(){
        // Check if someone has a winning position
        boolean winningPos  = false;

        winningPos = winningRow(0, 1, 2)
                || (ttt[3] == ttt[4] & ttt[4] == ttt[5])
                || (ttt[6] == ttt[7] & ttt[7] == ttt[8])
                || (ttt[0] == ttt[3] & ttt[3] == ttt[6])
                || (ttt[1] == ttt[4] & ttt[4] == ttt[7])
                || (ttt[2] == ttt[5] & ttt[5] == ttt[8])
                || (ttt[0] == ttt[4] & ttt[4] == ttt[8])
                || (ttt[2] == ttt[4] & ttt[4] == ttt[6]);
        if (winningPos) System.out.println("Game won by " + player(ttt[0]));
        else if (winningPos = (ttt[0] == ttt[4] & ttt[4] == ttt[8]))
            System.out.println("Game won by " + player(ttt[0]));
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
