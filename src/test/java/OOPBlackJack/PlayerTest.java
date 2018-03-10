package OOPBlackJack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private Card card1;
    private Card card2;
    private int money;
    private int bet;
    private Suit suit;
    private Rank rank;
    private int value;

    @Before
    public void setUp() {
        player = new Player(money, bet);
        card1 = new Card(Suit.HEART,Rank.FIVE,5);
        card2 = new Card(Suit.HEART, Rank.SIX, 6);
        player.addCard(card1);
        player.addCard(card2);
        System.out.println("Running Test...");
    }

    @Test
    public void getHandTotalNoAces() throws Exception {
//        player.addCard(card1);
//        player.addCard(card2);
        assertEquals(11, player.getHandTotal());
    }

    @Test
    public void getHandTotalFinal() throws Exception {
//        player.addCard(card1);
//        player.addCard(card2);
        assertEquals(11, player.getHandTotalFinal());
    }

    @Test
    public void stayOrHitFlase() throws Exception {
        boolean stayHit = true;
        assertFalse(player.playerChoice(1,stayHit));
    }

    @Test
    public void stayOrHitTrue() throws Exception {
        boolean stayHit = false;
        assertTrue(player.playerChoice(2,stayHit));
    }


    @Test
    public void getBet() throws Exception {
        player.setBet(100);
        assertEquals(100, player.getBet());
    }

    @Test
    public void setBet() throws Exception {
        player.setBet(200);
        assertEquals(200, player.getBet());
    }


    @Test
    public void clearHand() throws Exception {
        player.clearHand();
        assertEquals(0, player.getHand().size());
//        assertArrayEquals(player.getHand(),player.getHand());

    }

    @Test
    public void getHand() throws Exception {
        fail("Need to create test.");
    }

    @Test
    public void addCard() throws Exception {
        fail("Need to create test.");
    }

    @Test
    public void setHand() throws Exception {
    }

    @Test
    public void getMoney() throws Exception {
    }

    @Test
    public void setMoney() throws Exception {
    }

}