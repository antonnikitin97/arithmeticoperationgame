import java.util.ArrayList;

/**
 * Created by anton on 21/01/2016.
 */
public class GameControl {
    private OPERATION currentOperation;
    private Integer operandOne;
    private Integer operandTwo;
    private Integer answer = 0;
    private Integer playerResponse;
    private Player ActivePlayer;
    private TextDisplayPanel textDisplayPanel;
    private ArrayList<OPERATION> possibleOperations;

    public GameControl(Player ActivePlayer, TextDisplayPanel textDisplayPanel){
        this.ActivePlayer = ActivePlayer;
        this.textDisplayPanel = textDisplayPanel;
        possibleOperations = new ArrayList<>();
        for(OPERATION o : OPERATION.values()){
            possibleOperations.add(o);
        }
        setUpWindow();
    }

    /**
     * Enumeration to represent the different arithmetic operations.
     */
    public enum OPERATION {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE;
    }

    public Player getActivePlayer(){
        return this.ActivePlayer;
    }

    public void setUpWindow(){
        generateOperands();
        setCurrentOperation();
        textDisplayPanel.updateText(operandOne, operandTwo, currentOperation.toString());
    }

    /**
     * Sets the response of the ActivePlayer to the class level variable
     * @param playerResponseParameter
     */
    public void setPlayerResponse(Integer playerResponseParameter){
        playerResponse = playerResponseParameter;
    }

    private void performCalculation(){
        switch (currentOperation){
            case ADD:
                answer = (operandOne + operandTwo);
                break;
            case SUBTRACT:
                answer = (operandOne - operandTwo);
                break;
            case MULTIPLY:
                answer = (operandOne * operandTwo);
                break;
            case DIVIDE:
                answer = operandOne / operandTwo;
                break;
        }
    }

    public void checkAnswer(){
        performCalculation();
        if(playerResponse.equals(answer)) {
            ActivePlayer.increaseNumberAttempted();
            ActivePlayer.increaseNumberCorrect();
            ActivePlayer.increasePlayerPoints(currentOperation);
            setUpWindow();
        }else{
            ActivePlayer.increaseNumberAttempted();
            ActivePlayer.decreasePlayerPoints();
            setUpWindow();
        }
    }

    private void generateOperands(){
        boolean divisibleWholeNumber = false;
        do{
            /**
            Ensures the divisibility of the operands results in a whole number.
            Also ensures second operand is never 0 to ensure no division by 0 occurs.
             **/
            operandOne = Generator.getRandomNumber(150);
            operandTwo = Generator.getRandomNumber(150);
            if(operandTwo != 0 && (operandOne % operandTwo) == 0){
                divisibleWholeNumber = true;
            }
        }
        while (!divisibleWholeNumber);
    }

    private void setCurrentOperation(){
        currentOperation = possibleOperations.get(Generator.getRandomNumber(possibleOperations.size()));
    }
}
