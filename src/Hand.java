
	import java.util.Random;

	public class Hand {

	    int sum;

	    public Hand() {
	        sum = 0;
	    }

	    public String pickCard() {
	        Random r = new Random();
	        Deck deckobj = new Deck();
	        int random = r.nextInt(deckobj.deck.size());
	        String card = deckobj.deck.get(random).toString();
	        return card;
	    }

	    public int calculateSum(String card) {
	        if (card.contains("Q") || card.contains("K") || card.contains("J")) {
	            return 10;
	        } else if (card.contains("A")) {
	            if (sum + 11 > 21) {
	                return 1;

	            } else {
	                return 11;
	            }

	        }
	        return Integer.parseInt(String.valueOf(card.charAt(0)));
	    }
	}

