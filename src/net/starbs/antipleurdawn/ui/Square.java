package net.starbs.antipleurdawn.ui;

import net.starbs.antipleurdawn.*;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

public class Square extends StackPane
{
    public Piece piece;

    public int getRow() {
        return x;
    }

    public int getCol() {
        return y;
    }

    private int x;
    private int y;

    public Square(int x, int y){
        this.x = x;
        this.y = y;

        String color;

        if ((x + y) % 2 == 0) {
            color = "#837EB1";//light
        } else {
            color = "#0D083B";//dark
        }
        getStyleClass().add("square");
        setStyle("-fx-background-color: " + color + ";");
        getChildren().add(new Group());
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        getChildren().set(0, piece.getImage());
    }

    public void select(){
        getStyleClass().add("selected");
    }

    public void deselect() {
        getStyleClass().remove("selected");
    }
}
