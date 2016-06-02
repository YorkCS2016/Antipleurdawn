package net.starbs.antipleurdawn;

import javafx.scene.layout.StackPane;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Square {
    public StackPane pane = new StackPane();
    private int x;
    private int y;

    public void setType(){

    }

    public void setPlayer(){

    }

    public Square(int x, int y){
        this.x = x;
        this.y = y;

        String color;

        if ((x + y) % 2 == 0) {
            color = "white";
        } else {
            color = "black";
        }
        pane.setStyle("-fx-background-color: " + color + ";");
    }
}
