import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 21/01/2016.
 */
public class MainGameWindow extends JFrame {

    private TextDisplayPanel textDisplayPanel;
    private OperationPanel operationPanel;

    {
        textDisplayPanel = new TextDisplayPanel();
        operationPanel = new OperationPanel();
    }

    public MainGameWindow(){
        super("Operation Maths!");
        setSize(600,500);
        add(textDisplayPanel, BorderLayout.CENTER);
        add(operationPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        operationPanel.setAnswerListener(new AnswerListener() {
            @Override
            public void answerSubmitted() {

            }
        });
    }
}
