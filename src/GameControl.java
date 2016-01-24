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
    private Player player;
    private TextDisplayPanel textDisplayPanel;
    private ArrayList<OPERATION> possibleOperations;

    public GameControl(Player player, TextDisplayPanel textDisplayPanel){
        this.player = player;
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

    public Player getPlayer(){
        return this.player;
    }

    public void setUpWindow(){
        generateOperands();
        setCurrentOperation();
        textDisplayPanel.updateText(operandOne, operandTwo, currentOperation.toString());
    }

    /**
     * Sets the response of the player to the class level variable
     * @param playerResponseParameter
     */
    public void setPlayerResponse(Integer playerResponseParameter){
        playerResponse = playerResponseParameter;
    }

    /**
     * The 4 methods below set the value of enumeration
     * to the given arithmetic operation.
     */
    public void setAdd(){
        currentOperation  = OPERATION.ADD;
    }

    public void setSubtract(){
        currentOperation = OPERATION.SUBTRACT;
    }

    public void setMultiply(){
        currentOperation = OPERATION.MULTIPLY;
    }

    public void setDivide(){
        currentOperation = OPERATION.DIVIDE;
    }

    public void setOperands(Integer firstOperand, Integer secondOperand){
        operandOne = firstOperand;
        operandTwo = secondOperand;
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
            player.increaseNumberAttempted();
            player.increaseNumberCorrect();
            player.increasePlayerPoints();
            generateOperands();
            setCurrentOperation();
            textDisplayPanel.updateText(operandOne, operandTwo, currentOperation.toString());
        }else{
            player.increaseNumberAttempted();
        }
    }

    private void generateOperands(){
        boolean divisibleWholeNumber = false;
        do{
            /**
            Ensures the divisibility of the operands results in a whole number.
            Also ensures second operand is never 0 to ensure no division by 0 occurs.
             **/
            operandOne = Generator.getRandomNumber(100);
            operandTwo = Generator.getRandomNumber(100);
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
