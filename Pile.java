public class Pile extends Deck
{
    //Attributes
    private String lastCaptured = "";

    //Constructor
    public Pile()
    {
        deck.clear();
    }


    public Card getTopCard()
    {
        if (deck.size() > 0)
            return deck.get(deck.size() - 1);
        else
            return Card.BLUE;
    }

    public void setLastCaptured(String player)
    {
        lastCaptured = player;
    }

    public String getLastCaptured()
    {
        return lastCaptured;
    }
}
