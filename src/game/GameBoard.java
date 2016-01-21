package game;

/**
 * Created by leandro on 17-1-2016.
 */
public class GameBoard {
    // ttt = The game board
    int[] ttt = new int[9];     // 0 == no moves | 1 == human move | 2 == AI move
    int winner = 0;             // 0 == no winneryet | 1 == human | 2 == AI
    boolean gameover = false;   // true => we have a winner
    String message = "";        // message displayed to user

    // Goal: make move on field
    // Params:
    //  field = board location for next move (0 <= field < 9)
    //  player = id of player (1 | 2)
    // Return:
    //  true  == move made
    //  false == no move made (game ended | field occupied)

    boolean makeMove(int field, int player){
        // first check if we can make a move
        if (gameover || (ttt[field] != 0))
            // Game has ended | field already contains a move
            return false;

        // now we can make the move
        ttt[field] = player;

        // confirm we made the move
        return true;
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
