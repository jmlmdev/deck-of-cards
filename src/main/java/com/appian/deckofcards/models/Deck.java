package com.appian.deckofcards.models;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.appian.deckofcards.enums.Face;
import com.appian.deckofcards.enums.Suit;

public class Deck {

	private Set<Card> cards = new LinkedHashSet<Card>();

	public Deck() {
		Stream.of(Face.values()).forEach(face -> {
			Stream.of(Suit.values()).forEach(suit -> cards.add(new Card(suit, face)));
		});
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	/**
	 * Randomize cards in the deck.
	 */
	public void shuffle() {

	}

	/**
	 * 
	 * @return Returns one card from the deck, if the deck is empty, no card will be
	 *         returned.
	 */
	public Card dealOneCard() {
		return null;
	}

	@Override
	public String toString() {
		return "Deck: " + cards;
	}

}
