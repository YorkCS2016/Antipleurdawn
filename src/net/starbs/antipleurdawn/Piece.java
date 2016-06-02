package net.starbs.antipleurdawn;

import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Piece {
    public PieceType pieceType;
    public PlayerType playerType;

    public Node getImage(){
        if(pieceType == PieceType.EMPTY){
            return new Group();
        }

        Spritesheet ss = new Spritesheet("file:img/pieces.png", 450, 450);
        return ss.getSubImageCanvas(pieceType.ordinal() - 1, playerType.ordinal(), 100, 100);
    }
    
    public Piece(PieceType pieceType, PlayerType playerType){
        this.pieceType = pieceType;
        this.playerType = playerType;
    }
}
