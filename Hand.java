public class Hand extends Deck
{
    //Attributes
    private int numberOfCards;

    //Constructor
    public Hand()
    {
    }

    //Methods
    public void playCard(Card card, Pile pile) throws Exception
    {
        if (deck.contains(card))
        {
            int index = deck.indexOf(card);
            pile.deck.add(deck.remove(index));
            numberOfCards--;
        }
        else
            throw new Exception("Card not in hand");
    }

    public void addCard(Card card) throws Exception
    {
        if (deck.contains(card))
        {
            deck.add(card);
            numberOfCards++;
        }
        else
            throw new Exception("Card not in hand");
    }
}
