import java.util.Hashtable;

/**
 * Created by anton on 26/01/2016.
 */
public class DataStore {
    private Hashtable<String, Player> playerTable;

    {
        playerTable = new Hashtable<>();
        playerTable.put("Jim", new Player("Jim"));
    }

    public void addPlayer(String playerName){
        playerTable.put(playerName, new Player(playerName));
    }

    public Player getPlayer(String playerName){
        return playerTable.get(playerName);
    }
}
