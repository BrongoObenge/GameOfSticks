import java.util.Random;

/**
 * Created by j on 30/01/15.
 */
public class Bucket {
    int value = -1;

    public Bucket(){
        Random rand = new Random();
        value = rand.nextInt((3-1)+1)+1;    //Random number from 1 to 3
    }
    public int getValue(){
        return this.value;
    }
}
