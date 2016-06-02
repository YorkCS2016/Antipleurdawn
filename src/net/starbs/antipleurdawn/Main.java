package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Label top = new Label("Anti Chess");

        Board board = new Board();

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(board.pane);

        Scene main = new Scene(root, 500, 500);

        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
