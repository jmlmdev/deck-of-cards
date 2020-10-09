package com.appian.deckofcards.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.appian.deckofcards.enums.Face;
import com.appian.deckofcards.enums.Suit;

/**
 * 
 * @author JOSE MANUEL
 *
 */
public class Deck implements IDeck {

	private List<Card> cards = new ArrayList<Card>();

	public Deck() {
		Stream.of(Suit.values()).forEach(suit -> {
			Stream.of(Face.values()).forEach(face -> cards.add(new Card(suit, face)));
		});
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	/**
	 * Shuffle cards in the deck.
	 */
	public void shuffle() {

		Random random = new Random();

		IntStream.rangeClosed(0, this.getCards().size() - 1).forEach(index -> {
			// Random pointer between 0 and 52
			int randomPointer = index + random.nextInt(52 - index);

			// swapping the elements
			Card randomCard = this.getCards().get(randomPointer);
			this.getCards().set(randomPointer, this.getCards().get(index));
			this.getCards().set(index, randomCard);
		});
	}

	/**
	 * 
	 * @return Returns one card from the deck, if the deck is empty, no card will be
	 *         returned.
	 * @throws IllegalStateException
	 */
	public Card dealOneCard() {
		if (this.getCards().isEmpty()) {
			throw new IllegalStateException("A card can not be dealed from an empty deck");
		}
		Card dealedCard = new Card(this.getCards().get(0).getSuit(), this.getCards().get(0).getFace());
		this.getCards().remove(0);
		return dealedCard;
	}

	@Override
	public String toString() {
		return "Cards: " + cards.toString();
	}

}
