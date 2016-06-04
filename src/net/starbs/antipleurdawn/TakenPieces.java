package net.starbs.antipleurdawn;

import javafx.scene.layout.FlowPane;

public class TakenPieces
{
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
