package pages.GamePlay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pages.GamePlay.Logic.Match;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gameplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
        Parent root = loader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("Gameplay.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        


//        Gameplay_Controller gameplay_controller = loader.getController();
//        Match match = new Match("KeeKiatTum",3){
//
//        };

//        match.deckCard.displayDeckCard();

//        match.dealCard();


//        sleep(1);
//
//        match.deckCard.displayDeckCard();

//        gameplay_controller.setTextInGameplay(match);

//        sleep(1);
//        gameplay_controller.setHandCardUser(match.players.get(3).handCard);

//        sleep(1);



    }

    public void sleep(int SECOND){
        try {
            TimeUnit.SECONDS.sleep(SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

//    @Override
//    public void run() {
//        System.out.println("Run boy run");
////        while (terminator == false){
////            if (System.nanoTime() - xTime >= 10000000) {
////
////                xTime = System.nanoTime();
////            }
////        }
//    }
}
