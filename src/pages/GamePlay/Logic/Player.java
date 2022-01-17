package pages.GamePlay.Logic;

import java.util.ArrayList;

public abstract class Player {
    protected String name;
    protected int money;

    boolean playerRequestCheckmate = false;

    public ArrayList<Card> handCard = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    Player(String name, int money) {
        this.setName(name);
        this.setMoney(money);
    }

    Player(String name) {
        this.setName(name);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setPlayerRequestCheckmate(boolean playerRequestCheckmate) {
        this.playerRequestCheckmate = playerRequestCheckmate;
    }

    // public ArrayList<Card> getHandCard() {
    // return handCard;
    // }

    // public void setHandCard(ArrayList<Card> handCard) {
    // this.handCard = handCard;
    // }

    // public void addHandCard(){

    // }

    public abstract ArrayList<Card> dropCard(Card communityCard);

    public abstract ArrayList<Card> drawCard(Card draw);

    public void checkmate(){
        setPlayerRequestCheckmate(true);
    }

    public void displayHandCard() {
        System.out.print("\n" + name + " : \t");
        for (int i = 0; i < handCard.size(); i++) {
            System.out.print(handCard.get(i) + "\t");
        }
        System.out.println();
    }

    public int getScoreCard(){
        int score = 0;
        for (Card card : handCard) {
            score += card.getValueRank();
        }
        return score;
    }

}
