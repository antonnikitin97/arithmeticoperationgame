/**
 * Created by anton on 21/01/2016.
 */
public class Player {
    private String playerName;
    private Integer playerPoints;
    private Integer numberAttempted;
    private Integer numberCorrect;

    {
        numberAttempted = 0;
        numberCorrect = 0;
        playerPoints = 0;
    }

    public Integer getNumberAttempted() {
        return numberAttempted;
    }

    public Integer getNumberCorrect() {
        return numberCorrect;
    }

    public float getPercentCorrect(){
        return ((((float)numberCorrect)/((float)numberAttempted)) * 100);
    }

    public Player(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getPlayerPoints(){
        return playerPoints;
    }

    public void increasePlayerPoints(GameControl.OPERATION currentOperation) {
        switch (currentOperation){
            case ADD:
                playerPoints++;
                break;
            case SUBTRACT:
                playerPoints++;
                break;
            case MULTIPLY:
                playerPoints += 2;
                break;
            case DIVIDE:
                playerPoints += 4;
                break;
        }
    }

    public void decreasePlayerPoints(){
        playerPoints -= 2;
    }

    public void increaseNumberAttempted(){
        numberAttempted++;
    }

    public void increaseNumberCorrect(){
        numberCorrect++;
    }
}
