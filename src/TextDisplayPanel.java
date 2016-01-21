import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 21/01/2016.
 */
public class TextDisplayPanel extends JPanel {

    private JLabel questionLabel;

    public TextDisplayPanel(){
        questionLabel = new JLabel("---WAITING FOR CONFIG---");
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        //Constrains for the components
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;

        add(questionLabel, gridBagConstraints);
    }
}
