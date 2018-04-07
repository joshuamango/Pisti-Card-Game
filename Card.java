import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card
{
    static final Card[] cards = {
            new Card(1,  'C', "PNG/AC.png"),
            new Card(2,  'C', "PNG/2C.png"),
            new Card(3,  'C', "PNG/3C.png"),
            new Card(4,  'C', "PNG/4C.png"),
            new Card(5,  'C', "PNG/5C.png"),
            new Card(6,  'C', "PNG/6C.png"),
            new Card(7,  'C', "PNG/7C.png"),
            new Card(8,  'C', "PNG/8C.png"),
            new Card(9,  'C', "PNG/9C.png"),
            new Card(10, 'C', "PNG/10C.png"),
            new Card(11, 'C', "PNG/JC.png"),
            new Card(12, 'C', "PNG/QC.png"),
            new Card(13, 'C', "PNG/KC.png"),
            new Card(1,  'D', "PNG/AD.png"),
            new Card(2,  'D', "PNG/2D.png"),
            new Card(3,  'D', "PNG/3D.png"),
            new Card(4,  'D', "PNG/4D.png"),
            new Card(5,  'D', "PNG/5D.png"),
            new Card(6,  'D', "PNG/6D.png"),
            new Card(7,  'D', "PNG/7D.png"),
            new Card(8,  'D', "PNG/8D.png"),
            new Card(9,  'D', "PNG/9D.png"),
            new Card(10, 'D', "PNG/10D.png"),
            new Card(11, 'D', "PNG/JD.png"),
            new Card(12, 'D', "PNG/QD.png"),
            new Card(13, 'D', "PNG/KD.png"),
            new Card(1,  'H', "PNG/AH.png"),
            new Card(2,  'H', "PNG/2H.png"),
            new Card(3,  'H', "PNG/3H.png"),
            new Card(4,  'H', "PNG/4H.png"),
            new Card(5,  'H', "PNG/5H.png"),
            new Card(6,  'H', "PNG/6H.png"),
            new Card(7,  'H', "PNG/7H.png"),
            new Card(8,  'H', "PNG/8H.png"),
            new Card(9,  'H', "PNG/9H.png"),
            new Card(10, 'H', "PNG/10H.png"),
            new Card(11, 'H', "PNG/JH.png"),
            new Card(12, 'H', "PNG/QH.png"),
            new Card(13, 'H', "PNG/KH.png"),
            new Card(1,  'S', "PNG/AS.png"),
            new Card(2,  'S', "PNG/2S.png"),
            new Card(3,  'S', "PNG/3S.png"),
            new Card(4,  'S', "PNG/4S.png"),
            new Card(5,  'S', "PNG/5S.png"),
            new Card(6,  'S', "PNG/6S.png"),
            new Card(7,  'S', "PNG/7S.png"),
            new Card(8,  'S', "PNG/8S.png"),
            new Card(9,  'S', "PNG/9S.png"),
            new Card(10, 'S', "PNG/10S.png"),
            new Card(11, 'S', "PNG/JS.png"),
            new Card(12, 'S', "PNG/QS.png"),
            new Card(13, 'S', "PNG/KS.png")
    };

    // CLUBS
    public static final Card ACEOFCLUBS   = new Card(1,  'C', "PNG/AC.png");
    public static final Card TWOOFCLUBS   = new Card(2,  'C', "PNG/2C.png");
    public static final Card THREEOFCLUBS = new Card(3,  'C', "PNG/3C.png");
    public static final Card FOUROFCLUBS  = new Card(4,  'C', "PNG/4C.png");
    public static final Card FIVEOFCLUBS  = new Card(5,  'C', "PNG/5C.png");
    public static final Card SIXOFCLUBS   = new Card(6,  'C', "PNG/6C.png");
    public static final Card SEVENOFCLUBS = new Card(7,  'C', "PNG/7C.png");
    public static final Card EIGHTOFCLUBS = new Card(8,  'C', "PNG/8C.png");
    public static final Card NINEOFCLUBS  = new Card(9,  'C', "PNG/9C.png");
    public static final Card TENOFCLUBS   = new Card(10, 'C', "PNG/10C.png");
    public static final Card JACKOFCLUBS  = new Card(11, 'C', "PNG/JC.png");
    public static final Card QUEENOFCLUBS = new Card(12, 'C', "PNG/QC.png");
    public static final Card KINGOFCLUBS  = new Card(13, 'C', "PNG/KC.png");

    // DIAMONDS
    public static final Card ACEOFDIAMONDS   = new Card(1,  'D', "PNG/AD.png");
    public static final Card TWOOFDIAMONDS   = new Card(2,  'D', "PNG/2D.png");
    public static final Card THREEOFDIAMONDS = new Card(3,  'D', "PNG/3D.png");
    public static final Card FOUROFDIAMONDS  = new Card(4,  'D', "PNG/4D.png");
    public static final Card FIVEOFDIAMONDS  = new Card(5,  'D', "PNG/5D.png");
    public static final Card SIXOFDIAMONDS   = new Card(6,  'D', "PNG/6D.png");
    public static final Card SEVENOFDIAMONDS = new Card(7,  'D', "PNG/7D.png");
    public static final Card EIGHTOFDIAMONDS = new Card(8,  'D', "PNG/8D.png");
    public static final Card NINEOFDIAMONDS  = new Card(9,  'D', "PNG/9D.png");
    public static final Card TENOFDIAMONDS   = new Card(10, 'D', "PNG/10D.png");
    public static final Card JACKOFDIAMONDS  = new Card(11, 'D', "PNG/JD.png");
    public static final Card QUEENOFDIAMONDS = new Card(12, 'D', "PNG/QD.png");
    public static final Card KINGOFDIAMONDS  = new Card(13, 'D', "PNG/KD.png");

    // HEARTS
    public static final Card ACEOFHEARTS   = new Card(1,  'H', "PNG/AH.png");
    public static final Card TWOOFHEARTS   = new Card(2,  'H', "PNG/2H.png");
    public static final Card THREEOFHEARTS = new Card(3,  'H', "PNG/3H.png");
    public static final Card FOUROFHEARTS  = new Card(4,  'H', "PNG/4H.png");
    public static final Card FIVEOFHEARTS  = new Card(5,  'H', "PNG/5H.png");
    public static final Card SIXOFHEARTS   = new Card(6,  'H', "PNG/6H.png");
    public static final Card SEVENOFHEARTS = new Card(7,  'H', "PNG/7H.png");
    public static final Card EIGHTOFHEARTS = new Card(8,  'H', "PNG/8H.png");
    public static final Card NINEOFHEARTS  = new Card(9,  'H', "PNG/9H.png");
    public static final Card TENOFHEARTS   = new Card(10, 'H', "PNG/10H.png");
    public static final Card JACKOFHEARTS  = new Card(11, 'H', "PNG/JH.png");
    public static final Card QUEENOFHEARTS = new Card(12, 'H', "PNG/QH.png");
    public static final Card KINGOFHEARTS  = new Card(13, 'H', "PNG/KH.png");

    // SPADES
    public static final Card ACEOFSPADES   = new Card(1,  'S', "PNG/AS.png");
    public static final Card TWOOFSPADES   = new Card(2,  'S', "PNG/2S.png");
    public static final Card THREEOFSPADES = new Card(3,  'S', "PNG/3S.png");
    public static final Card FOUROFSPADES  = new Card(4,  'S', "PNG/4S.png");
    public static final Card FIVEOFSPADES  = new Card(5,  'S', "PNG/5S.png");
    public static final Card SIXOFSPADES   = new Card(6,  'S', "PNG/6S.png");
    public static final Card SEVENOFSPADES = new Card(7,  'S', "PNG/7S.png");
    public static final Card EIGHTOFSPADES = new Card(8,  'S', "PNG/8S.png");
    public static final Card NINEOFSPADES  = new Card(9,  'S', "PNG/9S.png");
    public static final Card TENOFSPADES   = new Card(10, 'S', "PNG/10S.png");
    public static final Card JACKOFSPADES  = new Card(11, 'S', "PNG/JS.png");
    public static final Card QUEENOFSPADES = new Card(12, 'S', "PNG/QS.png");
    public static final Card KINGOFSPADES  = new Card(13, 'S', "PNG/KS.png");

    // CARD BACKS
    public static final Card BLUE  = new Card(0, 'B', "PNG/blue_back.png");
    public static final Card GRAY  = new Card(0, 'B', "PNG/gray_back.png");
    public static final Card GREEN = new Card(0, 'B', "PNG/green_back.png");
    public static final Card RED   = new Card(0, 'B', "PNG/red_back.png");

    //Attributes
    public int value;
    public char suit;
    public ImageView imagePath;

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
