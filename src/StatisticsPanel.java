import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by anton on 21/01/2016.
 */
public class StatisticsPanel extends JPanel{
    private JLabel playerName;
    private JLabel playerPoints;
    private JLabel numberAttempted;
    private JLabel percentCorrect;
    private GridBagConstraints gridBagConstraints;
    private Player player;

    {
        gridBagConstraints = new GridBagConstraints();
        Dimension dim = this.getPreferredSize();
        dim.width = 200;
        this.setPreferredSize(dim);
    }

    public StatisticsPanel(Player player){
        this.player = player;
        setLayout(new GridBagLayout());
        playerName = new JLabel("Player: " + player.getPlayerName());
        playerPoints = new JLabel("Points: " + player.getPlayerPoints().toString());
        numberAttempted = new JLabel("Number attempted: " + player.getNumberAttempted().toString());
        percentCorrect = new JLabel("Percent correct: ");
        setBorder(new TitledBorder("Game Stats"));
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        //First Row, First Column
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        add(playerName, gridBagConstraints);
        //Second Row, First Column
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        add(playerPoints, gridBagConstraints);
        //Third Row, First Column
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        add(numberAttempted, gridBagConstraints);
        //Fourth Row, First Column
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridx = 0;
        add(percentCorrect, gridBagConstraints);
    }

    public void updateFields(Integer points, Integer numberAttempted){
        playerPoints.setText("Points: " + points);
        this.numberAttempted.setText("Number attempted: " + numberAttempted);
        this.percentCorrect.setText("Percent correct: " + player.getPercentCorrect() + "%");
    }
}
