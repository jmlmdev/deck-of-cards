package com.appian.deckofcards;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.appian.deckofcards.models.Card;
import com.appian.deckofcards.models.Deck;

/**
 * 
 * @author JOSE MANUEL
 *
 */
@SpringBootTest
class DeckofcardsApplicationTests {

	@Test
	@DisplayName("Test if the order of the deck card's is shuffled")
	public void shuffleTest() {

		// Given
		Deck deck = new Deck();
		List<Card> beforeShuffleCards = new ArrayList<>();
		beforeShuffleCards.addAll(deck.getCards());

		// When
		deck.shuffle();

		// Then
		assertTrue(!beforeShuffleCards.equals(deck.getCards()) && beforeShuffleCards.containsAll(deck.getCards()));
	}

	@Test
	@DisplayName("Test if deals a card from a deck successfully")
	public void dealOneCardTestOK() throws IllegalStateException {

		// Given
		Deck deck = new Deck();
		Card card = deck.getCards().get(0);
		Integer beforeDeckSize = deck.getCards().size();

		// When
		Card dealedCard = deck.dealOneCard();

		// Then
		assertTrue(dealedCard != null);
		assertTrue(card.getFace() == dealedCard.getFace());
		assertTrue(card.getSuit() == dealedCard.getSuit());
		assertTrue(deck.getCards().size() == beforeDeckSize - 1);
	}

	@Test
	@DisplayName("Test if exception is throwed when dealing one card from an empty deck")
	public void dealOneCardTestKO() throws IllegalStateException {

		// Given
		Deck deck = new Deck();

		// Then
		Assertions.assertThrows(IllegalStateException.class,
				() -> IntStream.rangeClosed(0, 52).forEach(i -> deck.dealOneCard()));
	}
}
