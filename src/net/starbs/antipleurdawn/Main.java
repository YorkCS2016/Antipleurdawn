package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.client.ClientFactoryEE;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;

public class Main extends Application {

    Board board;
    TakenPieces whiteTakenPieces;
    TakenPieces blackTakenPieces;
    Client client;
    BorderPane root;
    BorderPane top;
    BorderPane left;
    BorderPane right;
    BoardOperator boardOp;

    public Main() {
        super();
        board = new Board();
        whiteTakenPieces = new TakenPieces();
        blackTakenPieces = new TakenPieces();
        client = ClientFactoryEE.make();
        root = new BorderPane();
        top = new BorderPane();
        left = new BorderPane();
        right = new BorderPane();
        boardOp = new BoardOperator(board, client);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label chessLabel = new Label("Anti Chess");
        chessLabel.setAlignment(Pos.TOP_RIGHT);
        chessLabel.setId("title");
        top.setLeft(chessLabel);
        root.setTop(top);
        root.setCenter(board.pane);
        root.setLeft(whiteTakenPieces.pane);
        root.setRight(blackTakenPieces.pane);
        Scene main = new Scene(root, 600, 400, false, SceneAntialiasing.BALANCED);
        main.getStylesheets().add("file:src/main.css");
        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.show();
    }

    void onGameUpdated(GameUpdatedEvent event) {
        board.onGameUpdated(event);
        if(event.getCurrentPlayer() != client.getPlayer()) {
            // TODO: display waiting screen
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
