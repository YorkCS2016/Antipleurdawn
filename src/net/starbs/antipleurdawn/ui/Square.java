package net.starbs.antipleurdawn.ui;

import net.starbs.antipleurdawn.*;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

public class Square extends StackPane
{
    private int row;

    private int col;

    public Square(int row, int col)
    {
        this.row = row;
        this.col = col;

        String colour;

        if ((row + col) % 2 == 0) {
            colour = "#837EB1";//light
        } else {
            colour = "#0D083B";//dark
        }

        getStyleClass().add("square");
        setStyle("-fx-background-color: " + colour + ";");
        getChildren().add(new Group());
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public void setPiece(Piece piece)
    {
        getChildren().set(0, piece.getImage());
    }

    public void select()
    {
        getStyleClass().add("selected");
    }

    public void deselect()
    {
        getStyleClass().remove("selected");
    }
}
