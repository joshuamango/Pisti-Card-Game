import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.text.*;

public class Board extends Application
{

   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage)
   {
      // Create a StackPane
      StackPane stackPane = new StackPane();
   
      // Create a BorderPane
      BorderPane borderPane = new BorderPane();
   
      // Get Background Image and add it to stackPane
      ImageView greenFelt = new ImageView(new Image("PNG/Table.png", 1280, 720, true, true));
      stackPane.getChildren().addAll(greenFelt, borderPane);
   
      // Create an HBox for the center pile
      HBox centerPane = new HBox();
      centerPane.setAlignment(Pos.CENTER);
      centerPane.setSpacing(100);
   
      // Create an HBox and set alignment and spacing
      HBox playerCardPane = new HBox();
      playerCardPane.setSpacing(10);
      playerCardPane.setAlignment(Pos.CENTER);

      // Create an HBox
      HBox botCardPane = new HBox();
      botCardPane.setSpacing(10);
      botCardPane.setAlignment(Pos.CENTER);
   
      // Add cardPane to the bottom of borderPane
      borderPane.setBottom(playerCardPane);
      borderPane.setTop(botCardPane);
      borderPane.setCenter(centerPane);

      // Text for statistics
       Text numberOfCardsInPile = new Text();
       numberOfCardsInPile.setStroke(Color.BLACK);
       numberOfCardsInPile.setFill(Color.WHITE);
       numberOfCardsInPile.setFont(Font.font(100));
       numberOfCardsInPile.setX(-200);
       centerPane.getChildren().add(numberOfCardsInPile);
   
      // Main draw deck
      Deck mainDeck = new Deck();
      mainDeck.shuffle();
   
      // Center discard pile
      Pile pile = new Pile();
       numberOfCardsInPile.setText(String.valueOf(pile.deck.size()));

      // Create a hand for the player and bot
      Hand playerHand = new Hand(mainDeck);
      Hand botHand = new Hand(mainDeck);

      // Create a player and a bot
       Player player = new Player();
       Player bot = new Player();


      /* Add the image of each card in playerHand to playerCardPane
      and register handling for MouseClicked events */
       for (Card card : playerHand.hand)
       {
           // Add each card image to the pane
           playerCardPane.getChildren().add(card.getImage());

           // If any of the card images in the pane are clicked
           card.getImage().setOnMouseClicked(event ->

           {
               // Remove the card image from the pane
               playerCardPane.getChildren().remove(card.getImage());

               try
               {
                   // Remove the card from the hand and add it to the pile
                   if (playerHand.hand.contains(card))
                   {
                       System.out.println("Index: " + playerHand.hand.indexOf(card));
                       pile.addCard(playerHand.hand.remove(playerHand.hand.indexOf(card)));
                   }

                   // Capture deck if a card of the same value as the current top card on the pile is played
                   if (pile.deck.size() > 1)
                   {
                       if (pile.deck.get(pile.deck.size() - 1).getValue() == pile.deck.get(pile.deck.size() - 2).getValue())
                       {
                           if (pile.deck.size() == 2)
                               player.pisti();
                           player.capturedCards.addAll(pile.deck);
                           pile.deck.clear();
                           pile.setLastCaptured("player");
                       }
                   }

                   // Capture deck if a jack is played
                   if (pile.deck.size() > 1)
                   {
                       if (pile.deck.get(pile.deck.size() - 1).getValue() == 11)
                       {
                           if (pile.deck.get(pile.deck.size() - 2).getValue() == 11 && pile.deck.size() == 2)
                               player.doublePisti();
                           player.capturedCards.addAll(pile.deck);
                           pile.deck.clear();
                           pile.setLastCaptured("player");
                       }
                   }

                   // Refresh the pile so the top card is shown
                   centerPane.getChildren().clear();
                   centerPane.getChildren().addAll(numberOfCardsInPile, pile.getTopCard().getImage());
                   numberOfCardsInPile.setText(String.valueOf(pile.deck.size()));
               } catch (Exception ex)
               {
                   ex.printStackTrace();
               }
           });
       }
   
      // Add the image of each card in botHand to botCardPane
      for (Card card : botHand.hand)
      {
          // Add each card image to the pane
          botCardPane.getChildren().add(card.getImage());

          // If any of the card images in the pane are clicked
          card.getImage().setOnMouseClicked(event ->
          {
              // Remove the card image from the pane
              botCardPane.getChildren().remove(card.getImage());

              try
              {
                  // Remove the card from the hand and add it to the pile
                  if (botHand.hand.contains(card))
                  {
                      System.out.println("Index: " + botHand.hand.indexOf(card));
                      pile.addCard(botHand.hand.remove(botHand.hand.indexOf(card)));
                  }

                  if (pile.deck.size() > 1)
                  {
                      if (pile.deck.get(pile.deck.size() - 1).getValue() == pile.deck.get(pile.deck.size() - 2).getValue())
                      {
                          if (pile.deck.size() == 2)
                              bot.pisti();
                          bot.capturedCards.addAll(pile.deck);
                          pile.deck.clear();
                          pile.setLastCaptured("bot");
                      }
                  }

                  // Capture deck if a jack is played
                  if (pile.deck.size() > 1)
                  {
                      if (pile.deck.get(pile.deck.size() - 1).getValue() == 11)
                      {
                          if (pile.deck.get(pile.deck.size() - 2).getValue() == 11 && pile.deck.size() == 2)
                              bot.doublePisti(); System.out.println("Double Pisti!");
                          bot.capturedCards.addAll(pile.deck);
                          pile.deck.clear();
                          pile.setLastCaptured("bot");
                      }
                  }

                  // Refresh the pile so the top card is shown
                  centerPane.getChildren().clear();
                  centerPane.getChildren().addAll(numberOfCardsInPile, pile.getTopCard().getImage());
                  numberOfCardsInPile.setText(String.valueOf(pile.deck.size()));

              } catch (Exception ex)
              {
                  ex.printStackTrace();
              }
          });
      }

      // Deal four cards to an empty hand
       botCardPane.getChildren().addListener((InvalidationListener) observable -> {
           if (botCardPane.getChildren().isEmpty())
           {
               try
               {
                   // Deal four cards to the player
                   for (int i = 0; i < 4; i++) {
                       botHand.pushCard(mainDeck);
                       System.out.println("Hand Size: " + botHand.hand.size());
                   }

                   for (Card card : botHand.hand)
                   {
                       // Add each card image to the pane
                       botCardPane.getChildren().add(card.getImage());

                       // If any of the card images in the pane are clicked
                       card.getImage().setOnMouseClicked(event ->
                       {
                           // Remove the card image from the pane
                           botCardPane.getChildren().remove(card.getImage());

                           try
                           {
                               // Remove the card from the hand and add it to the pile
                               if (botHand.hand.contains(card))
                               {
                                   System.out.println("Index: " + botHand.hand.indexOf(card));
                                   pile.addCard(botHand.hand.remove(botHand.hand.indexOf(card)));
                               }

                               if (pile.deck.size() > 1)
                               {
                                   if (pile.deck.get(pile.deck.size() - 1).getValue() == pile.deck.get(pile.deck.size() - 2).getValue())
                                   {
                                       if (pile.deck.size() == 2)
                                           bot.pisti();
                                       bot.capturedCards.addAll(pile.deck);
                                       pile.deck.clear();
                                       pile.setLastCaptured("bot");
                                   }
                               }

                               // Capture deck if a jack is played
                               if (pile.deck.size() > 1)
                               {
                                   if (pile.deck.get(pile.deck.size() - 1).getValue() == 11)
                                   {
                                       if (pile.deck.get(pile.deck.size() - 2).getValue() == 11 && pile.deck.size() == 2)
                                           bot.doublePisti();
                                       bot.capturedCards.addAll(pile.deck);
                                       pile.deck.clear();
                                       pile.setLastCaptured("bot");
                                   }
                               }

                               // Refresh the pile so the top card is shown
                               centerPane.getChildren().clear();
                               centerPane.getChildren().addAll(numberOfCardsInPile, pile.getTopCard().getImage());
                               numberOfCardsInPile.setText(String.valueOf(pile.deck.size()));
                           } catch (Exception ex)
                           {
                               ex.printStackTrace();
                           }
                       });
                   }
               }
               catch (Exception ex)
               {
                   // Calculate the score of the bot
                   if (pile.getLastCaptured().equals("bot"))
                       if (pile.deck.size() > 0)
                           bot.capturedCards.addAll(pile.deck);
                   bot.calculateScore();
                   Text score = new Text("Score: " + String.valueOf(bot.getScore()));
                   score.setFont(Font.font(100));
                   score.setStroke(Color.BLACK);
                   score.setFill(Color.WHITE);

                   // Clear the bot's hand and display the final score
                   botCardPane.getChildren().add(score);

                   centerPane.getChildren().clear();


                   System.out.println(bot.getScore());
               }
           }

       });

       // Deal four cards to an empty hand
       playerCardPane.getChildren().addListener((InvalidationListener) observable -> {
           if (playerCardPane.getChildren().isEmpty())
           {
               try
               {
                   // Add four cards to the players hand
                   for (int i = 0; i < 4; i++) {
                       playerHand.pushCard(mainDeck);
                       System.out.println("Hand Size: " + playerHand.hand.size());
                   }

                   // Add the image of each card to the playerCardPane and register handling
                   for (Card card : playerHand.hand)
                   {
                       // Add each card image to the pane
                       playerCardPane.getChildren().add(card.getImage());

                       // If any of the card images in the pane are clicked
                       card.getImage().setOnMouseClicked(event ->
                       {
                           // Remove the card image from the pane
                           playerCardPane.getChildren().remove(card.getImage());

                           try
                           {
                               // Remove the card from the hand and add it to the pile
                               if (playerHand.hand.contains(card))
                               {
                                   System.out.println("Index: " + playerHand.hand.indexOf(card));
                                   pile.addCard(playerHand.hand.remove(playerHand.hand.indexOf(card)));
                               }

                               // Capture deck if a card of the same value as the current top card on the pile is played
                               if (pile.deck.size() > 1)
                               {
                                   if (pile.deck.get(pile.deck.size() - 1).getValue() == pile.deck.get(pile.deck.size() - 2).getValue())
                                   {
                                       if (pile.deck.size() == 2)
                                           player.pisti();
                                       player.capturedCards.addAll(pile.deck);
                                       pile.deck.clear();
                                       pile.setLastCaptured("player");
                                   }
                               }

                               // Capture deck if a jack is played
                               if (pile.deck.size() > 1)
                               {
                                   if (pile.deck.get(pile.deck.size() - 1).getValue() == 11)
                                   {
                                       if (pile.deck.get(pile.deck.size() - 2).getValue() == 11 && pile.deck.size() == 2)
                                           player.doublePisti();
                                       player.capturedCards.addAll(pile.deck);
                                       pile.deck.clear();
                                       pile.setLastCaptured("player");
                                   }
                               }

                               // Refresh the pile so the top card is shown
                               centerPane.getChildren().clear();
                               centerPane.getChildren().addAll(numberOfCardsInPile, pile.getTopCard().getImage());
                               numberOfCardsInPile.setText(String.valueOf(pile.deck.size()));
                           } catch (Exception ex)
                           {
                               ex.printStackTrace();
                           }
                       });
                   }
               }
               catch (Exception ex)
               {
                   if (pile.getLastCaptured().equals("player"))
                       if (pile.deck.size() > 1)
                           player.capturedCards.addAll(pile.deck);
                   player.calculateScore();
                   Text score = new Text("Score: " + String.valueOf(player.getScore()));
                   score.setFont(Font.font(100));
                   score.setStroke(Color.BLACK);
                   score.setFill(Color.WHITE);

                   // Clear the bot's hand and display the final score
                   playerCardPane.getChildren().add(score);
                   centerPane.getChildren().clear();


                   System.out.println(player.getScore());
               }
           }
       });



      // Add the top card in the pile to centerPane
      centerPane.getChildren().add(pile.getTopCard().getImage());

       // Print the number of cards in the stack when the topCard is clicked
       centerPane.setOnMouseClicked(event -> {
           System.out.println(pile.deck.size());
           System.out.println(botHand.hand.size());
       });

      // Create a Scene and add it to the stage
      Scene scene = new Scene(stackPane, 1060, 720);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Pisti");
      primaryStage.setResizable(false);
      primaryStage.show();
   }
}
