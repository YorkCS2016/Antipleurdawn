package net.starbs.antipleurdawn;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class Spritesheet
{
    Image sheet;
    int spr_width;
    int spr_height;

    public Spritesheet(String path, int sprite_width, int sprite_height) {
        sheet = new Image(path);
        spr_width = sprite_width;
        spr_height = sprite_height;
    }

    public Canvas getSubImageCanvas(int x, int y, int result_width, int result_height) {
        Canvas result = new Canvas(result_width, result_height);
        result.getGraphicsContext2D().drawImage(
                sheet,
                x*spr_width, y*spr_height,
                spr_width, spr_height,
                0, 0,
                result_width, result_height);
        return result;
    }
}
