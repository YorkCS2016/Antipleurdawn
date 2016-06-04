package net.starbs.antipleurdawn.client;

import net.starbs.antipleurdawn.PlayerType;

public class ClientFactory {
    // TODO

    public ClientFactory(String uri) {
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
