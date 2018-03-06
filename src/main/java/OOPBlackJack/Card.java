package OOPBlackJack;

import java.util.Scanner;

class Card {

    Scanner sc = new Scanner(System.in);

    private Suit suit;
    private Rank rank;
    private int value;

    Card(Suit suit, Rank rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;

    }


    //Returns value of card while game is in play
    //sets the value of Ace if present
    public int getValue() {
        if (this.value == 1) {
            System.out.println("You have an Ace. Do you wish it to be a 1(enter 1) or 11(enter 2)");
            int choice = sc.nextInt();
            if (choice == 1) {
                this.setValue(1);
            } else if (choice == 2) {
                this.setValue(11);
            } else {
                System.out.println("Choice must be a 1 or a 2.");
                this.getValue();
            }
        } else {
        }

        return this.value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    //returns the card value after all cards have been played
    public int getFinalCardValue() {
        return this.value;
    }


    public String toString() {
        return rank + " of " + suit + " with a value of " + value;
    }


}
