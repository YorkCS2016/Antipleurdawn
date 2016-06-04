package net.starbs.antipleurdawn;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Hickman on 04/06/2016.
 */
public class TakenPieces {
    public FlowPane pane = new FlowPane();

    public void displayPieces(Piece[] pieces){
        for(Piece piece: pieces) {
            pane.getChildren().add(piece.getImage());
        }
    }

    public TakenPieces(){
        pane.setPrefWrapLength(130);
        pane.getStyleClass().add("panels");
    }
}
