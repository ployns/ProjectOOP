package pages.GamePlay.Logic;

import java.util.ArrayList;
import java.util.Random;

public class DeckCard {

    private ArrayList<Card> listDeckCards = new ArrayList<>();
    private Random random = new Random();
    
    DeckCard(){
        listDeckCards.add(new Card("A", "C"));
        listDeckCards.add(new Card("A", "D"));
        listDeckCards.add(new Card("A", "H"));
        listDeckCards.add(new Card("A", "S"));

        for (int i = 2; i <= 10; i++) {
            listDeckCards.add(new Card(Integer.toString(i), "C"));
            listDeckCards.add(new Card(Integer.toString(i), "D"));
            listDeckCards.add(new Card(Integer.toString(i), "H"));
            listDeckCards.add(new Card(Integer.toString(i), "S"));
        }
        
        listDeckCards.add(new Card("J", "C"));
        listDeckCards.add(new Card("J", "D"));
        listDeckCards.add(new Card("J", "H"));
        listDeckCards.add(new Card("J", "S"));

        listDeckCards.add(new Card("Q", "C"));
        listDeckCards.add(new Card("Q", "D"));
        listDeckCards.add(new Card("Q", "H"));
        listDeckCards.add(new Card("Q", "S"));

        listDeckCards.add(new Card("K", "C"));
        listDeckCards.add(new Card("K", "D"));
        listDeckCards.add(new Card("K", "H"));
        listDeckCards.add(new Card("K", "S"));
    }

    ArrayList<Card> shuffleDeckCards(){
        
        ArrayList<Card> randomDeckCards = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            Card randomCard = listDeckCards.get(random.nextInt(listDeckCards.size()));
            listDeckCards.remove(randomCard);
            randomDeckCards.add(randomCard) ;
        }
        listDeckCards = randomDeckCards;
        return listDeckCards;
    }

    public ArrayList<Card> getDeckCards(){
        return listDeckCards;
    }

    public Card dropDeckCard(){
        Card draw = listDeckCards.get(0);
        listDeckCards.remove(0);
        return draw;
    }

    public void displayDeckCard() {
        for (int i = 0; i < listDeckCards.size(); i++) {
            if ((i) % 13 == 0) {
                System.out.println();
            }
            System.out.print(listDeckCards.get(i)+"\t"); 
        }
        System.out.println();
    }

    

    
}
