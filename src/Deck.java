import java.util.Random;

public class Deck {

    //The deck is represented as an array of Cards
    private final Card[] deck;
    //keeps track of the card to be dealt next
    private int dealIndex;

    private static final int DECK_SIZE = 52;

    //Constructor: No parameters. Fills the deck with cards and initializes the dealIndex
    public Deck(){
        deck = new Card[DECK_SIZE];

        int index = 0;
        for(Suit suit : Suit.values()){
            for(Value value : Value.values()){
                deck[index] = new Card(suit, value);
                index++;
            }
        }
        dealIndex = 0;
    }

    //Collects any dealt cards and shuffles the entire deck
    public void shuffle(){
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        //traverse the deck and swap each card with another random card
        for(int i = 0; i < DECK_SIZE; i++){
            int randomIndex = rand.nextInt(DECK_SIZE);

            //swap current card with random card in the deck
            Card temp = deck[randomIndex];
            deck[randomIndex] = deck[i];
            deck[i] = temp;
        }

        //reset the index for dealt cards
        dealIndex = 0;
    }

    //Deal a single card from the top of the deck and return null if the entire deck has been dealt
    public Card dealOneCard(){
        //check if cards remain in the deck
        if(dealIndex >= DECK_SIZE){
            return null;
        }
        else{
            return deck[dealIndex++];
        }
    }
}