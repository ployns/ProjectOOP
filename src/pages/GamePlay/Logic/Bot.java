package pages.GamePlay.Logic;

import java.util.ArrayList;

public class Bot extends Player {


    Bot(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    Bot(String name, int money) {
        super(name,money);
        //TODO Auto-generated constructor stub
    }

    ArrayList<Card> getHandCard(){
        return handCard;
    }

    @Override
    public ArrayList<Card> dropCard(Card communityCard) {
        ArrayList<Card> chooseCard = new ArrayList<>();
        // TODO Auto-generated method stub      //with protected
        // System.out.print(getName() + "drop card : ");   //without protected
        
        for (Card card : handCard) {
            if (card.getRank().equals(communityCard.getRank())) {
                System.out.print(card.toString() + " ");
                chooseCard.add(card);
                // handCard.remove(card);
            }
        }
        handCard.removeAll(chooseCard);
        return chooseCard;
    }

    @Override
    public ArrayList<Card> drawCard(Card draw) {
        // TODO Auto-generated method stub
        ArrayList<Card> chooseCard = new ArrayList<>();
        handCard.add(draw);
        displayHandCard();
        System.out.print(""+name+" drop card : \t");
        int maxRank = handCard.get(0).getValueRank();
        Card maxCard = handCard.get(0);
        for (Card card : handCard) {
            if (maxRank < card.getValueRank()) {
                maxRank = card.getValueRank();
                maxCard = card;
            }
        }
        // System.out.println("#1");
        for (Card card : handCard) {
            // System.out.println("#2");
            if (card.getRank().equals(maxCard.getRank())) {
                System.out.print(card.toString() + " ");
                chooseCard.add(card);
                // handCard.remove(card);
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
