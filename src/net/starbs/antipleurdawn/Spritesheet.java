package net.starbs.antipleurdawn;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

/**
 * Created by sharr_000 on 6/2/2016.
 */
public class Spritesheet {

    Image sheet;
    int spr_width;
    int spr_height;

    public Spritesheet(String path, int sprite_width, int sprite_height) {
        sheet = new Image(path);
        spr_width = sprite_width;
        spr_height = sprite_height;
    }

    public Canvas getSubImageCanvas(int x, int y) {
        Canvas result = new Canvas(spr_width, spr_height);
        result.getGraphicsContext2D().drawImage(
                sheet,
                x*spr_width,
                y*spr_height,
                spr_width,
                spr_height);
        return result;
    }
}
