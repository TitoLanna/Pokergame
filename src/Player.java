import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Scanner;

public class Player {


    /*
        What can the poker player do?
        [ACTIONS]
        -Deposit coin(ADD to bankroll)
        -Play game
        -Make a bet
        -Decide which cards to hold/discard
        -Cash out
        -Quit
        -Play another game
    * */


    private Scanner input;
    Bankroll bankroll;
    PokerGame pokerGame;
    Bet bet;
    Hand hand;

    Player(){
      input =new Scanner(System.in);
      bankroll=new Bankroll();
      bet=new Bet();
    }

    void getInitialBankroll(){
        int numCoins;

        do {
            System.out.println("How many coins do you wish to insert into the machine.");
            numCoins=input.nextInt();
        }while (numCoins<=0);
        System.out.println();
        bankroll.setBankroll(numCoins);

    }

    void addCoin(){
        int numCoins;
        do {
            System.out.println("How many coins do you wish to insert into the machine: ");
            numCoins =input.nextInt();
        }while (numCoins<=0);
        bankroll.alterBankroll(numCoins);
        System.out.println("Currently you have"+ bankroll.getBankroll()+"coins");
        System.out.println();

    }

    public void betAndPlay(){
        int coins;
        do{
            System.out.println("Enter a bet : 1 to 5 coins");
            coins=input.nextInt();
        }while (coins<=0||coins>5||coins> bankroll.getBankroll());

        bet.setBet(coins);
        pokerGame= new PokerGame(bet,bankroll,this);
        pokerGame.viewInitialHand();
        pokerGame.discardOrHoldCards();

    }

    public void displayHand(String[] handString){
        System.out.println("******* Your Hand 1 *******");
        for (int i = 0;i <5;i++)
            System.out.println((i+1)+".   "+handString[i]);
        System.out.println("****************************");
        System.out.println();

    }

    public void getDiscard(boolean[]x){
        String ans;
        System.out.println("Hold or discard ?");
        for (int i=0;i<5;i++) {
            do {
                System.out.println("Hold(h) or Discard(d) card number"+(i+1)+".");
                ans=input.next();
                if (ans.equals("h"))
                    x[i]=true;
                else if (ans.equals("d"))
                    x[i] = false;
            }while (!(ans.equals("h")||ans.equals("d")));
        }
        System.out.println();
    }

    public void displayResults(int payout,int winnings){
        String nameOfHand ="Lose";
        if(payout==250)
            nameOfHand="Royal Flush";
        else if (payout==50)
            nameOfHand="Straight Flush";
        else if (payout==25)
            nameOfHand="Four of a Kind";
        else if (payout==9)
            nameOfHand="Full House";
        else if (payout==6)
            nameOfHand="Flush";
        else if (payout==4)
            nameOfHand="Straight";
        else if (payout==3)
            nameOfHand="Three of a Kind";
        else if (payout==2)
            nameOfHand="Two Pair";
        else if (payout==1)
            nameOfHand="Pair of Jacks or Better";
        if (winnings>0){
            System.out.println("Winner: "+nameOfHand);
            System.out.println("Payout is"+winnings+"coins");
            System.out.println("Current Bankroll is"+bankroll.getBankroll());
        }else {
            System.out.println("You lost your bet of"+bet.getBet());
            System.out.println("Current Bankroll is"+bankroll.getBankroll());
            System.out.println();
        }


    }
    public void quit(){
        int br =bankroll.getBankroll();
        System.out.println("\n*****Game Over*********\n");
        if (br>0)
            System.out.println("Returned:"+br+"coin(s)");
        else
            System.out.println("No coins remain");
        System.out.println("\n***********************\n");

    }

    public void menu(){
        String choice;

        do {
            System.out.println("Choose");
            System.out.println("1. Make a bet and play poker.");
            System.out.println("2.Add coins to the machine.");
            System.out.println("3. Cash out and quit.");
            System.out.println("Your choice.");
            choice=input.next();
            if (choice.equals("1"))
                betAndPlay();
            else if (choice.equals("2"))
                addCoin();

        }while ((!(choice.equals("3"))&& bankroll.getBankroll()>0));

    }

    public static void main(String[]args){
        Player player =new Player();
        player.getInitialBankroll();
        player.menu();
        player.quit();
    }
}
