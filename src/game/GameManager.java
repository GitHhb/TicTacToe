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
        for (int i = 0; i < 9; i++) {
            if (ttt[i] == 0) {
                ttt[i] = 2;
                fields[i].setText("O");
                break;
            }
        }
    }

}
