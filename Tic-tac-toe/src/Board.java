import Piece.PlayingPiece;

public class Board {

    public int size;
    PlayingPiece[][] pieces;
    Board(int size){
        this.size = size;
        pieces = new PlayingPiece[size][size];
    }

}
