package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import pkgException.*;
import pkgEnum.*;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}
	
	//Throws an exception if the deck is empty
	public Card Draw() {
		try {
			if (cardsInDeck.size() > 0)
				return cardsInDeck.remove(0);
			
			throw new DeckException(this);
			
		} catch (DeckException c) {
			
			return new Card(null,null);
		}
	}
	
	//Method to Draw a card of a given eSuit
	public Card Draw(eSuit eSuit) {
		try {
			int i = 0;
			for (Card c : cardsInDeck) {
				if (c.geteSuit() == eSuit)
					return cardsInDeck.remove(i);
				else
					i++;
			}
			throw new DeckException(this);
		} catch(DeckException c) {
			return new Card(null,null);		
			}
	}
	
	//Method to Draw a card of a given eRank
	public Card Draw(eRank eRank) {
		try {
			int i = 0;
			for (Card c : cardsInDeck) {
				if (c.geteRank() == eRank)
					return cardsInDeck.remove(i);
				else
					i++;
			}
			throw new DeckException(this);
		} catch(DeckException c) {
			return new Card(null,null);		
			}
	}

	//Method that will return the number of a given eSuit left in the deck.
	public int nbrOfeSuit(eSuit eSuit) {
		
		Stream<Card> cardsOfeSuit = cardsInDeck.stream()
				.filter(c -> c.geteSuit() == eSuit);
		
		return (int)cardsOfeSuit.count();
	}
	
	//Method that will return the number of a given eRank left in the deck.
	public int nbrOfeRank(eRank eRank) {
		
		Stream<Card> cardsOfeRank = cardsInDeck.stream()
				.filter(c -> c.geteRank() == eRank);
		
		return (int)cardsOfeRank.count();
	}
	
	//Method that will return 0 or 1 if a given card is left in the deck.
	public int cardCheck(eRank eRank, eSuit eSuit){
		try {
			cardsInDeck.stream()
					.filter(c -> c.geteRank() == eRank && c.geteSuit() == eSuit)
					.findFirst()
					.get();
			return 1;
		}catch (NoSuchElementException c) {
			return 0;
		}
		}
	}

