package OOPBlackJack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private Card cards;
    private List<Card> hand;
    private int money;

    public Dealer(int money) {
        hand = new ArrayList<>();
        this.money = money;
    }

    public boolean dealersPlay() {
        System.out.println("The dealer shows " + this.getHand() + "for a total of " + this.getHandTotal());
        return this.getHandTotal() <= 16;
    }


    public int getHandTotal() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getFinalCardValue();
        }
        return total;
    }

    public Object showCard() {
        return hand.get(1);
    }

    public void clearHand() {
        this.hand = new ArrayList<Card>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }


}

