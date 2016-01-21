import javax.swing.*;
import java.awt.*;

public class MainUserWindow extends JFrame {
    private UserInputPanel userInputPanel;

    {
        userInputPanel = new UserInputPanel();
    }

    public MainUserWindow(){
        super("Create User");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        add(userInputPanel, BorderLayout.CENTER);
    }
}
