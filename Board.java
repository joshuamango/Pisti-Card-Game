import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Board extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Create a StackPane
        StackPane stackPane = new StackPane();

        // Create a BorderPane
        BorderPane borderPane = new BorderPane();

        // Get Background Image and add it to stackPane
        ImageView greenFelt = new ImageView(new Image("PNG/Table.png", 1280, 720, true, true));
        stackPane.getChildren().addAll(greenFelt, borderPane);

        // Create an HBox and set alignment and spacing
        HBox playerCardPane = new HBox();
        playerCardPane.setSpacing(10);
        playerCardPane.setAlignment(Pos.CENTER);

        HBox botCardPane = new HBox();
        botCardPane.setSpacing(10);
        botCardPane.setAlignment(Pos.CENTER);

        // Add cardPane to the bottom of borderPane
        borderPane.setBottom(playerCardPane);
        borderPane.setTop(botCardPane);

        // Main draw deck
        Deck mainDeck = new Deck();
        mainDeck.shuffle();

        // Center discard pile
        Pile pile = new Pile();

        Hand playerHand = new Hand(mainDeck);
        Hand botHand = new Hand(mainDeck);

        // Add the player's cards to the playerCardPane
        for (Card card : playerHand.hand) {
            playerCardPane.getChildren().add(card.getImage());
        }

        // Create a card and add it to cardPane
        for (Card card : botHand.hand) {
            botCardPane.getChildren().add(card.getImage());
        }

        playerCardPane.getChildren().get(3).setOnMouseClicked(event -> {
            playerCardPane.getChildren().remove(3);
        });

        playerCardPane.getChildren().get(0).setOnMouseClicked(event -> {
            playerCardPane.getChildren().remove(0);
        });

        playerCardPane.getChildren().get(1).setOnMouseClicked(event -> {
            playerCardPane.getChildren().remove(1);
        });

        playerCardPane.getChildren().get(2).setOnMouseClicked(event -> {
            playerCardPane.getChildren().remove(2);
        });
        // Create a Scene and add it to the stage
        Scene scene = new Scene(stackPane, 1060, 720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pisti");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
