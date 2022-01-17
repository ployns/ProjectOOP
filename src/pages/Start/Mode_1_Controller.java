package pages.Start;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Mode_1_Controller implements Initializable{

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane PaneMode_1;

    @FXML
    private Rectangle HowToPlayButton;

    @FXML
    private Rectangle ConfirmButton;


   public void initialize(URL url, ResourceBundle resourceBundle) {
        // set Image Button
        try {
           shapeFillImage(HowToPlayButton,"assets/Start/Howtoplay.png");
           shapeFillImage(ConfirmButton,"assets/Start/Confirm.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }

    @FXML
    void clickedToHowToPlay(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1_HowToPlay.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1.getScene();

        root.translateYProperty().set(-scene.getWidth());

        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1);
            }
        });
        timeline.play();
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


    @FXML
    void clickedToConfirm(MouseEvent event) throws IOException {
        PaneMode_1.setClip(new Rectangle(PaneMode_1.getWidth(),PaneMode_1.getHeight()));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1_Setting.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1.getScene();

        root.translateYProperty().set(scene.getWidth());
        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1);
            }
        });
        timeline.play();
    }


}