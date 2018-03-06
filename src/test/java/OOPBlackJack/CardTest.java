package OOPBlackJack;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;


public class CardTest {

    private Card card;
    private Suit suit;
    private Rank rank;
    private int value;

//    public CardTest(Suit suit, Rank rank, int value) {
//        this.suit = suit;
//        this.rank = rank;
//        this.value = value;
//    }

    @org.junit.Before
    public void setUp() {
        System.out.println("Test Running...");
        card = new Card(Suit.HEART,Rank.FIVE,5);
    }

    @org.junit.Test
    public void getValue() throws Exception {
        int cardValue = card.getValue();
        assertEquals(5, cardValue);
    }

    @org.junit.Test
    public void getValueAceOne() throws Exception {
        card = new Card(Suit.HEART,Rank.ACE,1);
        int input = 1;
        card.changeAceValue(input);
        assertEquals(1, card.getFinalCardValue());
    }

    @org.junit.Test
    public void getValueAceTwo() throws Exception {
        card = new Card(Suit.HEART,Rank.ACE,1);
        int input = 2;
        card.changeAceValue(input);
        assertEquals(11, card.getFinalCardValue());
    }

    @Test
    public void setValue() throws Exception {
        card.setValue(6);
        assertEquals(6,card.getValue());
    }

    @Test
    public void getFinalCardValue() throws Exception {
        assertEquals(5,card.getFinalCardValue());
    }

}