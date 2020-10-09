package com.appian.deckofcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appian.deckofcards.models.Deck;

/**
 * 
 * @author JOSE MANUEL
 *
 */
@SpringBootApplication
public class DeckofcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeckofcardsApplication.class, args);
		
		System.out.println("Creating Deck...");
		Deck deck = new Deck();
		System.out.println("Deck Created! : " + deck);
		System.out.println("Shuffling Deck...");
		deck.shuffle();
		System.out.println("Deck Shuffled! : " + deck);
		System.out.println("Dealing one card...");
		System.out.println("Your card is -> " + deck.dealOneCard() + " !");
	}

}
