import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 21/01/2016.
 */
public class TextDisplayPanel extends JPanel {

    private JLabel operandOne;
    private JLabel operator;
    private JLabel operandTwo;
    private GameControl gameControl;

    {
        operandOne = new JLabel("");
        operandTwo = new JLabel("");
        operator = new JLabel("");
    }

    public TextDisplayPanel(GameControl gc){
        this.gameControl = gc;
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        //Constrains for the components
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(operandOne, gridBagConstraints);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridy = 2;
        add(operator, gridBagConstraints);
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridy = 3;
        add(operandTwo, gridBagConstraints);
    }

    public void updateText(Integer operandOne, Integer operandTwo, String operator){
        this.operandOne.setText(operandOne.toString());
        this.operandTwo.setText(operandTwo.toString());
        this.operator.setText(operator);
    }
}
