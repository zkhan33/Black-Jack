
import java.util.Scanner;

public class BlackJack {

    public static int cash_in_hand;
    public static int maxBet = 250;
    public static int minBet = 10;
    public static int currentBet = 0;
    private static String currentCard;
    private static String userChose;

    public static void main(String[] args) {
        System.out.println("Hello, Welcome to BlackJack!");
        System.out.println("The minimum bet for this game is $" + String.valueOf(minBet)
                + " and the maximum bet for this game is $" + String.valueOf(maxBet));
        System.out.println("Lets begin! How much cash do you have?");
        Scanner input = new Scanner(System.in);
        cash_in_hand = input.nextInt();
        while (true) {
            Hand player = new Hand();
            Hand dealer = new Hand();
            System.out.println("Your cash in hand is: $" + cash_in_hand);
            System.out.println("Place your bet:");
            currentBet = input.nextInt();
            if (currentBet > 250) {
                System.out.println("Remember, the maximum bet is $250. Start over and place another bet!");
                break;
            } else if (currentBet < 10) {
                System.out.println("Remember, the minimum bet is $10. Start over and place another bet!");
                break;
            }
            if (currentBet > cash_in_hand) {
                System.out.println("You can't bet more than the cash you have in your hand, try again!");
                break;
            }
            System.out.println("The deck is being shuffled now.");
            currentCard = player.pickCard();
            System.out.println(currentCard);
            player.sum = player.calculateSum(currentCard);
            currentCard = player.pickCard();
            System.out.println(currentCard);
            player.sum = player.sum + player.calculateSum(currentCard);
            System.out.println("Your current sum is: " + player.sum);
            currentCard = dealer.pickCard();
            System.out.println("Dealers card:");
            System.out.println(currentCard);
            dealer.sum = dealer.calculateSum(currentCard);

            while (true) {
                System.out.println("Hit or Stay or Exit?");
                userChose = input.next();
                System.out.println("Deck is being shuffled.");
                if (userChose.equalsIgnoreCase("Hit")) {
                    currentCard = player.pickCard();
                    System.out.println(currentCard);
                    player.sum = player.sum + player.calculateSum(currentCard);
                    System.out.println("Your current sum is " + player.sum);

                    currentCard = dealer.pickCard();
                    System.out.println("Dealers card");
                    System.out.println(currentCard);
                    dealer.sum = dealer.sum + dealer.calculateSum(currentCard);
                    System.out.println("Dealer sum is " + dealer.sum);
                    if (player.sum > 21) {
                        bust();
                        break;
                    } else if (player.sum == 21) {
                        System.out.println("BlakcJack!");
                        cash_in_hand = cash_in_hand + currentBet;
                        break;
                    }
                    if (dealer.sum > 21) {
                        dealerbust();
                        break;
                    }
                } else if (userChose.equalsIgnoreCase("Stay")) {
                    endGame(dealer, player);
                    break;
                } else if (userChose.equalsIgnoreCase("Exit")) {
                    System.exit(0);
                }
            }
        }
    }

    private static void endGame(Hand dealer, Hand player) {
        System.out.println("Thanks for playing!");
        currentCard = dealer.pickCard();
        System.out.println("Dealers card");
        System.out.println(currentCard);
        dealer.sum = dealer.sum + dealer.calculateSum(currentCard);
        System.out.println("Dealer sum is " + dealer.sum);
        if (dealer.sum > 21) {
            System.out.println("You won!");
        } else if (dealer.sum < 21) {
            if (player.sum > dealer.sum) {
                System.out.println("You won!");
                cash_in_hand = cash_in_hand + currentBet;
            } else if (player.sum == dealer.sum) {
                System.out.println("Push");
            } else {
                System.out.println("Dealer Won!");
                cash_in_hand = cash_in_hand - currentBet;
            }
        }
    }

    private static void bust() {
        System.out.println("Bust");
        System.out.println("You lost");
        cash_in_hand = cash_in_hand - currentBet;
        System.out.println("Current cash in hand is $" + cash_in_hand);
    }

    private static void dealerbust() {
        System.out.println("Dealer Bust");
        System.out.println("You won!");
        cash_in_hand = cash_in_hand + currentBet;
        System.out.println("Current cash in hand is $" + cash_in_hand);

    }

}
