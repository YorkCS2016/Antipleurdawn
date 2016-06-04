package net.starbs.antipleurdawn.ui;

import net.starbs.antipleurdawn.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import net.starbs.antipleurdawn.events.GameUpdated;

/**
 * Created by Hickman on 02/06/2016.
 */
public class BoardUI extends GridPane {
    public Square[][] squares = new Square[8][8];
    private Square selectedSquare = null;
    private ColumnConstraints colConstraint = new ColumnConstraints();
    private RowConstraints rowConstraints = new RowConstraints();

    public void displayData(Piece[][] data){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y].setPiece(data[x][y]);
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
            //TODO: send request to server etc ... - dispatch event
            selectedSquare.deselect();
            selectedSquare = null;
        }
    }

    public BoardUI() {
        super();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square sq = new Square(x, y);
                add(sq, x, y);

                sq.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                        onSquareClicked(sq);
                    }
                });

                squares[x][y] = sq;
            }
        }

        //onSizeChange();
        colConstraint.setPercentWidth(12.5);
        rowConstraints.setPercentHeight(12.5);

        for (int i = 0; i < 8; i++) {
            getColumnConstraints().add(colConstraint);
            getRowConstraints().add(rowConstraints);
        }
        //pane.heightProperty().

        //pane.getScene().heightProperty().addListener((x, y, z) -> onSizeChange());
        //pane.getScene().widthProperty().addListener((x, y, z) -> onSizeChange());
    }
}
