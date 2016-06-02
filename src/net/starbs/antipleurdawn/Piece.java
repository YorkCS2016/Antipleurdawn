package net.starbs.antipleurdawn;

import javafx.scene.Node;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Piece {
    public PieceType pieceType;
    public PlayerType playerType;

    public Node getImage(){
        throw new NotImplementedException();
    }

    public Piece(PieceType pieceType, PlayerType playerType){
        this.pieceType = pieceType;
        this.playerType = playerType;
    }
}
