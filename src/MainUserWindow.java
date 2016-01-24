import javax.swing.*;
import java.awt.*;

public class MainUserWindow extends JFrame {
    private UserInputPanel userInputPanel;

    {
        userInputPanel = new UserInputPanel();
    }

    public MainUserWindow(){
        super("Create User");
        setSize(225,100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        add(userInputPanel, BorderLayout.CENTER);

        userInputPanel.setNameSubmitted(new NameSubmitted() {
            @Override
            public void nameSubmit(String playerName) {
                new MainGameWindow(playerName);
                setVisible(false);
            }
        });
    }
}
