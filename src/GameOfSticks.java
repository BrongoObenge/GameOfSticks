/**
 * Created by j on 20/01/15.
 */
import java.util.Scanner;
public class GameOfSticks {
    private Player player1;
    private Player player2;

    private int sticks;

    private Player turn;
    Scanner user_input = new Scanner(System.in);
    public GameOfSticks(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    public void playGame1(){

        this.turn = this.player1;

        System.out.println("Welcome to the game of sticks!");
        System.out.println("How many sitcks are there on the table initially (10-100)?");
        while(true) {
            try {
                this.sticks = Integer.parseInt(user_input.next()); //Parses input to int so we can save it
                break;
            }catch(Exception e){
                System.out.println("\nReally..? You just had to choose an integer...\nHow hard is this to understand?");
                System.out.println("OK. Lets try that again.\n");
                System.out.println("How many sitcks are there on the table initially (10-100)?");
            }
        }
        while(this.sticks>0){
            this.printTurn();
            this.processInput();
            this.switchTurns(this.player1, this.player2);
        }
        this.switchTurns(this.player1, this.player2);
        System.out.println(this.turn.getPlayerName() + " Wins!");
    }
    public void switchTurns(Player player1, Player player2){
        if(this.turn == player1){
            this.turn = player2;
        }else{
            this.turn = player1;
        }
    }
    public void printTurn(){
        System.out.println("There are "+this.sticks+" sticks on the board.");
        System.out.println(this.turn.getPlayerName() +": How many sticks do you take (1-3)?");
    }
    private void processInput(){
        Scanner user_input = new Scanner(System.in);
        int input;
        String inputUser = null;
        try{
            inputUser = user_input.next();
            input = Integer.parseInt(inputUser);
            if(input > 3 || input < 1)
                Integer.parseInt("THIS KILLS THE TRYCLAUSE :D");    //Easier to just kill the tryclause.
            else
                this.sticks = sticks - input;
        }catch(Exception e){
            System.out.println("\nMate.... You should have entered a number between 1 and 3 \n" +
                    "\'"+inputUser+"\' is not a number between 1 and 3..\n" +
                    "Because you were so STUPID, your turn is over.");
            this.printTurn();
            this.processInput();
        }
    }
    private void processAiInput(Bucket[] buckets){
        System.out.println("Ai is choosing a random blablalbal \n");
        this.sticks = this.sticks - buckets[this.sticks % buckets.length].getValue();
    }
    public void playGame2(){
        Bucket[] buckets = this.createSomeBuckets();
        this.turn = player1;
        System.out.println("Aight, Part 2!!!\nHow many sticks are there?");
        while(true) {
            try {
                this.sticks = Integer.parseInt(user_input.next()); //Parses input to int so we can save it
                break;
            }catch(Exception e){
                System.out.println("\nReally..? You just had to choose an integer...\nHow hard is this to understand?");
                System.out.println("OK. Lets try that again.\n");
                System.out.println("How many sitcks are there on the table initially (10-100)?");
            }
        }
        while(this.sticks>0) {
            this.printTurn();
            if (this.turn == this.player1)
                this.processInput();
            else
                processAiInput(buckets);
            this.switchTurns(this.player1, this.player2);
        }
    }

    private Bucket[] createSomeBuckets(){
        Bucket[] bucketArr;
        bucketArr = new Bucket[7];
        bucketArr[0] = new Bucket();
        bucketArr[1] = new Bucket();
        bucketArr[2] = new Bucket();
        bucketArr[3] = new Bucket();
        bucketArr[4] = new Bucket();
        bucketArr[5] = new Bucket();
        bucketArr[6] = new Bucket();
        return bucketArr;
    }
}
