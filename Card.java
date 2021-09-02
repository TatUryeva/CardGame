//Tatsiana Uryeva
//CS1400
//Assignment 5
//3/29/2021

public class Card 
{
	private String face;
	private String suit;
	private int value;
	
	public Card(String f, String s, int v)
	{
		face = f;
		suit = s;
		value = v;
	}
	
	public String getFace()
	{
		return face;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void changeValue(int newValue)
	{
		value = newValue;
	}
}
