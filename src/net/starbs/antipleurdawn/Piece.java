package net.starbs.antipleurdawn;

import javafx.scene.Group;
import javafx.scene.Node;

public class Piece
{
    public static final String LOCATION = "img/pieces.png";

    private PieceType piece;

    private PlayerType player;

    public Piece(PieceType piece, PlayerType player)
    {
        this.piece = piece;
        this.player = player;
    }

    public PieceType getPiece()
    {
        return piece;
    }

    public PlayerType getPlayer()
    {
        return player;
    }

    public Node getImage()
    {
        if (piece == null) {
            return new Group();
        }

        Spritesheet ss = new Spritesheet("file:" + LOCATION, 450, 450);

        return ss.getSubImageCanvas(piece.ordinal(), player.ordinal(), 40, 40);
    }
}
