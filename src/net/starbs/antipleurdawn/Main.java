package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.starbs.antipleurdawn.client.*;
import net.starbs.antipleurdawn.handlers.BoardHandler;
import net.starbs.antipleurdawn.pusher.PusherBinder;
import net.starbs.antipleurdawn.ui.*;

import java.io.IOException;

public class Main extends Application
{
    private Client client;
    private Board board;

    public Main() throws IOException
    {
        client = (new ClientFactory()).make();
    }

    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root, 710, 440, false, SceneAntialiasing.BALANCED);

        scene.getStylesheets().add("file:src/main.css");

        board = (Board) scene.lookup("#board");
        new BoardOperator(board, client);

        PusherBinder binder = (new PusherBinder(client));
        binder.bind(new BoardHandler(board, client, scene));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Anti Chess");
        primaryStage.setResizable(false);

        primaryStage.show();
        updatePlayerTypeBox(scene);
    }

    public void updatePlayerTypeBox(Scene scene)
    {
        Label desc = (Label) scene.lookup("#playerDesc");

        if (client.getPlayer() == PlayerType.BLACK) {
            desc.getStyleClass().set(2, "black");
            desc.setText("Black Player");
        } else {
            desc.getStyleClass().set(2, "white");
            desc.setText("White Player");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
