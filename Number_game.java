import java.util.Random;
import java.util.Scanner;
public class Number_game{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        int totalscore=0;
        boolean playAgain=true;

        while(playAgain){
            int number=random.nextInt(100)+1;
            int attempts=5;
            boolean guessedcorrectly=false;
            System.out.println("welcome to game");
            System.out.println("you have only 5 attempts to guess to guess the numbers from 1-100");

            while(attempts>0){
            System.out.println("enter your guessed number");
            int guess=sc.nextInt();
            
            if(guess==number){
                System.out.println("your number is correct");
                guessedcorrectly=true;
                totalscore+=attempts;
                break;
            }
            else if(guess>number){
                System.out.println("too high");
            }
            else{
                System.out.println("too low");
            }
            attempts--;
            System.out.println("attempts left: "+attempts);
        }
        if(!guessedcorrectly){
            System.out.println("you lost your chance,your number was: "+number);
        }
        System.out.println("your score was: "+totalscore);
        System.out.println("Do you want to play again:");

        String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
    }
            System.out.println("Thanks for playing");
            sc.close();    

        
        
    } 
}