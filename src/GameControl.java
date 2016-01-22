import org.omg.CORBA.TRANSACTION_MODE;

/**
 * Created by anton on 21/01/2016.
 */
public class GameControl {
    private static OPERATION currentOperation;
    static Integer operandOne;
    static Integer operandTwo;
    static Integer answer = 0;
    static Integer playerResponse;
    static Player player;

    /**
     * Enumeration to represent the different arithmetic operations.
     */
    public enum OPERATION {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("X"),
        DIVIDE("/");

        private String operationValue;

        OPERATION(String value){
            this.operationValue = value;
        }

        public String getOperationValue() {
            return operationValue;
        }
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
    public static void setAdd(){
        currentOperation  = OPERATION.ADD;
    }

    public static void setSubtract(){
        currentOperation = OPERATION.SUBTRACT;
    }

    public static void setMultiply(){
        currentOperation = OPERATION.MULTIPLY;
    }

    public static void setDivide(){
        currentOperation = OPERATION.DIVIDE;
    }

    public static void setOperands(Integer firstOperand, Integer secondOperand){
        operandOne = firstOperand;
        operandTwo = secondOperand;
    }

    private static void performCalculation(){
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

    private static void checkAnswer(){
        if(playerResponse.equals(answer)) {
            player.increaseNumberAttempted();
            player.increaseNumberCorrect();
            player.increasePlayerPoints();
            generateOperands();
        }else{
            player.increaseNumberAttempted();
        }
    }

    private static void generateOperands(){
        boolean divisibleWholeNumber = false;
        do{
            /**
            Ensures the divisibility of the operands results in a whole number.
            Also ensures second operand is never 0 to ensure no division by 0 occurs.
             **/
            operandOne = Generator.getRandomNumber();
            operandTwo = Generator.getRandomNumber();
            if((operandOne % operandTwo) == 0 && operandTwo != 0){
                divisibleWholeNumber = true;
            }
        }
        while (!divisibleWholeNumber);
    }
}
