package net.starbs.antipleurdawn;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Square {
    public StackPane pane = new StackPane();
    public Piece piece;
    private int x;
    private int y;

    public Square(int x, int y){
        this.x = x;
        this.y = y;

        String color;

        if ((x + y) % 2 == 0) {
            color = "white";
        } else {
            color = "grey";
        }
        pane.getStyleClass().add("square");
        pane.setStyle("-fx-background-color: " + color + ";");
        pane.getChildren().add(new Group());
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        pane.getChildren().set(0, piece.getImage());
    }

    public void select(){
        pane.getStyleClass().add("selected");
    }

    public void deselect() {
        pane.getStyleClass().remove("selected");
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
