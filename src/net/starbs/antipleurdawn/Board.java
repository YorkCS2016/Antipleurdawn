package net.starbs.antipleurdawn;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.events.MoveChosenEvent;
import net.starbs.antipleurdawn.events.MoveChosenEventListener;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board{
    public Square[][] squares = new Square[8][8];
    public GridPane pane = new GridPane();
    private Square selectedSquare = null;
    private ColumnConstraints colConstraint = new ColumnConstraints();
    private RowConstraints rowConstraints = new RowConstraints();

    private ArrayList<MoveChosenEventListener> event_listeners;

    public void addMoveChosenEventListener(MoveChosenEventListener listener) {
        event_listeners.add(listener);
    }

    private void fireMoveChosenEvent(MoveChosenEvent event) {
        for(int i = 0; i < event_listeners.size(); i++) {
            event_listeners.get(i).moveChosenEventOccurred(event);
        }
    }

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
            int[] pnt_from = {sq.getX(), sq.getY()};
            int[] pnt_to = {selectedSquare.getX(), selectedSquare.getY()};
            fireMoveChosenEvent(new MoveChosenEvent(this, pnt_from, pnt_to));
            selectedSquare.deselect();
            selectedSquare = null;
        }
    }
    
    void onGameUpdated(GameUpdatedEvent event) {
        Piece[][] new_board = event.getBoard();
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                squares[r][c].setPiece(new_board[r][c]);
            }
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

        //onSizeChange();
        colConstraint.setPercentWidth(12.5);
        rowConstraints.setPercentHeight(12.5);

        for (int i = 0; i < 8; i++) {
            pane.getColumnConstraints().add(colConstraint);
            pane.getRowConstraints().add(rowConstraints);
        }

        event_listeners = new ArrayList<MoveChosenEventListener>();
        //pane.heightProperty().

        //pane.getScene().heightProperty().addListener((x, y, z) -> onSizeChange());
        //pane.getScene().widthProperty().addListener((x, y, z) -> onSizeChange());
    }
}
