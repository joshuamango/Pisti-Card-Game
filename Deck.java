import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck
{
    //Attributes
    ArrayList<Card> deck = new ArrayList<>();

    //Constructor
    public Deck()
    {
        deck.addAll(Arrays.asList(Card.cards));
    }

    //Shuffle the deck
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    //Remove first card in the deck
    public Card popCard() throws Exception
    {
        if (!deck.isEmpty())
            return deck.remove(0);
        else
            throw new Exception("Deck Empty");
    }

    //Add four cards to the players hand
    public void dealPlayer(Player player) throws Exception
    {
        for(int i = 0; i < 4; i++)
            player.hand.pushCard(this);
    }

    public void addCard(Card card) throws Exception
    {
       deck.add(card);
    }
}
