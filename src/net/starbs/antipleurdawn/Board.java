package net.starbs.antipleurdawn;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board extends GridPane {
    Board() {
        super();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                StackPane square = new StackPane();
                String color;

                if ((i + j) % 2 == 0) {
                    color = "white";
                } else {
                    color = "black";
                }
                square.setStyle("-fx-background-color: " + color + ";");

                add(square, i, j);
            }
        }
    }
}
