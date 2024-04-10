import Piece.PieceType;
import Piece.PlayingPiece;

public class Player {

    String name;
    PlayingPiece piece;

    Player(String name, PieceType piece){
        this.name= name;
        this.piece = new PlayingPiece(piece);
    }
}
