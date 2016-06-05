package net.starbs.antipleurdawn;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Spritesheet
{
    Image sheet;

    int width;

    int height;

    public Spritesheet(String path, int width, int height)
    {
        sheet = new Image(path);
        this.width = width;
        this.height = height;
    }

    public Canvas getSubImageCanvas(int x, int y, int width, int height)
    {
        Canvas result = new Canvas(width, height);

        result.getGraphicsContext2D().drawImage(sheet, x * this.width, y * this.height, this.width, this.height, 0, 0, width, height);

        return result;
    }
}
