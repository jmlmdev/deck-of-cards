package com.appian.deckofcards.models;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		List<Card> obj1Cards = new ArrayList<>(this.getCards());
		List<Card> obj2Cards = new ArrayList<>(((Deck) obj).getCards());

		if (!obj1Cards.equals(obj2Cards)) {
			return false;
		}
		return true;
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
