package pages.GamePlay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import pages.GamePlay.Logic.Bot;
import pages.GamePlay.Logic.Card;
import pages.GamePlay.Logic.Match;
import pages.GamePlay.Logic.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Gameplay_5P_Controller implements Initializable {


    @FXML
    private Label bot_1;

    @FXML
    private Label cardLeft_Bot_1;

    @FXML
    private Label dropCard_Bot_1;

    @FXML
    private Label bot_2;

    @FXML
    private Label cardLeft_Bot_2;

    @FXML
    private Label dropCard_Bot_2;

    @FXML
    private Label bot_3;

    @FXML
    private Label cardLeft_Bot_3;

    @FXML
    private Label dropCard_Bot_3;
    
     @FXML
    private Label bot_4;

     @FXML
    private Label cardLeft_Bot_4;

    @FXML
    private Label dropCard_Bot_4;

    @FXML
    private Pane userControlPane;

    @FXML
    private Label user;

    @FXML
    private Label cardLeft_User;

    @FXML
    private Label communityCardLeft_Label;

    @FXML
    private Label communityCard_Label;

    @FXML
    private Label dropCard_User;

    @FXML
    private HBox handCardUser_HBox;

    private Button cardButton_1;

    private Button cardButton_2;

    private Button cardButton_3;

    private Button cardButton_4;

    private Button cardButton_5;

    private Button cardButton_6;

    ArrayList<Card> droppedCard = new ArrayList<>();

    boolean checkDrawCard = false;
    
    @FXML
    private Rectangle Rectangle_Bot1;
    @FXML
    private Rectangle Rectangle_Bot2;
    @FXML
    private Rectangle Rectangle_Bot3;
    @FXML
    private Rectangle Rectangle_Bot4;
    @FXML
    private Rectangle Rectangle_User;
    @FXML
    private Rectangle imageCommunityCard;
    @FXML
    private Rectangle imageDeckCard;
    @FXML
    private Rectangle imageDropCard_Bot_1_1;
    @FXML
    private Rectangle imageDropCard_Bot_1_2;
    @FXML
    private Rectangle imageDropCard_Bot_1_3;
    @FXML
    private Rectangle imageDropCard_Bot_2_1;
    @FXML
    private Rectangle imageDropCard_Bot_2_2;
    @FXML
    private Rectangle imageDropCard_Bot_2_3;
    @FXML
    private Rectangle imageDropCard_Bot_3_1;
    @FXML
    private Rectangle imageDropCard_Bot_3_2;
    @FXML
    private Rectangle imageDropCard_Bot_3_3;
    @FXML
    private Rectangle imageDropCard_Bot_4_1;
    @FXML
    private Rectangle imageDropCard_Bot_4_2;
    @FXML
    private Rectangle imageDropCard_Bot_4_3;

    @FXML
    private Rectangle imageDropCard_User_1;
    @FXML
    private Rectangle imageDropCard_User_2;
    @FXML
    private Rectangle imageDropCard_User_3;
    private Rectangle imageDropCard_User_4;
    @FXML
    private Rectangle dropCard;
    @FXML
    private Rectangle drawCard;
    @FXML
    private Rectangle checkMate;
    @FXML
    private Rectangle rectangleCard_1;
    @FXML
    private Rectangle rectangleCard_2;
    @FXML
    private Rectangle rectangleCard_3;
    @FXML
    private Rectangle rectangleCard_4;
    @FXML
    private Rectangle rectangleCard_5;
    @FXML
    private Rectangle rectangleCard_6;


    Match match = new Match("User", 4) {

    };
    @FXML
    private AnchorPane AnchorPaneGamePlay_5P;
    @FXML
    private Pane finishGamePane;
    @FXML
    private Rectangle BGfinish;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                finishGamePane.setVisible(false);
                dropCard_Bot_1.setVisible(false);
                dropCard_Bot_2.setVisible(false);
                dropCard_Bot_3.setVisible(false);
                dropCard_Bot_4.setVisible(false);
                dropCard_User.setVisible(false);
                communityCard_Label.setVisible(false);
        try {
            shapeFillImage(Rectangle_User,"assets/Play/User.png");
            shapeFillImage(Rectangle_Bot1,"assets/Play/Bot1.png");
            shapeFillImage(Rectangle_Bot2,"assets/Play/Bot2.png");
            shapeFillImage(Rectangle_Bot3,"assets/Play/Bot3.png");
            shapeFillImage(dropCard,"assets/Play/Drop.png");
            shapeFillImage(drawCard,"assets/Play/Draw.png");
            shapeFillImage(checkMate,"assets/Play/Checkmate.png");
            shapeFillImage(imageDeckCard,"assets/Card/Deckcard.png");
            shapeFillImage(BGfinish,"assets/Play/BGfinish.jpg");
            
        } catch (IOException ex) {
            Logger.getLogger(Gameplay_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imageDropCard_User_1.setVisible(false);
        imageDropCard_User_2.setVisible(false);
        imageDropCard_User_3.setVisible(false);

        match.dealCard();

        match.deckCard.displayDeckCard();

        setTextInGameplay();

        setHandCardUser(match.players.get(4).handCard);

        updateGamePlay();
    }
    
    public void isDeckCardLeft(){
       if (match.deckCard.getDeckCards().isEmpty() == true){
            setTextInGameplay();
       }
    }

    @FXML
    void dropCardButton(MouseEvent event) {
        System.out.println("drop CardButton");
        Player playerUser = match.players.get(4);
        System.out.println("\ncommunity card : " + match.communityCard.toString());
        playerUser.displayHandCard();
        if (checkDrawCard == false) {
            if (checkDropCard() == true) {
                playerUser.handCard.removeAll(droppedCard);
                match.communityCard = droppedCard.get(droppedCard.size() - 1);
                System.out.println("drop card");
//                    break;
                setHandCardUser(playerUser.handCard);
                dropCard_User.setText(droppedCard.toString());
                imageDropCard_User_1.setVisible(false);
                imageDropCard_User_2.setVisible(false);
                imageDropCard_User_3.setVisible(false);
                imageDropCard_User_4.setVisible(false);
                if (droppedCard.size()>=1){
                    try {
                        shapeFillImage(imageDropCard_User_1,"assets/Card/"+droppedCard.get(0).toString()+".png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageDropCard_User_1.setVisible(true);
                }
                if (droppedCard.size()>=2){
                    try {
                        shapeFillImage(imageDropCard_User_2,"assets/Card/"+droppedCard.get(1).toString()+".png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageDropCard_User_2.setVisible(true);
                }
                if (droppedCard.size()>=3){
                    try {
                        shapeFillImage(imageDropCard_User_3,"assets/Card/"+droppedCard.get(2).toString()+".png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageDropCard_User_3.setVisible(true);
                }
                setTextInGameplay();
                updateGamePlay();
            } else {
                System.out.println("You can not drop card. please click Drop[2] or CheckMate[3] ");
            }
        } else {
            dropCard_User.setText("Choose Card");
            System.out.println(droppedCard);
            if (droppedCard.isEmpty() == false) {
                playerUser.handCard.removeAll(droppedCard);
                setHandCardUser(playerUser.handCard);
                match.communityCard = droppedCard.get(droppedCard.size() - 1);
                System.out.println("drop card");
                dropCard_User.setText(droppedCard.toString());
                imageDropCard_User_1.setVisible(false);
                imageDropCard_User_2.setVisible(false);
                imageDropCard_User_3.setVisible(false);
               // imageDropCard_User_4.setVisible(false);
                if (droppedCard.size()>=1){
                    try {
                        shapeFillImage(imageDropCard_User_1,"assets/Card/"+droppedCard.get(0).toString()+".png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageDropCard_User_1.setVisible(true);
                }
                if (droppedCard.size()>=2){
                    try {
                        shapeFillImage(imageDropCard_User_2,"assets/Card/"+droppedCard.get(1).toString()+".png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageDropCard_User_2.setVisible(true);
                }
                if (droppedCard.size()>=3){
                    try {
                        shapeFillImage(imageDropCard_User_3,"assets/Card/"+droppedCard.get(2).toString()+".png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageDropCard_User_3.setVisible(true);
                }
                setTextInGameplay();

                updateGamePlay();
            }
        }

        droppedCard.clear();
    }

    @FXML
    void drawCardButton(MouseEvent event) throws IOException {
        isCardLeft();
        System.out.println("draw CardButton");
        Player playerUser = match.players.get(4);
//        return event.isConsumed();
        droppedCard = playerUser.dropCard(match.communityCard);
        if (checkDrawCard == false && droppedCard.isEmpty() == true) {

//            droppedCard = playerUser.drawCard(match.deckCard.dropDeckCard());//<<<<<<<
//            match.communityCard = droppedCard.get(droppedCard.size()-1);
            playerUser.handCard.add(match.deckCard.dropDeckCard());
//            dropCard_User.setText(droppedCard.toString());
//            setTextInGameplay();
            setHandCardUser(playerUser.handCard);
            checkDrawCard = true;
        } else {
            System.out.println("You can not draw card , You can drop card. please click Drop[1]");
        }
    }

    @FXML
    public void checkmateButton(MouseEvent event) throws IOException {        
        finishGamePane.setVisible(true);

    }
    
    public Match getMatch(){
        return match;
    }

    void indexCardButton_1(ActionEvent event) {
        setDroppedCard(0);
    }

    void indexCardButton_2(ActionEvent event) {
        setDroppedCard(1);
    }

    void indexCardButton_3(ActionEvent event) {
        setDroppedCard(2);
    }

    void indexCardButton_4(ActionEvent event) {
        setDroppedCard(3);
    }

    void indexCardButton_5(ActionEvent event) {
        setDroppedCard(4);
    }

    void indexCardButton_6(ActionEvent event) {
        setDroppedCard(5);
    }

    
    @FXML
    void indexCardRectangle_1(MouseEvent event) {
        setDroppedCard(0);
    }

    @FXML
    void indexCardRectangle_2(MouseEvent event) {
        setDroppedCard(1);
    }

    @FXML
    void indexCardRectangle_3(MouseEvent event) {
        setDroppedCard(2);
    }

    @FXML
    void indexCardRectangle_4(MouseEvent event) {
        setDroppedCard(3);
    }

    @FXML
    void indexCardRectangle_5(MouseEvent event) {
        setDroppedCard(4);
    }

    @FXML
    void indexCardRectangle_6(MouseEvent event) {
        setDroppedCard(5);
    }

    public void setTextInGameplay() {

        bot_1.setText(match.players.get(0).getName());
        bot_2.setText(match.players.get(1).getName());
        bot_3.setText(match.players.get(2).getName());
        bot_4.setText(match.players.get(3).getName());
        user.setText(match.players.get(4).getName());

        cardLeft_Bot_1.setText(String.valueOf(match.players.get(0).handCard.size()));
        cardLeft_Bot_2.setText(String.valueOf(match.players.get(1).handCard.size()));
        cardLeft_Bot_3.setText(String.valueOf(match.players.get(2).handCard.size()));
        cardLeft_Bot_4.setText(String.valueOf(match.players.get(3).handCard.size()));
        cardLeft_User.setText(String.valueOf(match.players.get(4).handCard.size()));

        communityCardLeft_Label.setText(String.valueOf(match.deckCard.getDeckCards().size()));
        communityCard_Label.setText(String.valueOf(match.communityCard.toString()));
        
        try {
           shapeFillImage(imageCommunityCard,"assets/Card/"+match.communityCard.toString()+".png");
       } catch (IOException e) {
           e.printStackTrace();
       }

    }

    public void setHandCardUser(ArrayList<Card> handCardUser) {
//        cardButton_1.setVisible(false);
//        cardButton_2.setVisible(false);
//        cardButton_3.setVisible(false);
//        cardButton_4.setVisible(false);
//        cardButton_5.setVisible(false);
//        cardButton_6.setVisible(false);
        rectangleCard_1.setVisible(false);
        rectangleCard_2.setVisible(false);
        rectangleCard_3.setVisible(false);
        rectangleCard_4.setVisible(false);
        rectangleCard_5.setVisible(false);
        rectangleCard_6.setVisible(false);
        handCardUser_HBox.getChildren().clear();
        if (handCardUser.size() >= 1) {
//            cardButton_1.setText(handCardUser.get(0).toString());
//            cardButton_1.setVisible(true);
            handCardUser_HBox.getChildren().add(rectangleCard_1);
            try {
                shapeFillImage(rectangleCard_1,"assets/Card/"+handCardUser.get(0)+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            rectangleCard_1.setVisible(true);
        }
        if (handCardUser.size() >= 2) {
//            cardButton_2.setText(handCardUser.get(1).toString());
//            cardButton_2.setVisible(true);
            handCardUser_HBox.getChildren().add(rectangleCard_2);
            try {
                shapeFillImage(rectangleCard_2,"assets/Card/"+handCardUser.get(1)+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            rectangleCard_2.setVisible(true);
        }
        if (handCardUser.size() >= 3) {
//            cardButton_3.setText(handCardUser.get(2).toString());
//            cardButton_3.setVisible(true);
            handCardUser_HBox.getChildren().add(rectangleCard_3);
            try {
                shapeFillImage(rectangleCard_3,"assets/Card/"+handCardUser.get(2)+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            rectangleCard_3.setVisible(true);
        }
        if (handCardUser.size() >= 4) {
//            cardButton_4.setText(handCardUser.get(3).toString());
//            cardButton_4.setVisible(true);
            handCardUser_HBox.getChildren().add(rectangleCard_4);
            try {
                shapeFillImage(rectangleCard_4,"assets/Card/"+handCardUser.get(3)+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            rectangleCard_4.setVisible(true);
        }
        if (handCardUser.size() >= 5) {
//            cardButton_5.setText(handCardUser.get(4).toString());
//            cardButton_5.setVisible(true);
            handCardUser_HBox.getChildren().add(rectangleCard_5);
            try {
                shapeFillImage(rectangleCard_5,"assets/Card/"+handCardUser.get(4)+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            rectangleCard_5.setVisible(true);
        }
        if (handCardUser.size() >= 6) {
//            cardButton_6.setText(handCardUser.get(5).toString());
//            cardButton_6.setVisible(true);
            handCardUser_HBox.getChildren().add(rectangleCard_6);
            try {
                shapeFillImage(rectangleCard_6,"assets/Card/"+handCardUser.get(5)+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            rectangleCard_6.setVisible(true);
        }

    }

    public ArrayList<Card> setDroppedCard(int indexChooseCard) {
        System.out.println("index CardButton");
        droppedCard.clear();
        for (Card card : match.players.get(4).handCard) {
            if (card.getRank().equals(match.players.get(4).handCard.get(indexChooseCard).getRank())) {
                System.out.print(card.toString() + " ");
                droppedCard.add(card);
                // handCard.remove(card);
            }
        }
        dropCard_User.setText(droppedCard.toString());
        return droppedCard;
    }

    public boolean checkDropCard() {
        if (droppedCard.isEmpty()) {
            return false;
        }
        for (Card card : droppedCard) {
            if (card.getRank().equals(match.communityCard.getRank()) == false) {
                return false;
            }
        }
        return true;
    }

    void updateGamePlay() {
        System.out.println("Update Game");
        for (Player player : match.players) {
            if (player instanceof Bot) {
                player.displayHandCard();
                System.out.print(player.getName() + " check drop card : \t");
                ArrayList<Card> droppedCard = player.dropCard(match.communityCard);
                if (droppedCard.isEmpty() == true) {
                    droppedCard = player.drawCard(match.deckCard.dropDeckCard());
                }
                match.communityCard = droppedCard.get(droppedCard.size() - 1);
//                sleep(1);
                if (player.getName().equals("firstBot")) {
                    cardLeft_Bot_1.setText(String.valueOf(player.handCard.size()));
                    imageDropCard_Bot_1_1.setVisible(false);
                    imageDropCard_Bot_1_2.setVisible(false);
                    imageDropCard_Bot_1_3.setVisible(false);
                    if (droppedCard.size()>=1){
                        try {
                            shapeFillImage(imageDropCard_Bot_1_1,"assets/Card/"+droppedCard.get(0).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_1_1.setVisible(true);
                    }
                    if (droppedCard.size()>=2){
                        try {
                            shapeFillImage(imageDropCard_Bot_1_2,"assets/Card/"+droppedCard.get(1).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_1_2.setVisible(true);
                    }
                    if (droppedCard.size()>=3){
                        try {
                            shapeFillImage(imageDropCard_Bot_1_3,"assets/Card/"+droppedCard.get(2).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_1_3.setVisible(true);
                    }
                    dropCard_Bot_1.setText(droppedCard.toString());
                }
                if (player.getName().equals("secondBot")) {
                    cardLeft_Bot_2.setText(String.valueOf(player.handCard.size()));
                    imageDropCard_Bot_2_1.setVisible(false);
                    imageDropCard_Bot_2_2.setVisible(false);
                    imageDropCard_Bot_2_3.setVisible(false);
                    if (droppedCard.size()>=1){
                        try {
                            shapeFillImage(imageDropCard_Bot_2_1,"assets/Card/"+droppedCard.get(0).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_2_1.setVisible(true);
                    }
                    if (droppedCard.size()>=2){
                        try {
                            shapeFillImage(imageDropCard_Bot_2_2,"assets/Card/"+droppedCard.get(1).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_2_2.setVisible(true);
                    }
                    if (droppedCard.size()>=3){
                        try {
                            shapeFillImage(imageDropCard_Bot_2_3,"assets/Card/"+droppedCard.get(2).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_2_3.setVisible(true);
                    }
                    dropCard_Bot_2.setText(droppedCard.toString());
                }
                if (player.getName().equals("thirdBot")) {
                    cardLeft_Bot_3.setText(String.valueOf(player.handCard.size()));
                    imageDropCard_Bot_3_1.setVisible(false);
                    imageDropCard_Bot_3_2.setVisible(false);
                    imageDropCard_Bot_3_3.setVisible(false);
                    if (droppedCard.size()>=1){
                        try {
                            shapeFillImage(imageDropCard_Bot_3_1,"assets/Card/"+droppedCard.get(0).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_3_1.setVisible(true);
                    }
                    if (droppedCard.size()>=2){
                        try {
                            shapeFillImage(imageDropCard_Bot_3_2,"assets/Card/"+droppedCard.get(1).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_3_2.setVisible(true);
                    }
                    if (droppedCard.size()>=3){
                        try {
                            shapeFillImage(imageDropCard_Bot_3_3,"assets/Card/"+droppedCard.get(2).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_3_3.setVisible(true);
                    }
                    dropCard_Bot_3.setText(droppedCard.toString());
                }
                if (player.getName().equals("forthBot")) {
                    cardLeft_Bot_4.setText(String.valueOf(player.handCard.size()));
                    imageDropCard_Bot_4_1.setVisible(false);
                    imageDropCard_Bot_4_2.setVisible(false);
                    imageDropCard_Bot_4_3.setVisible(false);
                    if (droppedCard.size()>=1){
                        try {
                            shapeFillImage(imageDropCard_Bot_4_1,"assets/Card/"+droppedCard.get(0).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_4_1.setVisible(true);
                    }
                    if (droppedCard.size()>=2){
                        try {
                            shapeFillImage(imageDropCard_Bot_4_2,"assets/Card/"+droppedCard.get(1).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_4_2.setVisible(true);
                    }
                    if (droppedCard.size()>=3){
                        try {
                            shapeFillImage(imageDropCard_Bot_4_3,"assets/Card/"+droppedCard.get(2).toString()+".png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        imageDropCard_Bot_4_3.setVisible(true);
                    }
                    dropCard_Bot_4.setText(droppedCard.toString());
                }

                setTextInGameplay();
                try {
                    isCardLeft();
                } catch (IOException ex) {
                    Logger.getLogger(Gameplay_5P_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        checkDrawCard = false;

        setHandCardUser(match.players.get(4).handCard);
        match.players.get(4).displayHandCard();
    }


    public void shapeFillImage(Shape shape, String pathImage) throws IOException {
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }

    public void isCardLeft() throws IOException{
       if(match.deckCard.getDeckCards().isEmpty()){
           finishGamePane.setVisible(true); 
       }
    }
    
    @FXML
    private void onMouseExited(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.BLACK);
        object.setStrokeWidth(1);
    }

    @FXML
    private void onMouseEntered(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.YELLOW);
        object.setStrokeWidth(4);
    }

    @FXML
    private void clickedToScoreBoard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scoreboard.fxml"));
        root = loader.load();
        //ScoreboardController scenesMainController = new ScoreboardController();
        ScoreboardController scoreboardcontroller = loader.getController();
        scoreboardcontroller.scoreBoard(match);
//        root = FXMLLoader.load(getClass().getResource("Scenes_Main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
