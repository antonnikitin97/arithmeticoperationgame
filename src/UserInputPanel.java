import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by anton on 21/01/2016.
 */
public class UserInputPanel extends JPanel implements ActionListener {
    private GridBagConstraints gridBagConstraints;
    private JTextField nameField;
    private JLabel nameLabel;
    private JButton submitButton;
    private NameSubmitted listener;

    //Instance initializer
    {
        gridBagConstraints = new GridBagConstraints();
        nameField = new JTextField(10);
        nameLabel = new JLabel("Enter name: ");
        submitButton = new JButton("Submit");
    }

    public UserInputPanel(){
        setLayout(new GridBagLayout());
        //Action listener for the button.
        submitButton.addActionListener(this);

        ///First Row, First Column
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        add(nameLabel, gridBagConstraints);

        //First Row, Second Column
        gridBagConstraints.gridx = 1;
        add(nameField, gridBagConstraints);

        //Second Row, First Column
        gridBagConstraints.weighty = 1;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(submitButton, gridBagConstraints);
    }

    public void setNameSubmitted(NameSubmitted listener){
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.nameSubmit(nameField.getText());
    }
}
