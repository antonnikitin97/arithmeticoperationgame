/**
 * Created by anton on 21/01/2016.
 */
public class Player {
    private String playerName;
    private Integer playerPoints;
    private Integer numberAttempted;
    private Integer numberCorrect;

    public Player(String playerName){
        this.playerName = playerName;
    }

    public void increasePlayerPoints() {
        playerPoints += 2;
    }

    public void increaseNumberAttempted(){
        numberAttempted++;
    }

    public void increaseNumberCorrect(){
        numberCorrect++;
    }
}
