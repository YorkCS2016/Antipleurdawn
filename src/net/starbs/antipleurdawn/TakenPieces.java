package net.starbs.antipleurdawn;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;

/**
 * Created by Hickman on 04/06/2016.
 */
public class TakenPieces {
    public StackPane pane = new StackPane();

    public void displayPieces(Piece[] pieces){
        for(Piece piece: pieces) {
            pane.getChildren().add(piece.getImage());
        }
    }

    public TakenPieces(){
        pane.setPadding(new Insets(5, 0, 5, 0));
    }
}
