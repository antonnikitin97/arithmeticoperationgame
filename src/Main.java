import javax.swing.*;

/**
 * Created by anton on 21/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainUserWindow();
                //new MainGameWindow();
            }
        });
    }
}
