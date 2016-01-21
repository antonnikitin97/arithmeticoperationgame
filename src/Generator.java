import java.util.Random;

/**
 * Created by anton on 21/01/2016.
 */
public class Generator {
    private static Random randomGen;

    static {
        randomGen = new Random();
    }

    public static Integer getRandomNumber(){
        return randomGen.nextInt();
    }
}
