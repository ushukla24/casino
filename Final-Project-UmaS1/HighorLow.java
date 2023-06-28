import java.util.Scanner; 

public class HighorLow {

  public static double play(double money) {
   
    Scanner scan = new Scanner(System.in);
    
    Deck deck = new Deck();  
      
    Card currentCard; 

    Card nextCard;   

    double bet = money; 

    int correctGuesses ;  
    String guess;   
      
    deck.shuffle();  

    correctGuesses = 0;
    currentCard = deck.dealCard();
    System.out.println("Welcome to High or Low. \n");
    System.out.println("How many times in a row do you think you will be able to guess correctly?\n");
    int prediction = scan.nextInt(); 

    System.out.println("How much will you wager on that guess?\n");
    double wager = scan.nextDouble();

    while (wager <= 0) {
      System.out.println("The amount you entered is too low. Please enter a bigger number.");
      wager = scan.nextDouble();
    }

    while (wager > bet) {
      System.out.println("You do not have enough money. Please enter a lower amount.");
      wager = scan.nextDouble();
    }
    
    System.out.println("The first card is the " + currentCard);
      
    while (true) {    
      System.out.println("Will the next card be higher (H) or lower (L)?  ");
      do {
        guess = scan.nextLine();
        guess = guess.toUpperCase();
        if (guess.equals("H") == false && guess.equals("L") == false) 
          System.out.println("Please respond with H or L:  ");
      } while (guess.equals("H") == false && guess.equals("L") == false);
         
      nextCard = deck.dealCard();
      System.out.println("The next card is " + nextCard);

         
      if (nextCard.getValue() == currentCard.getValue()) {
        System.out.println("The value is the same as the previous card.");
        System.out.println("Your streak ends in the case of a tie.");
        break; 
      }
      else if (nextCard.getValue() > currentCard.getValue()) {
        if (guess.equals("H")) {
          System.out.println("Your prediction was correct.");
          correctGuesses++;
        }
        else {
          System.out.println("Your prediction was incorrect.");
          break;  
        }
      }
      else {  
        if (guess.equals("L")) {
          System.out.println("Your prediction was correct.");
          correctGuesses++;
        }
        else {
          System.out.println("Your prediction was incorrect.");
          break;  
        }
      }
         
      currentCard = nextCard;
      System.out.println();
      System.out.println("The card is " + currentCard);
         
    }
      
    System.out.println();
    System.out.println("The game is over.");
    System.out.println("You made " + correctGuesses + " correct predictions.");
    if (correctGuesses >= prediction) {
      System.out.println("You were right. You were able to guess at least " + prediction + " times correctly in a row.");
      bet += wager; 
    } else if (correctGuesses < prediction) {
      System.out.println("You were wrong. You were not able to guess at least " + prediction + " times correctly in a row.\n");
      bet -= wager;
    }
    System.out.println("You left the table with $" + bet);
    System.out.println();
      
    return bet;
      
  }  
   
}