//Tatsiana Uryeva
//CS1400
//Assignment 5
//3/29/2021

import java.util.Arrays;
import java.util.Collections;

public class Deck 
{
	private Card[] deckOfCards = new Card[52];
	
	private String[] faces = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	
	public Deck()
	{
		int count = 0;
		for (int i = 0; i < faces.length; i++)
		{
			for (int j = 0; j < suits.length; j++)
			{
				if(i < 9)
				{
					deckOfCards[count] = new Card(faces[i], suits[j], i+2);
				}
				else if(i < 12)
				{
					deckOfCards[count] = new Card(faces[i], suits[j], 10);
				}
				else
				{
					deckOfCards[count] = new Card(faces[i], suits[j], 11);
				}
				
				count++;
			}
		}
	}
	
	public Card drawCard(int number)
	{
		return deckOfCards[number];
	}
	
	public void shuffle()
	{
		Collections.shuffle(Arrays.asList(deckOfCards));
	}
	
}
