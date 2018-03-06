package OOPBlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {

    private Scanner sc = new Scanner(System.in);

    private List<Player> players;
    private Dealer dealer;
    private CardDeck deck;

    public Game(int playerAmount, int money) { //Constructor
        players = new ArrayList<Player>();

        for (int i = 0; i < playerAmount; i++) {
            //instantiates the player(s)
            int bet = 0;
            Player player = new Player(money, bet);
            this.players.add(player);
        }
        //instantiates the dealer
        this.dealer = new Dealer(money);

        //Instantiates the deck and shuffles (Should this be done in a setter?)
        this.deck = new CardDeck();
        this.deck.shuffle();
    }

    public void deal() {
        //Adds cards to player(s) hands
        for (int d = 0; d < players.size(); d++) {
            //Checks to see if player has money, if so, they can bet and be dealt cards
            if (players.get(d).getMoney() > 0) {
                this.setBet(d);
                for (int c = 0; c < 2; c++) {
                    //if Deck is empty/ Create new deck and shuffle
                    if (deck.deck.size() > 0) {
                        players.get(d).addCard(deck.getNextCard());
                    } else {
                        this.deck = new CardDeck();
                        this.deck.shuffle();
                        players.get(d).addCard(deck.getNextCard());
                    }
                }
            } else {
            }
        }
        //Adds cards to dealers hand
        for (int c = 0; c < 2; c++) {
            dealer.addCard(deck.getNextCard());
        }
    }

    //sets bet for each player as the deal is taking place
    public void setBet(int d) {
        if (players.get(d).getMoney() > 0) {
            System.out.println("Player " + (d + 1) + " how much do you wish to bet?");
            System.out.println("You have $" + players.get(d).getMoney());
            int playerBet = sc.nextInt();
            if (playerBet > playerBet) {
                System.out.println("You only have " + players.get(d).getMoney());
                setBet(d);
            } else {
                this.players.get(d).setBet(playerBet);
            }
        } else {
        }
    }

    public void gamePlay() {

        int playersMoneyTotal = playerMoneyTotal();

        System.out.println("total money" + playersMoneyTotal);

        while (playersMoneyTotal != 0) {
            this.deal();
            for (int t = 0; t < players.size(); t++) {
                boolean stayHit = true;
                if (players.get(t).getMoney() > 0) {
                    //Game engine, evals. to false when players choose stay
                    while (stayHit) {
                        if (players.get(t).getHandTotalFinal() <= 21) {
                            System.out.println("Dealer shows a " + dealer.showCard());
                            System.out.println("Player " + (t + 1) + " you have" + players.get(t).getHand());
                            System.out.println("Your total is " + players.get(t).getHandTotal());
                            stayHit = players.get(t).stayOrHit(stayHit);
                            if (stayHit) {
                                players.get(t).addCard(deck.getNextCard());
                            } else {
                            }
                        } else {
                            System.out.println("You Bust with " + players.get(t).getHand());
                            break;
                        }
                    }
                } else {
                    System.out.println("Player " + (t + 1) + " you are out of money");
                }

            }
            //dealers turn checks for dealers logic on whether to hit or stay
            boolean dealersTurn = true;
            while (dealersTurn) {
                dealersTurn = dealer.dealersPlay();
                if (dealersTurn) {
                    dealer.addCard(deck.getNextCard());
                } else {
                    break;
                }

            }
            this.handOutcome();
            this.handReset();
            //Checks if there is any more money in players hands
            playersMoneyTotal = playerMoneyTotal();
            if (playersMoneyTotal == 0) {
                System.out.println("Game Over");
            }


        }

    }


    public void handOutcome() {
        //compares dealers hand total to players hand totals
        System.out.println("Dealer has " + dealer.getHandTotal());
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getMoney() > 0) {

                if (players.get(i).getMoney() > 0) {
                    if (dealer.getHandTotal() <= 21) {

                        if (players.get(i).getHandTotalFinal() <= 21 && players.get(i).getHandTotalFinal() > dealer.getHandTotal()) {
                            betWin(i);
                            System.out.println("Player " + (i + 1) + " wins with a " + players.get(i).getHandTotalFinal());
                            System.out.println("You now have $" + players.get(i).getMoney());

                        } else {
                            betLoose(i);
                            System.out.println("Player " + (i + 1) + " loses with a  " + players.get(i).getHandTotalFinal());
                            System.out.println("You now have $" + players.get(i).getMoney());

                        }
                    } else {
                        if (players.get(i).getHandTotalFinal() <= 21) {
                            betWin(i);
                            System.out.println("Player " + (i + 1) + " wins with a " + players.get(i).getHandTotalFinal());
                            System.out.println("You now have $" + players.get(i).getMoney());
                        } else {
                            betLoose(i);
                            System.out.println("Player " + (i + 1) + " loses with a" + players.get(i).getHandTotalFinal());
                            System.out.println("You now have $" + players.get(i).getMoney());


                        }
                    }
                }
            } else {
            }
        }


    }

    public void betWin(int i) {
        int moneyTotal = players.get(i).getMoney() + players.get(i).getBet();
        players.get(i).setMoney(moneyTotal);
    }

    public void betLoose(int i) {
        int moneyTotal = players.get(i).getMoney() - players.get(i).getBet();
        players.get(i).setMoney(moneyTotal);
    }

    public int playerMoneyTotal() {
        int playersMoneyTotal = 0;
        for (int i = 0; i < players.size(); i++) {
            playersMoneyTotal += players.get(i).getMoney();
        }
        return playersMoneyTotal;
    }

    public void handReset() {
        //clears players hand
        for (int t = 0; t < players.size(); t++) {
            players.get(t).clearHand();
        }
        //clears dealers hand
        dealer.clearHand();

    }
}



