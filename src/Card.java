
public class Card {

    private int faceValue;
    private String suit;

    public Card(String suit1, int facevalue1) {
        faceValue = facevalue1;
        suit = suit1;

    }

    @Override
    public String toString() {
        if (faceValue == 1) {
            return "A" + suit;
        } else if (faceValue == 11) {
            return "J" + suit;
        } else if (faceValue == 12) {
            return "Q" + suit;
        } else if (faceValue == 13) {
            return "K" + suit;
        } else {
            return faceValue + suit;
        }
    }

}
