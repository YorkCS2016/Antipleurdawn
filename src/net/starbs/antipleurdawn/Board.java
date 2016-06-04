package net.starbs.antipleurdawn;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board{
    public Square[][] squares = new Square[8][8];
    public GridPane pane = new GridPane();
    private Square selectedSquare = null;
    private ColumnConstraints colConstraint = new ColumnConstraints();
    private RowConstraints rowConstraints = new RowConstraints();

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

    private void onSizeChange(){
        double maxDimensionSize = pane.getScene().getWidth() - 200 < pane.getScene().getHeight()
                ? pane.getScene().getHeight(): pane.getScene().getWidth() - 200;

        rowConstraints.setMinHeight(maxDimensionSize/8);
        rowConstraints.setMaxHeight(maxDimensionSize/8);
        rowConstraints.setPrefHeight(maxDimensionSize/8);

        colConstraint.setMinWidth(maxDimensionSize/8);
        colConstraint.setMaxWidth(maxDimensionSize/8);
        colConstraint.setPrefWidth(maxDimensionSize/8);
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

        //onSizeChange();
        colConstraint.setPercentWidth(12.5);
        rowConstraints.setPercentHeight(12.5);

        for (int i = 0; i < 8; i++) {
            pane.getColumnConstraints().add(colConstraint);
            pane.getRowConstraints().add(rowConstraints);
        }
        //pane.heightProperty().

        //pane.getScene().heightProperty().addListener((x, y, z) -> onSizeChange());
        //pane.getScene().widthProperty().addListener((x, y, z) -> onSizeChange());
    }
}
