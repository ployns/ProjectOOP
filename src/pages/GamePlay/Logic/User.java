package pages.GamePlay.Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends Player{
    Scanner scanner = new Scanner(System.in);

    User(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    User(String name, int money) {
        super(name, money);
        //TODO Auto-generated constructor stub
    }

    @Override
    public ArrayList<Card> dropCard(Card communityCard) {
        ArrayList<Card> chooseCard = new ArrayList<>();
        System.out.print("\n" + name + " drop card : \t"); 
        for (Card card : handCard) {
            if (card.getRank().equals(communityCard.getRank())) {
                System.out.print(card.toString() + " ");
                chooseCard.add(card);
                // handCard.remove(card);
            }
        }
//        handCard.removeAll(chooseCard);
        return chooseCard;

    }

    @Override
    public ArrayList<Card> drawCard(Card draw) {
        ArrayList<Card> chooseCard = new ArrayList<>();
        handCard.add(draw);
        displayHandCard();
        int pickIndexCard = -1;
        // int maxRank = handCard.get(0).getValueRank();
        
        // for (Card card : handCard) {
        //     if (maxRank < card.getValueRank()) {
        //         maxRank = card.getValueRank();
        //         maxCard = card;
        //     }
        // }
        System.out.print("choose index to a drop card ["+ handCard.size() +"] : ");
        pickIndexCard = scanner.nextInt();

        while (pickIndexCard < 1 || pickIndexCard > handCard.size()) {
            System.out.print("choose index to a drop card ["+ handCard.size() +"] : ");
            pickIndexCard = scanner.nextInt();
        }

        Card pickCard = handCard.get(pickIndexCard-1);
                    
            // communityCard = droppedCard.get(droppedCard.size()-1);
        System.out.print("\n" + name + " drop card : \t"); 
        for (Card card : handCard) {
            if (card.getRank().equals(pickCard.getRank())) {
                System.out.print(card.toString() + " ");
                chooseCard.add(card);
            }
        }
        handCard.removeAll(chooseCard);
        return chooseCard;
    }

    // @Override
    // void checkmate() {
    //     // TODO Auto-generated method stub
        
    // }
    
}
