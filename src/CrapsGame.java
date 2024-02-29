import java.util.Random;
import java.util.Scanner;
public class CrapsGame {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Random random = new Random();
            boolean playAgain = true;

            while (playAgain) {
                System.out.println("Lets play Craps!");
                int point = rollDice(random);
                System.out.println("Point is: " + point);
                if (isCrapsOrNatural(point)) {
                    printGameResult(point);
                } else {
                    playNextRolls(random, point);
                }
                playAgain = playAgainPrompt(in);
            }
            System.out.println("Thanks for play Craps! ");
        }

        public static int rollDice (Random random){
            int diceOne = random.nextInt(6) + 1;
            int diceTwo = random.nextInt(6);
            return diceOne + diceTwo;
        }
        public static boolean isCrapsOrNatural (int point) {
            return point == 2 || point == 3 || point == 12 || point == 7 || point == 11;
        }
        public static void printGameResult ( int point){
            if (point == 2 || point == 3 || point == 12) {
                System.out.println("Crapped out! You lose.");
            } else {
                System.out.println("Natural! You win!");
            }
        }

        public static void playNextRolls (Random random,int point){
            System.out.println("Trying for point: " + point);
            boolean gameEnd = false;

            while (!gameEnd) {
                int roll = rollDice(random);
                System.out.println("Roll is: " + roll);
                if (roll == point) {
                    System.out.println("Made point and won!");
                    gameEnd = true;
                } else if (roll == 7) {
                    System.out.println("Got a seven and lost.");
                    gameEnd = true;
                }
            }
        }

        public static boolean playAgainPrompt(Scanner in){
            System.out.print("Would you like to play again? (Y/N)");
            String choice = in.next();
            return choice.equalsIgnoreCase("Y");
        }
    }



