package net.starbs.antipleurdawn;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board extends GridPane {
    private StackPane[][] squares = new StackPane[8][8];

    public void displayData(Piece[][] input){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (input[i][j] != Piece.EMPTY){

                }
                else{

                }
            }
        }
    }

    public Board() {
        super();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new StackPane();
                String color;

                if ((i + j) % 2 == 0) {
                    color = "white";
                } else {
                    color = "black";
                }
                squares[i][j].setStyle("-fx-background-color: " + color + ";");

                final int _i = i;
                final int _j = j;
                final StackPane square = squares[i][j];
                square.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event){
                    }
                });

                add(squares[i][j], i, j);
            }
        }
    }
}
