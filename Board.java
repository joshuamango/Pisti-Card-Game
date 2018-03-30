import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Board extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Create Pane with green felt background
        Pane backgroundPane = new Pane();
        ImageView background = new ImageView(new Image("PNG/Table.png", 1366, 768,
                true, false));

        //Bind the width and height of the background image to the pane's width and height
        background.fitHeightProperty().bind(backgroundPane.heightProperty());
        background.fitWidthProperty().bind(backgroundPane.widthProperty());

        //Add the background to the pane
        backgroundPane.getChildren().add(background);

        //Pane for cards
        Pane pane = new Pane();

        Deck deck = new Deck();
        Font font = Font.font("Times New Roman", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 50);
        Label label = new Label("Pile: ");
        label.setFont(font);
        label.setEffect(new DropShadow(10, 5, 5, Color.BLACK));
        label.setLayoutX(600);
        label.setLayoutY(300);
        label.setStyle("-fx-fill-color: white");

        //Create card images
        for (int i = 0; i < 4; i++)
        {
            Card card = deck.popCard();
            if (i == 0 || i == 2)
                card.getImage().setRotate(30);
            else
                card.getImage().setRotate(-30);
            card.getImage().setEffect(new DropShadow(20, 10, 10,  Color.BLACK));
            card.getImage().setX(i * 100);
            card.getImage().setY(i * 200);
            pane.getChildren().add(card.getImage());
        }

        //Testing EventHandling on the first card image
        for (int i = 0; i < 4; i++)
        {
            pane.getChildren().get(i).setOnMouseClicked( event -> {
                System.out.println("Card Image Clicked!");
            });
        }



        pane.getChildren().add(label);
        //StackPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(backgroundPane);
        stackPane.getChildren().add(pane);


        //Add pane to scene
        Scene scene = new Scene(stackPane);

        //Add scene to stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pişti");
        primaryStage.show();
    }
}
