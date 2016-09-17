import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by anton on 21/01/2016.
 */
public class OperationPanel extends JPanel implements ActionListener {
    private JButton submit;
    private JTextField answerInput;
    private JLabel insertAnswerHereLabel;
    private AnswerListener answerListener;

    //Instance initializer
    {
        submit = new JButton("Submit Answer!");
        insertAnswerHereLabel = new JLabel("Type the answer here: ");
        Dimension buttonDimension = submit.getPreferredSize();
        buttonDimension.height = (int)buttonDimension.getHeight() - 5;
        submit.setPreferredSize(buttonDimension);
        answerInput = new JTextField(15);
        setBorder(BorderFactory.createTitledBorder("Operations"));
    }

    public OperationPanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = gridBagConstraints.LINE_START;

        submit.addActionListener(this);

        gridBagConstraints.weighty = 1;

        /////////// FIRST COLUMN ///////////
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        add(submit, gridBagConstraints);
        /////////// SECOND COLUMN //////////
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        add(insertAnswerHereLabel, gridBagConstraints);
        /////////// THIRD COLUMN //////////
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(answerInput, gridBagConstraints);
    }

    public void setAnswerListener(AnswerListener listener){
        this.answerListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(answerInput.getText() == null || answerInput.getText().equals("")){
            answerInput.setText("0");
        }
        try{
            answerListener.answerSubmitted(Integer.parseInt(answerInput.getText()));
        }
        catch (NumberFormatException exception){
            answerInput.setText("INVALID INPUT!");
        }
    }
}
