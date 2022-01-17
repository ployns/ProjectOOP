package pages.MainMenu;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainMenu extends Application {
        String musicFile = "C:\\Users\\P\\Documents\\NetBeansProjects\\ProjectOOP\\src\\Sound\\Music.mp3";     
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public static void main(String[] args) {
        launch(args);
    }
    
    

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Hello World");
        mediaPlayer.play();
        mediaPlayer.setVolume(0.3);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
        event.consume();
        logout(primaryStage);
                    });
    }
    
        public void logout(Stage stage){
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!!");
        alert.setContentText("Do you want to save before exiting? : ");
        
        
        if(alert.showAndWait().get() == ButtonType.OK){
        System.out.println("You successfully logged out!");
        stage.close();
        }
    }

}
