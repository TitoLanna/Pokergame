public class Bankroll {
    /*
    TODO:[ACTIONs]
     -Update the current number of coins in the machine,that is increase or decrease the number of coins
     - Return the number of coin in the machine
     - Change the number of coins in the machine
    *
    * */
    private int bankroll;

    public Bankroll(){
        bankroll=0;
    }
    public Bankroll(int bankroll){
        this.bankroll=bankroll;
    }
    public void setBankroll(int bankroll) {
        this.bankroll = bankroll;
    }

    public int getBankroll() {
        return bankroll;
    }
    public void alterBankroll(int n){
        bankroll+=n;
    }
}
