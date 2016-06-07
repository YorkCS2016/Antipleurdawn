package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.client.ClientFactory;
import net.starbs.antipleurdawn.events.GameBootedEvent;
import net.starbs.antipleurdawn.handlers.BoardHandler;
import net.starbs.antipleurdawn.pusher.PusherBinder;
import net.starbs.antipleurdawn.ui.Board;

import java.io.IOException;

public class Main extends Application
{
    private Client client;
    private Board board;

    public Main() throws IOException
    {
        client = (new ClientFactory()).make();
    }

    public void start(Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root, 710, 440, false, SceneAntialiasing.BALANCED);

        scene.getStylesheets().add("file:src/main.css");

        updatePlayerTypeBox(scene);

        board = (Board) scene.lookup("#board");
        new BoardOperator(board, client);

        BoardHandler handler = new BoardHandler(board, client, scene);
        PusherBinder binder = (new PusherBinder(client));
        binder.bind(handler);

        handler.onGameBooting(new GameBootedEvent(stage));

        stage.show();
    }

    @Override
    public void stop()
    {
        try {
            client.forfeit();
        } catch (Throwable e) {
            //
        }
    }

    private void updatePlayerTypeBox(Scene scene)
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
