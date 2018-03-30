import java.util.Collections;

public class Pile extends Deck
{
    //Atributes
    private int numberOfCards;
    private Card topCard;

    //Constructor
    public Pile()
    {
        numberOfCards = 4;
        topCard = deck.get(deck.size() - 1);
    }
    //Methods
    public void capture(Player player, Card card) throws Exception
    {
        player.getCaptured().addCard(card);
    }
}
