package pages.Start;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;


public class Start_Controller implements Initializable {
    @FXML
    private Rectangle MainMenuButton;

    @FXML
    private Rectangle EasyButton;

    @FXML
    private Rectangle ClassicButton;
  
    @FXML
    private Label statusMode;

    @FXML
    private Rectangle textContainer;

    @FXML
    private AnchorPane AnchorPaneMode;

    @FXML
    private StackPane StackPaneMode;

    private Stage stage;
    private Scene scene;
    private Parent root;

    int mode = 1;

    @FXML
    void chooseEasyMode(MouseEvent event) {
//        statusMode.setText("Easy");
//        StackPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,new CornerRadii(50),null)));
//        AnchorPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,new CornerRadii(50),null)));
        mode = 1;
        initialize(null,null);
    }

    @FXML
    void chooseClassicMode(MouseEvent event) {
//        statusMode.setText("Classic");
//        StackPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,new CornerRadii(50),null)));
//        AnchorPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,new CornerRadii(50),null)));
        mode = 2;
        initialize(null,null);
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

    public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // set Image Button
        try {
            shapeFillImage(EasyButton,"assets/Start/Easy.png");
            shapeFillImage(ClassicButton,"assets/Start/Classic.png");
            shapeFillImage(MainMenuButton,"assets/Start/Menu.png");
            shapeFillImage(textContainer ,"assets/Start/Pleasegamemode.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // switch Mode_1.FXML,Mode_2.FXML
        String pathFXML = "";
        try {
            if (mode == 1){
                pathFXML = "Mode_1.fxml";
            }
            if (mode == 2){
                pathFXML = "Mode_2.fxml";
            }
            Parent paneMode = FXMLLoader.load(getClass().getResource(pathFXML));
            StackPaneMode.getChildren().add(paneMode);
            System.out.println(StackPaneMode.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StackPaneMode.getChildren().remove(0);

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

}
