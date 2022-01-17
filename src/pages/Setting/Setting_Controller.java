package pages.Setting;

import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import pages.MainMenu.MainMenu_Controller;
import sample.Main;




public class Setting_Controller implements Initializable   {


   MainMenu_Controller Main = new MainMenu_Controller();



    @FXML
    private Rectangle MainMenuButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Slider MusicSlider;
    @FXML
    private Slider SoundSlider;


    @Override  
    public void initialize(URL url, ResourceBundle resourceBundle) {

                

                MusicSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
	    public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                //Main.getMediaplayer();
                //Main.getMediaplayer().setVolume(MusicSlider.getValue() * 0.01);
		//mediaPlayer.setVolume(MusicSlider.getValue() * 0.01);			
		}
	});
        try {
            shapeFillImage(MainMenuButton,"assets/Setting/Menu.png");
 

        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
    
    @FXML
    void clickedToMainMenu(MouseEvent event) throws IOException {
        fxmlLoadStage(event,"../MainMenu/MainMenu.fxml");
    }
    

    public void fxmlLoadStage(MouseEvent event,String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
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
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }
    
    
//        MusicSlider.valueProperty().addListener(new ChangeListener<Number>() {
//
//            @Override
//	    public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
//				
//		mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);			
//		}
//	});
}



