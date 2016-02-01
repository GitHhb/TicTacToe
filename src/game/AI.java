package game;

import java.util.HashMap;

/**
 * Created by L on 1/20/2016.
 * Goal: Creates computer's game play
 */
public class AI {
    // Legenda used for board positions:
    // 0 == not occupied
    // 1 == occupied by player 1
    // 2 == occupied by player 2

    GameBoard g = new GameBoard();

    byte[] pos = new byte[9]; // a single game position,
    // for all possible game positions (represented as int's),
    // allPos indicates the nr of moves that lead to victory
    HashMap<Integer, Integer> allPos = new HashMap<>();

    // Return:
    //  true  == at least one winning move is possible from this move
    //  false == no winning move possible
    private int nextMoves(String[] position, byte currentPlayer, byte otherPlayer) {
        // make a move by trying all possible empty fields in pos consecutively
        int nrWinningMoves = 0;

        // 1 --> if we have a winning position:
        //       stop checking for next moves and let caller know it's a winning pos

        if (g.checkWin()) nrWinningMoves++;


        // 2 --> compute outcome of all possible next moves
        for (int i = 0; i < pos.length; i++){
            if (pos[i]  == 0){

                // pos[i] empty, we can make a move
                pos[i] = currentPlayer;

            }
        }
        return nrWinningMoves;
    }


}
