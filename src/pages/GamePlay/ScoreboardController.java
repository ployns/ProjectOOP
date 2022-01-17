/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages.GamePlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import pages.GamePlay.Logic.Match;

/**
 * FXML Controller class
 *
 * @author P
 */
public class ScoreboardController implements Initializable {

    @FXML
    private StackPane StackPaneMode;
    @FXML
    private AnchorPane AnchorPaneMode;
    @FXML
    private Rectangle MainMenuButton;
    @FXML
    private Rectangle textContainer;
    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label player3;
    @FXML
    private Label player4;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;
    @FXML
    private Label score4;
    Match match;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label player5;
    @FXML
    private Label score5;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            shapeFillImage(MainMenuButton,"assets/MainMenu/Backtomenu.png");
            shapeFillImage(textContainer,"assets/Start/Score.png");

        } catch (IOException e) {
            e.printStackTrace();
                     
        }

    }    

    
    public void getMatch(Match m){
        match = m; 
    }
    
    public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(pathImage))));
        shape.setFill(new ImagePattern(new Image(pathImage)));
    }
        @FXML
    private void clickedToBackToMenu(MouseEvent event) throws IOException {
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
    
    
    
    public void scoreBoard (Match match){
        
        player1.setText("");
        player2.setText("");
        player3.setText("");
        player4.setText("");
        player5.setText("");
        score1.setText("");
        score2.setText("");
        score3.setText("");
        score4.setText("");
        score5.setText("");
        
        if(match.players.size() == 3){
            player1.setText(match.players.get(0).getName());
            player2.setText(match.players.get(1).getName());
            player3.setText(match.players.get(2).getName());
            score1.setText(String.valueOf(match.players.get(0).getScoreCard()));
            score2.setText(String.valueOf(match.players.get(1).getScoreCard()));
            score3.setText(String.valueOf(match.players.get(2).getScoreCard()));
        }
        
        if(match.players.size() == 4){
            player1.setText(match.players.get(0).getName());
            player2.setText(match.players.get(1).getName());
            player3.setText(match.players.get(2).getName());
            player4.setText(match.players.get(3).getName());
            score1.setText(String.valueOf(match.players.get(0).getScoreCard()));
            score2.setText(String.valueOf(match.players.get(1).getScoreCard()));
            score3.setText(String.valueOf(match.players.get(2).getScoreCard()));
            score4.setText(String.valueOf(match.players.get(3).getScoreCard()));

        }
        
        if(match.players.size() == 5){        
        player1.setText(match.players.get(0).getName());
        player2.setText(match.players.get(1).getName());
        player3.setText(match.players.get(2).getName());
        player4.setText(match.players.get(3).getName());
        player5.setText(match.players.get(4).getName());        
        score1.setText(String.valueOf(match.players.get(0).getScoreCard()));
        score2.setText(String.valueOf(match.players.get(1).getScoreCard()));
        score3.setText(String.valueOf(match.players.get(2).getScoreCard()));
        score4.setText(String.valueOf(match.players.get(3).getScoreCard()));
        score5.setText(String.valueOf(match.players.get(4).getScoreCard()));
        }
        
    }

        
    
    
}
