
public class Hand {


   private Card[] cards;
   private Deck deck;
   private  int suits[];
   private  int value[];


    //A default constructor to instantiate the instance variables.
    public Hand(){
        cards =new Card[5];
        suits =new int[5];//  index 1 to 4 excluding [0]. representing:[Hearts,Diamond,Clubs,Spades]
        value =new int[14];// index 1 to 13 excluding [0].
        deck = new Deck();
    }
    //This method creates and deals a five-card hand.
    public void newHand(){
        deck.shuffle();
        for(int i=0;i< 5;i++){
            cards[i]=deck.deal();//request one card from the deck
            suits[cards[i].getSuit()]++;
            value[cards[i].getValue()]++;
        }
    sort();
    }

     //To return the cards in hand I will be using a getter method to display these cards.
    public String[] getHand(){
        String[]cardsInHand =new String[5];
        for (int i =0; i<5;i++)
           cardsInHand[i]=cards[i].getName();
        return cardsInHand;
    }

    public void updateHand(boolean[]x){

        for (int i=0;i<5;i++)
            if (!x[i]){
                //remove card data for card i
                suits[cards[i].getSuit()]--;
                value[cards[i].getValue()]--;
                //get new card
                cards[i]=deck.deal();

                //update data for card
                suits[cards[i].getSuit()]++;
                value[cards[i].getValue()]++;
            }
        sort();
    }

    // To order the cards by value field this helper function is created
    private void sort(){
        int max; //hold the position of the highest value card.

        for(int place= 4; place>0; place--){
            max=0;
            /*
            * find the position of the highest valued card between 0 and 4"place" and place it in max. */
            for (int i =1;i<= place; i++){
                if (cards[i].getValue()> cards[max].getValue()){
                    max=i;
                    //swapping the highest valued card location.
                    Card temp =cards[place];
                    cards[place]=cards[max];
                    cards[max]=temp;
                }
            }
        }
    }

    public  int evaluateHand(){
        if (royalFlush())
            return 250;
        else if (straightFlush())
            return 50;
        else if (fourOfKind())
            return 25;
        else if(fullHouse())
            return 9;
        else if (flush())
            return 6;
        else if(straight())
            return 4;
        else if (threeOfKind())
            return 3;
        else if (twoPair())
            return 2;
        else if(pair())
            return 1;
        return -1;
    }
    // stubs
    private boolean royalFlush(){
        //10 J Q K A of the same suit
        boolean sameSuit= false;
        boolean isRoyalty= false;
        for (int i =1;i<=4;i++)
            if(suits[i]==5)//all five card a one suit
                sameSuit=true;
        isRoyalty=(
                     value[1] ==1&& // one Ace
                     value[10]==1&& // one Ten
                     value[11]==1&& // one Jack
                     value[12]==1&& // one Queen
                     value[13]==1   // one King
                    );

        return (sameSuit && isRoyalty);
    }

    private boolean straightFlush(){
        boolean sameSuit =false;
        boolean ranksInOrder =false;
        for (int i = 1;i<=4;i++)
            if (suits[i] == 5) {
                sameSuit = true;
            }

        /* cards in sequence? Ace is assumed to be low here since Royal flush was checked first */
        ranksInOrder=(cards[1].getValue() ==(cards[0].getValue()+1)&&
                cards[2].getValue() ==(cards[0].getValue()+2)&&
                cards[3].getValue() ==(cards[0].getValue()+3)&&
                cards[4].getValue() ==(cards[0].getValue()+4));

        return (sameSuit&&ranksInOrder);
    }
    private boolean fourOfKind(){
        for(int i =1;i<=13;i++)
            if (value[i]==4)
                return true;
        return false;
    }

    private boolean fullHouse(){
        boolean three =false;
        boolean two = false;

        for (int i =1;i<=13;i++)
            if(value[i]==3)
                three= true;
            else if (value[i]==2)
                two= true;
        return two && three;
    }
    private boolean flush(){
        for (int i= 1;i<=4;i++)
            if (suits[i]==5)
                return true;
        return false;
    }

    private boolean straight(){
        //card in sequence
       return
               //Ace precedes 2
               (       cards[1].getValue() ==(cards[0].getValue()+1)&&
                       cards[2].getValue() ==(cards[0].getValue()+2)&&
                       cards[3].getValue() ==(cards[0].getValue()+3)&&
                       cards[4].getValue() ==(cards[0].getValue()+4))||
                       //Ace follows King
                       (value[1]==1&&
                               value[10]==1&&//Ace
                               value[11]==1&&//Jack
                               value[12]==1&&//Queen
                               value[13]==1);//King
    }
    private boolean threeOfKind(){
        for (int i=1;i<=13;i++)
            if (value[i]==3)
                return true;
        return false;
    }
    private boolean twoPair(){
        int count =0;
        for (int i =1;i<=13;i++)
            if (value[i]==2)    //count the number of pairs
                count++;

        return (count==2);
    }
    private boolean pair(){ //Jack or Higher
        if (value[1]==2)    //pair of Aces
            return true;
        for (int i =11;i<=13;i++)   //pair of Jacks or higher
            if (value[i]==2)
                return true;
        return false;
    }
}
