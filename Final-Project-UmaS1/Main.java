import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    Boolean playg = true;
    Boolean newg = true; 
    String next; 
    Scanner s = new Scanner(System.in);
    
    System.out.println("");
    System.out.println("");
    System.out.println("Hello player. I am the game master. Welcome to my casino! >:)");
    
    System.out.println("How much money will you bring to the table.\n");
    double money = s.nextDouble();

    while (money <= 0) {
      System.out.println("The amount you entered is too low. Please enter a bigger number.");
      money = scan.nextDouble();
    }
    
    while (newg == true) {
      System.out.println("What game would you like to play today?");
      System.out.println("");
      System.out.println("1.) Black Jack");
      System.out.println("2.) High or Low");
      //System.out.println("3.) ");
      System.out.println("");
      System.out.println("Enter the number assigned to the game you would like to play.");
      int game = scan.nextInt();
      System.out.println("");
      playg = true; 
      while (playg == true) { 
        while (game != 1 && game != 2) {
          System.out.println("That is not a valid game option. Please respond with 1 or 2. \n");
          game = scan.nextInt();
        }
        if(game == 1) {
          money = BlackJack.play(money);
        } else if (game == 2) {
          money = HighorLow.play(money);
        }

        
        System.out.println("");
        System.out.println("Would you like to: ");
        System.out.println("");
        System.out.println("1.) Keep playing this game");
        System.out.println("2.) Play a new game");
        System.out.println("3.) Stop playing");
        System.out.println("");
        int response = scan.nextInt();
        if (money <= 0 && (response == 1 || response == 2)) {
          System.out.println("You want to keep playing??");
          next = s.nextLine();
          System.out.println("With what money?");
          next = s.nextLine();
          System.out.println("Get out of my casino.");
          next = s.nextLine();
          System.out.println("**slams the door**");
          newg = false;
          playg = false;
        } else if (response == 1) {
          playg = true; 
          newg = false; 
        } else if (response == 2) {
          newg = true;
          playg = false;
        } else if (response == 3) {
          newg = false;
          playg = false;
          System.out.println("...hahaha...");
          next = s.nextLine();
          next = s.nextLine();
          System.out.println("...Hahaha");
          next = s.nextLine();
          System.out.println("HAHAHAHA");
          next = s.nextLine();
          System.out.println("YOU THOUGHT THAT YOU COULD ACTUALLY LEAVE");
          next = s.nextLine();
          System.out.println("YOU FOOL");
          next = s.nextLine();
          System.out.println("I AM THE GAME MASTER");
          next = s.nextLine();
          System.out.println("YOU ONLY LEAVE WHEN I LET YOU LEAVE");
          next = s.nextLine();
          System.out.println("jk you can go. bye\n");
          System.out.println ("You left the casino with $" + money);
        }
      }
    }
    
    
  }
}