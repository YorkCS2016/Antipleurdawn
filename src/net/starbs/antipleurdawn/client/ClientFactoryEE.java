package net.starbs.antipleurdawn.client;
import net.starbs.antipleurdawn.PlayerType;

/**
 * Created by sharr_000 on 6/4/2016.
 */
public class ClientFactoryEE {
    // TODO

    public ClientFactoryEE(String uri) {
        // TODO
    }

    public static Client make() {
        // TODO
        return new Client("", PlayerType.WHITE);
    }

    public static Client make(boolean new_game) {
        // TODO
        return new Client("", PlayerType.WHITE);
    }
}
