package com.appian.deckofcards;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.appian.deckofcards.enums.Face;
import com.appian.deckofcards.enums.Suit;
import com.appian.deckofcards.models.Card;
import com.appian.deckofcards.models.Deck;

@SpringBootTest
class DeckofcardsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void shuffleTest() {

		// Given
		Deck deck = new Deck();
		List<Card> beforeShuffleCards = new LinkedList<>(deck.getCards());

		// When
		deck.shuffle();
		List<Card> afterShuffleCards = new LinkedList<>(deck.getCards());

		// Then
		assertTrue(!beforeShuffleCards.equals(afterShuffleCards) && beforeShuffleCards.containsAll(afterShuffleCards));
	}

	@Test
	public void dealOneCardTest() {

		// Given
		Deck deck = new Deck();
		Integer beforeDeckSize = deck.getCards().size();
		deck.getCards().remove(new Card(Suit.CLUBS, Face.ACE));
		
		// When
		Card card = deck.dealOneCard();
		Integer afterDeckSize = deck.getCards().size();

		// Then
		assertTrue(card != null && card instanceof Card && afterDeckSize == beforeDeckSize - 1);
	}
}
