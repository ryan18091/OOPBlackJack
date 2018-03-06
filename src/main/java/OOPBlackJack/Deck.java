package OOPBlackJack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Suit {SPADE, DIAMOND, CLUB, HEART}

enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}


class CardDeck {  // A deck of card


    List<Card> deck;


    public CardDeck() {   // constructor
        deck = new ArrayList<Card>();

        //Assignes Suit, Rank, and Values to all cards in the deck
        for (Suit suit : Suit.values()) {
            int i = 1;
            for (Rank rank : Rank.values()) {
                if (i <= 10) {
                    deck.add(new Card(suit, rank, i++));
                } else {
                    i = 10;
                    deck.add(new Card(suit, rank, i));
                }

            }
        }
    }

    public Card getNextCard() {
        return deck.remove(0);
    }


    public void shuffle() {
        Collections.shuffle(deck);  // use java.util.Collections' static method to shuffle the List
    }
}







