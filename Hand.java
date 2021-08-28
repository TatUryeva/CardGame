//Tatsiana Uryeva
//CS1400
//Assignment 5
//3/29/2021

import java.util.ArrayList;

public class Hand 
{
	private ArrayList<Card> handOfCards;
	
	public Hand()
	{
		handOfCards = new ArrayList<>();
	}
	
	public int getSize()
	{
		return handOfCards.size();
	}
	
	public Card getCard(int index)
	{
		return handOfCards.get(index);
	}
	
	public void addCard(Card inputCard)
	{
		handOfCards.add(inputCard);
	}
	
	public int calculateHandValue()
	{
		int handValue = 0;
		for (int i = 0; i < handOfCards.size(); i++)
		{
			handValue = handValue + handOfCards.get(i).getValue();
		}
		
		return handValue;
	}
	
	public void printHand()
	{
		for (int i=0; i<handOfCards.size(); i++)
		{
			System.out.println(handOfCards.get(i).getFace() + " of " + handOfCards.get(i).getSuit());
		}
	}
}
