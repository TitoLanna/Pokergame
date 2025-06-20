public class Card {
    //instance variable
    private int suit;
    private int value;
    //constructors
    public Card(){
        suit =1;
        value=1;
    }
    public Card(int s,int v){
        suit =s;
        value=v;
    }
    //Methods
    public int getSuit(){
        return suit;
    }
    public int getValue(){
        return value;
    }
    public void setSuit(int s){
        suit=s;
    }
    public void setValue(int v){
        value=v;
    }
    public String getName(){
        String name ="";
        if (value==1){
            name= "Ace of ";}
        else if(value==11){
          name="Jack of";
        } else if (value==12) {
            name ="Queen of ";
        } else if (value==13) {
            name="King of ";
        }else name=value+" ";

        if (suit==1){
            name+="Hearts";
        }else if(suit==2){
            name+="Diamond";
        } else if (suit==3) {
            name+="Clubs";
        }else name+="Spades";
        return name;
    }


}
