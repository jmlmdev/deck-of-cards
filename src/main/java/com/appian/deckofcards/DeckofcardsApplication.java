package com.appian.deckofcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appian.deckofcards.models.Deck;

@SpringBootApplication
public class DeckofcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeckofcardsApplication.class, args);
		
		Deck deck = new Deck();
		System.out.println(deck);
		System.out.println(deck.getCards().size());
	}

}
