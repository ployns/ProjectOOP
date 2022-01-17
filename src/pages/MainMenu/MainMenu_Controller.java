package pages.MainMenu;


import java.io.File;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import pages.Start.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainMenu_Controller implements Initializable {
    @FXML
    private AnchorPane sceneMainMenu;

    @FXML
    private Rectangle StartButton;

    @FXML
    private Rectangle SettingButton;

    @FXML
    private Rectangle ExitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    


           
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    
    SettingButton.setVisible(false);
        try {
            shapeFillImage(StartButton,"assets/MainMenu/Start.png");
            shapeFillImage(SettingButton,"assets/MainMenu/Setting.png");
            shapeFillImage(ExitButton,"assets/MainMenu/Exit.png");

        } catch (IOException e) {
            e.printStackTrace();
                     
        }
    }

    @FXML
    private void clickedToStart(MouseEvent event) throws IOException {
        
        fxmlLoadStage(event,"../Start/Start.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Start/Start.fxml"));
//        System.out.println("start");
//        root = fxmlLoader.load();
//        System.out.println("root");
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(new Scene(root));
//        stage.show();

    }

    @FXML
    private void clickedToSetting(MouseEvent event) throws IOException {
        fxmlLoadStage(event,"../Setting/Setting.fxml");
        
        
    }
    @FXML
    private void clickedToExit(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You are about to exit");
        alert.setContentText("Do you want to exit?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) sceneMainMenu.getScene().getWindow();
            System.out.println("successfully exit");
            stage.close();
        }
    }

    @FXML
    void onMouseEntered(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.YELLOW);
        object.setStrokeWidth(4);
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.BLACK);
        object.setStrokeWidth(1);
    }

    public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }

    public void fxmlLoadStage(MouseEvent event,String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        
    }
//    public MediaPlayer getMediaplayer(){
//        return mediaPlayer;
//    }
//        public void setMediaPlayer(MediaPlayer mediaPlayer) {
//        this.mediaPlayer = mediaPlayer;
//    }

}
