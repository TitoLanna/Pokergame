import java.util.Random;

public class Deck {
    /*
    TODO:[ACTIONs]
     -Shuffle the cards
     -Deal a card , that is return one card
    *
    * */

    private Card deck[];
    private int next;// The position of the card to be dealtt
    public Deck(){
        //DONE: Instantiated and populated a deck.
        deck=new Card[53];//because arrays start from 0. Not using 0.

        for(int rank =1 ; rank<=13;rank++){
            deck[rank]   =new Card(1,rank);
            deck[rank+13]=new Card(2,rank);
            deck[rank+26]=new Card(3,rank);
            deck[rank+39]=new Card(4,rank);

        }
        next=1;
    }
    public void shuffle(){
        //DONE: rearrange deck.
        Random shuffler=new Random();
        for (int card =1;card<=52;card++){
            int randNumber =shuffler.nextInt(52)+1;
            //swapping card using a temp memory approach
            Card temp = deck[card];
            deck[card]=deck[randNumber];
            deck[randNumber]=temp;
        }
        next=1;
    }
    public Card deal(){
        //TODO: return the next card in deck.
        if (next>52){//when all the cards are exhausted.
           shuffle();}
        Card card =deck[next];
        next++;
        return card;

    }
}
