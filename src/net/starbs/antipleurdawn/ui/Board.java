package net.starbs.antipleurdawn.ui;

import net.starbs.antipleurdawn.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.events.MoveChosenEvent;
import net.starbs.antipleurdawn.events.MoveChosenEventListener;

import java.util.ArrayList;

public class Board extends GridPane
{
    public Square[][] squares = new Square[8][8];
    private Square selectedSquare = null;

    private ArrayList<MoveChosenEventListener> event_listeners = new ArrayList<MoveChosenEventListener>();;

    public void addMoveChosenEventListener(MoveChosenEventListener listener) {
        event_listeners.add(listener);
    }

    private void fireMoveChosenEvent(MoveChosenEvent event) {
        for(int i = 0; i < event_listeners.size(); i++) {
            event_listeners.get(i).moveChosenEventOccurred(event);
        }
    }

    public void displayData(Piece[][] data){
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y].setPiece(data[x][y]);
            }
        }
    }

    void onGameUpdated(GameUpdatedEvent event) {
        Piece[][] new_board = event.getBoard();
        displayData(new_board);
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
            int[] pnt_from = {sq.getX(), sq.getY()};
            int[] pnt_to = {selectedSquare.getX(), selectedSquare.getY()};
            fireMoveChosenEvent(new MoveChosenEvent(this, pnt_from, pnt_to));
            selectedSquare.deselect();
            selectedSquare = null;
        }
    }

    public Board() {
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
    }
}
