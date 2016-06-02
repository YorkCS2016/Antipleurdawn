package net.starbs.antipleurdawn;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Control;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board{
    public Square[][] squares = new Square[8][8];
    public GridPane pane = new GridPane();

    public void displayData(PieceType[][] input){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (input[i][j] != PieceType.EMPTY){

                }
                else{

                }
            }
        }
    }

    public Board() {
        super();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square sq = new Square(x, y);
                pane.add(sq.pane, x, y);
            }
        }

        for (int i = 0; i < 8; i++) {
            pane.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            pane.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
    }
}
