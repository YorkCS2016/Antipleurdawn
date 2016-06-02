package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Label top = new Label("Anti Chess");

        Board board = new Board();

        for (int i = 0; i < 8; i++) {
            board.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            board.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(board);

        Scene main = new Scene(root, 500, 500);

        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
