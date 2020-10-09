package com.appian.deckofcards.models;

/**
 * 
 * @author JOSE MANUEL
 *
 */
public interface IDeck {

	/**
	 * Shuffle cards in the deck.
	 */
	public void shuffle();

	/**
	 * 
	 * @return Returns one card from the deck, if the deck is empty, no card will be
	 *         returned.
	 * @throws IllegalStateException
	 */
	public Card dealOneCard();

}
