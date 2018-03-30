public class Player
{
    //Attributes
    public Hand hand;
    private Deck captured;
    private boolean isTurn;
    private double points;

    //Constructor
    public Player()
    {
    }

    //Returns true if it is currently this players turn
    public boolean isTurn()
    {
        return isTurn;
    }

    //Set turn as true or false
    public void setTurn(boolean turn)
    {
        isTurn = turn;
    }

    //Returns a deck with the cards that are currently in the players hand
    public Hand getHand()
    {
        return hand;
    }

    public Deck getCaptured()
    {
        return captured;
    }

    //Adds the points for each card captured to the player's points
    public void getTotalPoints(Deck captured)
    {
        for (Card card: captured.deck)
        {
            this.points += card.getValue();
        }
    }
}