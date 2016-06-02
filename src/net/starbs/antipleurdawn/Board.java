package net.starbs.antipleurdawn;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board{
    public Square[][] squares = new Square[8][8];
    public GridPane pane = new GridPane();
    private Square selectedSquare = null;

    public void displayData(String data){
        if (data.length() != 128){ //2 per square, 8x8 squares
            throw new IllegalArgumentException("The data specified need to be 128 characters long");
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y].setPiece(new Piece(
                        PieceType.values()[data.charAt(x + y * 8)],
                        PlayerType.values()[data.charAt(x + y * 8)]));
            }
        }
    }

    public void onSquareClicked(Square sq){
        if(selectedSquare == null){
            sq.select();
            selectedSquare = sq;
        }
        else if(selectedSquare == sq){
            sq.deselect();
            selectedSquare = null;
        }
        else{
            System.out.println("Made move");
            //TODO: send request to server etc ...
            selectedSquare.deselect();
            selectedSquare = null;
        }
    }

    public Board() {
        super();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square sq = new Square(x, y);
                pane.add(sq.pane, x, y);

                sq.pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        onSquareClicked(sq);
                    }
                });

                squares[x][y] = sq;
            }
        }

        for (int i = 0; i < 8; i++) {
            pane.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            pane.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
    }
}
