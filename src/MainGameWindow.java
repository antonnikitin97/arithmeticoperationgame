import javax.swing.*;
import java.awt.*;

/**
 * Created by anton on 21/01/2016.
 */
public class MainGameWindow extends JFrame {

    private TextDisplayPanel textDisplayPanel;
    private OperationPanel operationPanel;
    private StatisticsPanel statisticsPanel;
    private GameControl gameControl;

    {
        operationPanel = new OperationPanel();
    }

    public MainGameWindow(String name){
        super();
        textDisplayPanel = new TextDisplayPanel(gameControl);
        this.gameControl = new GameControl(new Player(name), textDisplayPanel);
        statisticsPanel = new StatisticsPanel(gameControl.getActivePlayer());
        this.setTitle("Operation Maths - " + gameControl.getActivePlayer().getPlayerName());
        setSize(600,500);
        add(textDisplayPanel, BorderLayout.CENTER);
        add(operationPanel, BorderLayout.SOUTH);
        add(statisticsPanel, BorderLayout.WEST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        operationPanel.setAnswerListener(new AnswerListener() {
            @Override
            public void answerSubmitted(Integer playerAnswer) {
                gameControl.setPlayerResponse(playerAnswer);
                gameControl.checkAnswer();
                statisticsPanel.updateFields(gameControl.getActivePlayer().getPlayerPoints(), gameControl.getActivePlayer().getNumberAttempted());
            }
        });
    }
}
