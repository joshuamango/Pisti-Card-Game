import java.util.ArrayList;

public class Hand
{
    //Attributes
    ArrayList<Card> hand = new ArrayList<>();

    //Constructor
    public Hand(Deck deck)
    {
        // Add four cards to the hand
        try {
            this.pushCard(deck);
            this.pushCard(deck);
            this.pushCard(deck);
            this.pushCard(deck);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Methods
    public Card popCard(Card card) throws Exception
    {
        if (hand.size() > 0)
            return hand.get(hand.indexOf(card));
        else
            throw new Exception("Hand Empty");
    }

    public void pushCard(Deck deck) throws Exception
    {
        if (hand.size() < 4)
            hand.add(deck.popCard());
        else
            throw new Exception("Hand Full");
    }
}
