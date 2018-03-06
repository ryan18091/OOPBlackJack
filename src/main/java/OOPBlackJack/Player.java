package OOPBlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Scanner sc = new Scanner(System.in);

    private List<Card> hand;
    private int money;
    private int bet;

    public Player(int money, int bet) {
        hand = new ArrayList<Card>();
        this.money = money;
        this.bet = bet;
    }

    public int getHandTotal() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getValue();
        }
        return total;
    }

    public int getHandTotalFinal() {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getFinalCardValue();
        }
        return total;
    }

    public boolean stayOrHit(boolean stayHit) {
        System.out.println("Do you wish to stay or hit?");
        System.out.println("Enter 1 for stay or 2 for hit.");
        int choice = sc.nextInt();

        if (choice == 1 || choice == 2) {
            stayHit = choice != 1;
        } else {
            stayOrHit(stayHit);
        }

        return stayHit;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
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

    public void setHand(List<Card> hand, Card card) {
        this.hand = hand;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}


