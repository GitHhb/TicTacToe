package game;

/**
 * Created by leandro on 17-1-2016.
 */
public class GameBoard {

    // Init STATIC
    // field nrs of winning positions
    final static byte[][] winningPos = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };

    // Init Instance
    // gameBoard = The game board
    int[] gameBoard = new int[9];     // 0 == no moves | 1 == human move | 2 == AI move
    int winner = 0;             // 0 == no winneryet | 1 == human | 2 == AI
    byte winningPosIndex = -1;            // index to array winningPos that indicates winning position
    boolean gameover = false;   // true => we have a winner

    // Goal: make move on field
    // Params:
    //  field = board location for next move (0 <= field < 9)
    //  player = id of player (1 | 2)
    // Return:
    //  true  == move made
    //  false == no move made (game ended | field occupied)
    boolean makeMove(int field, int player){
        // first check if we can make a move
        if (gameover || (gameBoard[field] != 0))
            // Game has ended | field already contains a move
            return false;

        // now make the move
        gameBoard[field] = player;

        // confirm we made the move
        return true;
    }

    // Goal: Check if winningPos[p] is a winning position
    boolean isWinningPos(byte p){
        // check if gameBoard[p0] contains a player move AND if gameBoard[0] == gameBoard[1] == gameBoard[2]
        return (gameBoard[winningPos[p][0]] != 0 && gameBoard[winningPos[p][0]] == gameBoard[winningPos[p][1]]
                && gameBoard[winningPos[p][0]] == gameBoard[winningPos[p][2]]);
    }

    void markWinningPos(byte p){
        winner = gameBoard[winningPos[p][0]];
        winningPosIndex = p;
        gameover = true;
    }

    boolean checkWin() {
        // Check if someone has a winning position

        //for (byte[] i : winningPos) {
        for (byte i = 0; i < winningPos.length; i++) {
            if (isWinningPos(i)){
                markWinningPos(i);
                return true;
            }
        }

        /*
        win = checkIfWinningPos(0, 1, 2) || checkIfWinningPos(3, 4, 5) || checkIfWinningPos(6, 7, 8)
                  || checkIfWinningPos(0, 3, 6) || checkIfWinningPos(1, 4, 7) || checkIfWinningPos(2, 5, 8)
                || checkIfWinningPos(0, 4, 8) || checkIfWinningPos(2, 4, 6);
        */
        /*
        if (win) {
            message = "Game won by " + player(winner);
            gameover = true;
        }
        */
        return false;
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
