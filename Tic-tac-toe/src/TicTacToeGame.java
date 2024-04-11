import Piece.PieceType;
import Piece.PlayingPiece;

import javax.management.ObjectName;
import javax.security.auth.callback.TextInputCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class TicTacToeGame {


    Board board;

    Deque<Player> playerList = new ArrayDeque<>();
    TicTacToeGame(){
      initializeGame();
    }

    private void initializeGame() {
       board = new Board(3);
       Player player1 = new Player("Sai", PieceType.X);
       Player player2  = new Player("Sweety",PieceType.O);
       playerList.add(player2);
       playerList.add(player1);

       System.out.println("Board is ready......");
    }

    public void startGame() throws IOException {

        Player isWinner = null;
        PlayingPiece pieces[][] = board.pieces;

          while(isWinner==null){

              Player currentPlayer=  playerList.getFirst();

              System.out.println(currentPlayer.name+" Please choose empty position from below ");

              for(int i=0;i<board.size;i++){
                  for(int j=0;j<board.size;j++){

                      if(pieces[i][j]==null){
                          System.out.print(" ");
                      }
                      else if(pieces[i][j].piece==PieceType.O){
                          System.out.print("O");
                      }
                      else{
                          System.out.print("X");
                      }

                      if(j!=board.size-1) {
                          System.out.print("|");
                      }
                  }
                  System.out.println("");

              }


              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

              String arr[] = br.readLine().split(" ");

              int row = Integer.parseInt(arr[0]);
              int col = Integer.parseInt(arr[1]);

              if(pieces[row][col]!=null){
                  System.out.println("Entered Wrong Position");
                  continue;
              }


              pieces[row][col] = currentPlayer.piece;

              boolean isWinMove = checkWinner(pieces);
              if(isWinMove==true) {
                  isWinner = currentPlayer;
              }

              if(isWinner!=null){
                  System.out.println("Winner is "+currentPlayer.name);
                  continue;
              }
              else{
                  playerList.removeFirst();
                  playerList.addLast(currentPlayer);
              }

          }


    }


    public boolean checkWinner(PlayingPiece pieces[][]){

        for(int i=0;i< board.size;i++){

            if(pieces[i][0]==pieces[i][1] && pieces[i][0]==pieces[i][2] && pieces[i][0]!=null){
                    return true;
            }
        }
        return false;

    }
}
