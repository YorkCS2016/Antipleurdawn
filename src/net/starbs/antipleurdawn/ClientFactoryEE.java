package net.starbs.antipleurdawn;
import net.starbs.antipleurdawn.Client;

/**
 * Created by sharr_000 on 6/4/2016.
 */
public class ClientFactoryEE {
    // TODO
    Client dummy;

    ClientFactoryEE(String uri) {
        // TODO
        Client dummy = new Client("", PlayerType.WHITE);
    }

    Client make() {
        // TODO
        return dummy;
    }

    Client make(boolean new_game) {
        // TODO
        return dummy;
    }
}
