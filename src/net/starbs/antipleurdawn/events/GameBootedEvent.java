package net.starbs.antipleurdawn.events;

import javafx.stage.Stage;

public class GameBootedEvent implements EventInterface
{
    private Stage stage;

    public GameBootedEvent(Stage stage)
    {
        this.stage = stage;
    }

    public Stage getStage()
    {
        return stage;
    }
}
