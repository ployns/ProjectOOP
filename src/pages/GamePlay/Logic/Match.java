package pages.GamePlay.Logic;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;

public abstract class Match {

    public DeckCard deckCard = new DeckCard();
    public ArrayList<Player> players = new ArrayList<>();

    public Card communityCard;

    public Scanner scanner = new Scanner(System.in);


//    public Gameplay_Controller gameplay_controller = new Gameplay_Controller();

    Match(){

    }

    public Match(String name, int numberOfBot){
        if (numberOfBot >= 2) {
            // players.add(new User(nameUser));
            players.add(new Bot("firstBot"));
            players.add(new Bot("secondBot"));
        }
        if (numberOfBot >= 3) {
            players.add(new Bot("thirdBot"));
        }
        if (numberOfBot >= 4) {
            players.add(new Bot("forthBot"));
        }
        players.add(new User(name));
        deckCard.displayDeckCard();
        deckCard.shuffleDeckCards();

    }

    public void dealCard(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < players.size(); j++) {
                players.get(j).handCard.add(deckCard.dropDeckCard());
                // players.get(j).drawCard(deckCard.dropDeckCard());
            }
        }
        communityCard = deckCard.dropDeckCard();
    }

    public boolean isCheckmate(){
        for (Player player : players) {
            if (player.handCard.isEmpty() == true || player.playerRequestCheckmate == true) {
                return true;
            }
        }
        return false;
    }

    public void loop(){
//        Gameplay_Controller gameplay_controller = new Gameplay_Controller();
        while (deckCard.getDeckCards().isEmpty() == false && isCheckmate() == false) {
            for (Player player : players) {
                // player.getClass().getName().equals("User")) == player instanceof User
                if (player instanceof User) {
                    reactionForUser(player);
//                    gameplay_controller.cardLeft_User.setText(String.valueOf(player.handCard.size()));
                } else {
                    reactionForBOT(player);
                }
//                gameplay_controller.communityCard.setText(communityCard.toString());
                if (player.handCard.isEmpty()) {
                    break;
                }

            }
        }
    }


    public void reactionForUser(Player player){
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gameplay/Gameplay.fxml"));
//        root = loader.load();
//        Gameplay_Controller gameplay_controller = loader.getController();
//

        int select = 0;
        System.out.println("\ncommunity card : " + communityCard.toString());
        player.displayHandCard();
        ArrayList<Card> droppedCard = player.dropCard(communityCard);

//        System.out.print("\nDrop[1] Or Draw[2] Or CheckMate[3] : ");
//        select = scanner.nextInt();
        ActionEvent event = new ActionEvent();
//        while (true) {
//            if (gameplay_controller.dropCardButton(event)) {
//            // player.dropCard(communityCard);
//                if (droppedCard.isEmpty() == false) {
//                    communityCard = droppedCard.get(droppedCard.size()-1);
//                    System.out.println("drop card");
//                    break;
//                } else {
//                    System.out.println("You can not drop card. please click Drop[2] or CheckMate[3] ");
//                }
//                // check = false;
//            }
//            if (gameplay_controller.drawCardButton(event)) {
//                if (droppedCard.isEmpty() == true) {
//                    droppedCard = player.drawCard(deckCard.dropDeckCard());
//                    communityCard = droppedCard.get(droppedCard.size()-1);
//                    break;
//                } else {
//                    System.out.println("You can not draw card , You can drop card. please click Drop[1]");
//                }
//            }
//            if (gameplay_controller.checkmateButton(event)){
//                player.checkmate();
//                System.out.println("User Checkmate");
//                break;
//            }
//
////            System.out.print("\nDrop[1] Or Draw[2] Or CheckMate[3] : ");
////            select = scanner.nextInt();
//
//        }
        
    }

    public void reactionForBOT(Player player){
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Gameplay/Gameplay.fxml"));
//        root = loader.load();
//        Gameplay_Controller gameplay_controller = loader.getController();
        // System.out.println("\n\nnext card in deckCard : " + deckCard.getDeckCards().get(0));
        System.out.println("\ncommunity card : " + communityCard.toString());
        player.displayHandCard();
        System.out.print(player.name + " check drop card : \t");
        ArrayList<Card> droppedCard = player.dropCard(communityCard);
        if (droppedCard.isEmpty() == true){
            droppedCard = player.drawCard(deckCard.dropDeckCard());
        }
        communityCard = droppedCard.get(droppedCard.size()-1);



//        if (player.name.equals("firstBot")){
//            gameplay_controller.bot_1.setText(String.valueOf(player.handCard.size()));
////            gameplay_controller.dropCard_Bot_1.setText(droppedCard.toString());
//        }
//        if (player.name.equals("secondBot")){
//            gameplay_controller.bot_2.setText(String.valueOf(player.handCard.size()));
//        }
//        if (player.name.equals("thirdBot")){
//            gameplay_controller.bot_3.setText(String.valueOf(player.handCard.size()));
//        }


    }

    public void result(){
        System.out.println();
        deckCard.displayDeckCard();
        int minScore = players.get(0).getScoreCard();
        Player winPlayer = players.get(0);
        for (Player player : players) {
            player.displayHandCard();
            System.out.println(player.getScoreCard());
            if (minScore > player.getScoreCard()) {
                minScore = player.getScoreCard();
                winPlayer = player;
            }
        }

        System.out.println(winPlayer.name + " WIN ");
    }

}
