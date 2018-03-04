package OOPBlackJack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Gets starting parameters for the game from console.
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players for today's game?");
        int players = sc.nextInt();
        System.out.println("Ok, there will be " + players + " player(s) today.");

        System.out.println("How much money should each player start with?");
        int money = sc.nextInt();
        System.out.println("Ok, each player will start with $ " + money);


        //Instantiates the game while passing the #of players and starting dollar amount(money)
        Game newGame = new Game(players, money);

        //starts game play
        newGame.gamePlay();


    }
}
