import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 21/01/2016.
 */
public class UserInputPanel extends JPanel {
    private GridBagConstraints gridBagConstraints;

    //Instance initializer
    {
        gridBagConstraints = new GridBagConstraints();
    }

    public UserInputPanel(){
        setLayout(new GridBagLayout());

    }
}
