import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Card
{
    //Define each card
    public static final Card THREEOFSPADES = new Card(3, 'S', "PNG/3S.png");
    public static final Card THREEOFCLUBS = new Card(3, 'C', "PNG/3C.png");
    public static final Card THREEOFHEARTS = new Card(3, 'H', "PNG/3H.png");
    public static final Card THREEOFDIAMONDS = new Card(3, 'D', "PNG/3D.png");

    //Attributes
    private int value;
    private char suit;
    private ImageView imagePath;

    //Constructor
    public Card(int value, char suit, String imagePath)
    {
        this.value = value;
        this.suit = suit;
        this.imagePath = new ImageView(new Image(imagePath, 100, 200, true, false));
    }

    //Return the value of the card
    public int getValue()
    {
        return value;
    }

    //Return the suit of the card
    public char getSuit()
    {
        return suit;
    }

    //Return the image of the card
    public ImageView getImage() { return imagePath; }
}