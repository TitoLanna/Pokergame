public class PokerGame {
     /*
    [ACTIONs]
     -Get new hands from hands
     -Tell Player to display the hand(all IO is via  Player)
     -Get the list of discard/hold cards from player.
     -Update the hands, that is tell hand which cards to hold and which to displace.
     -Score the hand,that is,get the score from hand.
     -Tell Player to display the final result.
     -Update Bankroll when the game is finished.
    *
    * */

    private Bankroll bankroll;
    private Bet bet;
    private Hand hand;
    private Player player;
    private boolean[]holdCards;


    public PokerGame(Bet coinBet,Bankroll br,Player pl){
        bankroll=br;
        bet =coinBet;
        player=pl;
        hand=new Hand();
        holdCards=new boolean[5];
    }
    public int updateBankroll(int payout){
        int winnings = payout*(bet.getBet());
        bankroll.alterBankroll(winnings);

        return winnings;
    }
    public void viewInitialHand(){
        hand.newHand();
        player.displayHand(hand.getHand());//tells the player to display the new hand

    }
    public void discardOrHoldCards(){
        player.getDiscard(holdCards);
        hand.updateHand(holdCards);
        player.displayHand(hand.getHand());
        int payout = hand.evaluateHand();
        int winnings = updateBankroll(payout);
        player.displayResults(payout,winnings);
    }
}
