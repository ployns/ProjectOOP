package pages.Start;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Mode_1_Setting_Controller implements Initializable {

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane PaneMode_1_Setting;

    @FXML
    private Rectangle BackButton;
    
    @FXML
    private Rectangle StartGamePlayButton;
    
  
    @FXML
    public RadioButton rb3Player;
    @FXML
    public RadioButton rb4Player;
    @FXML
    public RadioButton rb5Player;
    @FXML
    public ToggleGroup tgPlayer;
    @FXML
    public Label lb1;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          // set Image Button
        try {
           shapeFillImage(BackButton,"assets/Start/Back.png");
           shapeFillImage(StartGamePlayButton,"assets/Start/Startgame.png");
           
        } catch (IOException e) {
            e.printStackTrace();
        } 

    }
     public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }


   @FXML
    void clickedToBack(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1_Setting.getScene();

        root.translateYProperty().set(-scene.getWidth());

        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1_Setting);
            }
        });
        timeline.play();
    }

    @FXML
    void clickedToGamePlay(MouseEvent event) throws IOException  {
        if (rb3Player.isSelected()){
            fxmlLoadStage(event,"../GamePlay/Gameplay_3P.fxml");
        }
        if (rb4Player.isSelected()){
            fxmlLoadStage(event,"../GamePlay/Gameplay.fxml");
        }
        if (rb5Player.isSelected()){
            fxmlLoadStage(event,"../GamePlay/Gameplay_5P.fxml");
        }
                
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_2.fxml")); /***/
//        Parent root = fxmlLoader.load();
//        Scene scene = PaneMode_1_Setting.getScene();
//
//        root.translateYProperty().set(-scene.getWidth());
//
//        stackPane.getChildren().add(root);
//
//        Timeline timeline = new Timeline();
//        KeyValue keyValue = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
//        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
//        timeline.getKeyFrames().add(keyFrame);
//
//        timeline.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                stackPane.getChildren().remove(PaneMode_1_Setting);
//            }
//        });
//        timeline.play();
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
    
  

     public void radioSelect(ActionEvent actionEvent) {
        
          String message = " ";
          if (rb3Player.isSelected()){
            message += rb3Player.getText() + " \n " ;
            
          }
          if (rb4Player.isSelected()){
            message += rb4Player.getText() + " \n " ;
          }
          if (rb5Player.isSelected()){
            message += rb5Player.getText() + " \n " ;
          }
         // lb1.setText(message);
       }
         public void fxmlLoadStage(MouseEvent event,String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        
    }
       
       
  }



