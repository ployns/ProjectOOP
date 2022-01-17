package pages.GamePlay.Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package cardlogic;

import pages.GamePlay.Gameplay_Controller;

import java.io.IOException;

/**
 *
 * @author naveeharntehmarn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        // Match match = new Match(2){};

        // match.players.add(new User("I na hee"));
        final Gameplay_Controller gameplay_controller = new Gameplay_Controller();
        Match match = new Match("KeeKiatTum",2){
            
        };

        match.deckCard.displayDeckCard();

        match.dealCard();

        match.deckCard.displayDeckCard();

        for (Player player : match.players) {
            player.displayHandCard();
        }

        match.loop();

        match.result();
        
    }
    
}
