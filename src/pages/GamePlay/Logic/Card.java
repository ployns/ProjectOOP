package pages.GamePlay.Logic;

public class Card {
    private String rank;
    private String suit;
    
    Card(String rank,String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    // public void setSuit(String suit) {
    //     this.suit = suit;
    // }

    public String getRank() {
        return rank; 
    }

    // public void setRank(String rank) {
    //     this.rank = rank;
    // }

    public int getValueRank() {
        int value = 0;
        if (rank.equals("A")) {
            value = 1;
        } else if(rank.equals("2")){
            value = 2;
        } else if(rank.equals("3")){
            value = 3;
        } else if(rank.equals("4")){
            value = 4;
        } else if(rank.equals("5")){
            value = 5;
        } else if(rank.equals("6")){
            value = 6;
        } else if(rank.equals("7")){
            value = 7;
        } else if(rank.equals("8")){
            value = 8;
        } else if(rank.equals("9")){
            value = 9;
        } else if(rank.equals("10")){
            value = 10;
        } else if(rank.equals("J")){
            value = 10;
        } else if(rank.equals("Q")){
            value = 10;
        } else if(rank.equals("K")){
            value = 10;
        }
        return value;
    }

    public int getValueSuit(){
        int value = 0;
        if (suit.equals("C")) {
            value = 1;
        } else if(suit.equals("D")){
            value = 2;
        } else if(suit.equals("H")){
            value = 3;
        } else if(suit.equals("S")){
            value = 4;
        }
        return value;
    }

    public String toString() {
        return rank + "_" + suit;
    }

    public int size() {
        return 0;
    }
    
}
