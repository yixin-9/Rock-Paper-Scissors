// Description of program:
// This program lets the user plays a game called Rock, Paper, Scissors against the computer. 
// A random choice is generated by the computer.
// This program contains four functions : computerChoice, userChoice, determineWinner, playAgain.

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static Scanner input = new Scanner(System.in);
    
    public static String userChoice(Scanner scanner){
        String user_choice;
        System.out.println(" 1.Rock=R\n 2.Paper=P\n 3.Scissors=S\n"); //a menu
        System.out.println("Enter your choice: ");
        user_choice=scanner.nextLine(); //User enters the choice of “rock”, “paper”, or “scissors” 
        user_choice=user_choice.toUpperCase(); //convert input letter into capital letter
        
        return user_choice; //return a character
    }
    
    public static String computerChoice(Random random){
        int computer_play;
        //A random number in the range of 1 through 3 is generated. 
        computer_play= random.nextInt(3)+1; 
        String computer_choice=""; 
        
        switch (computer_play) {
            case 1: //If the number is 1, then the computer has chosen rock.
                computer_choice="R"; 
                break;
            case 2: //If the number is 2, then the computer has chosen paper. 
                computer_choice="P";
                break;
            case 3: //If the number is 3, then the computer has chosen scissors.
                computer_choice="S";
                break;
            default:
                break;
        }
        return computer_choice; //return a character
    } 
   
    
    public static int determineWinner(String computerChoice, String userChoice){
        //If both players make the same choice, the game ends in a draw.
        if (userChoice.equals(computerChoice)) { 
            System.out.println("It's a tie!"); 
        }
        //If one player chooses rock and the other player chooses scissors, then rock wins.
        //If one player chooses scissors and the other player chooses paper, then scissors wins. 
        //If one player chooses paper and the other player chooses rock, then paper wins. 
        else if (userChoice.equals("R")) {  
            if (computerChoice.equals("S")) 
                System.out.println("Rock smashes scissors. You win!!");
            else if (computerChoice.equals("P")) 
                System.out.println("Paper wraps rock. You lose!!");
        } 
        
        else if (userChoice.equals("P")) {
            if (computerChoice.equals("S")) 
                System.out.println("Scissor cuts paper. You lose!!"); 
            else if (computerChoice.equals("R")) 
                System.out.println("Paper wraps rock. You win!!");
        }    
        
        else if (userChoice.equals("S")) {
            if (computerChoice.equals("P")) 
                System.out.println("Scissor cuts paper. You win!!"); 
            else if (computerChoice.equals("R")) 
                System.out.println("Rock smashes scissors. You lose!!");
        }
        
        else
            System.out.println("Invalid user input.");
            
        return 0;}
    
    public static boolean playAgain() {
    //Asking user to play again
    System.out.print("\nDo you want to play again? y for yes n for no\n");
    String userReply = input.nextLine();
    userReply = userReply.toUpperCase();
    return userReply.charAt(0) == 'Y'; //return a boonlean
}

    
    public static void main(String[] args) {
        
        do{
        Random random= new Random(); //random number is generated
        String computer_play;
        String user_play;
        
        computer_play=computerChoice(random);
        user_play=userChoice(input);
        
        //print out user choice and computer choice
        System.out.println("You choose "+ user_play + "\nComputer choose "+ computer_play+"\n");
        //determine who is the winner
        determineWinner(computer_play, user_play);
        //do while loop is used to ask user to play again
        }while(playAgain());
    }
    
}
