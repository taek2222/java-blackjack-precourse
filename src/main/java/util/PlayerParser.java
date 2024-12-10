package util;

import java.util.ArrayList;
import java.util.List;

public class PlayerParser {

    public static List<String> parserInputPlayers(String input) {
        List<String> players = new ArrayList<>();

        String[] inputSplit = input.split(", ");
        for (String player : inputSplit) {
             players.add(player.trim());
        }

        return players;
    }
}
