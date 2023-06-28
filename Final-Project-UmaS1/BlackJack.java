import java.util.Scanner;

class BlackJack {
  public static double play(double money) {
    Scanner scan = new Scanner(System.in);
 
    Deck deck = new Deck();  

    BlackjackHand player = new BlackjackHand(); 

    BlackjackHand dealer = new BlackjackHand(); 

    int pTotal = 0;

    int dTotal = 0;

    deck.shuffle();

    double bet = money; 

    System.out.println("Welcome to Black Jack. \n");

    String choice2 = "yes";
    while (choice2.equals("yes")) {
      player.addCard(deck.dealCard());
      player.addCard(deck.dealCard());
    
      dealer.addCard(deck.dealCard());
      dealer.addCard(deck.dealCard());

      pTotal = player.getBlackjackValue(); 
      dTotal = dealer.getBlackjackValue(); 

      System.out.println("How much will you wager on this hand?\n");
      double wager = scan.nextDouble();

      while (wager <= 0) {
        System.out.println("The amount you entered is too low. Please enter a bigger number.");
        wager = scan.nextDouble();
      }

      while (wager > bet) {
        System.out.println("You do not have enough money. Please enter a lower amount.");
        wager = scan.nextDouble();
      }

      System.out.println("The dealer has drawn a " + dealer.getCard(0) + ".\n");
      System.out.println("Your hand is " + player.getCard(0) + " and " + player.getCard(1) + ".\n");
      System.out.println("Your total is " + pTotal + ".\n");
      
    
    if (pTotal >= 22) {
        System.out.println("You busted. The dealer won the bet.\n");
        bet = (bet - wager);
      } else {

        // Draw a card
        System.out.println("Would you like to draw a card?  (yes/no)\n");
        String choice1 = scan.next();

        int num = 0;
        // While Loop 2
        while (choice1.equals("yes") && pTotal < 21) {

          // You draw
          player.addCard(deck.dealCard());
          num += 1;
          pTotal = player.getBlackjackValue(); 
          System.out.println("You have drawn a " + player.getCard(num + 1) + ". Your new total is " + pTotal + ".\n");
          if (pTotal < 21) {
            System.out.println("Would you like to draw agin? yes/no\n");
            choice1 = scan.next();
          }
        }

        System.out.println("The dealer's second card is a " + dealer.getCard(1) + " .\n");

        dTotal = dealer.getBlackjackValue();
        System.out.println("The dealers total is " + dTotal + ".\n");
        int count = 0; 
        while (dTotal < pTotal && dTotal < 17) {
          dealer.addCard(deck.dealCard());
          count += 1;
          dTotal = dealer.getBlackjackValue();
          System.out.println("The dealer has drawn a " + dealer.getCard(count + 1) + ". His new total is " + dTotal + ".\n");
        }
        if (player.getBlackjackValue() == 21) {
          System.out.println("You got 21. You win.");
          bet += wager;
        } else {
          if (pTotal > 21) {
            System.out.println("You busted. The dealer won the bet.\n");
            bet = (bet - wager);
          } else {

            // Dealer Busted
            if (dTotal > 21) {
              System.out.println("The dealer busted. You win the bet.\n");
              bet = bet - wager;
              bet = (wager * 2) + bet;
            } else {

              if (dTotal > pTotal && dTotal <= 21 && pTotal <= 21) {
                System.out.println("The dealer has won the bet.\n");
                bet -= wager;
              } else {

                // You win with number greater than dealer
                if (pTotal > dTotal) {
                  System.out.println("You won the bet.\n");
                  bet += wager;
                }
              }

              // Ends in a tie
              if (pTotal == dTotal) {
                System.out.println("You and the dealer tied. You get your money back.\n");
              }
            }
          }
        }
      }
      System.out.println("You have $" + bet + " left to bet.\n");

      System.out.println("Would you like to play again? yes/no\n");
      
      Scanner s = new Scanner(System.in);
      choice2 = s.nextLine();

      while (choice2.equals("no") == false && choice2.equals("yes") == false) {
        System.out.println("Please respond with yes or no.\n");
        choice2 = s.nextLine();
      }
      if (bet == 0 && choice2.equals("yes")) {
        choice2 = "no";
        System.out.println("You are out of money. You cannot keep playing.\n");
      }

      if (choice2.equals("no")) {
        System.out.println("Thank you for playing.\n");
        System.out.println("You left the table with $" + bet + "\n");
      }
      
      if (choice2.equals("yes")) {
        pTotal = 0;
        dTotal = 0; 
        player.clear();
        dealer.clear(); 
      }
    }
    
    return bet;
  }
}