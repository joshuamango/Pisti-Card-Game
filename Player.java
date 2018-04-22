import java.util.ArrayList;

public class Player
{
    //Attributes
    ArrayList<Card> capturedCards = new ArrayList<>();
    private boolean isTurn;
    private int score;

    //Constructor
    public Player()
    {

    }

    //Adds the points for each card captured to the player's points
    public void calculateScore()
    {
        for (Card card: capturedCards)
        {
            if (card.getValue() == 10 && card.getSuit() == 'D')
                score += 3;
            else if (card.getValue() == 2 && card.getSuit() == 'C')
                score += 2;
            else if (card.getValue() == 1 || card.getValue() == 10 || card.getValue() == 11 || card.getValue() == 12 || card.getValue() == 13)
                score += 1;
            else
                score += 3;
        }
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

    // Returns the player's current score
    public int getScore()
    {
        return score;
    }

    // Adds ten points to the player's score
    public void pisti() { score += 10; }

    // Adds twenty points to the player's score
    public void doublePisti() { score += 20; }
}
