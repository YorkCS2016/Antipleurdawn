package net.starbs.antipleurdawn;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music
{
    public static final String URI = "https://negasaurus.memetrash.co.uk/music.mp3";

    private Media media;

    public Music()
    {
        this(URI);
    }

    public Music(String uri)
    {
        media = new Media(uri);
    }

    public void play()
    {
        MediaPlayer player = new MediaPlayer(media);

        player.play();
    }
}
