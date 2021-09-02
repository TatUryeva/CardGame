//Tatsiana Uryeva
//CS1400
//Assignment 5
//3/29/2021

import java.util.Scanner;

public class Game 
{
	
	public static Hand addCardToHand(Hand hand, Deck deck, int n)
	{
		hand.addCard(deck.drawCard(n));
		
		if (hand.getCard(hand.getSize() - 1).getFace().equals("Ace") && hand.calculateHandValue() > 21)
		{
			hand.getCard(hand.getSize() - 1).changeValue(1);
		}
		
		return hand;
	}
	
	public static void main(String[] args) 
	{
		Deck gameDeck = new Deck();
		final int MAX = 21;
		int num;
		boolean blackjack;
		String userInput;
		int userWon = 0, totalRounds = 0;
		
		Scanner input = new Scanner(System.in);
		
		Hand playerHand;
		Hand dealerHand;
		
		do
		{
			num = 0;
			userInput = "hit";
			blackjack = false;
			
			gameDeck = new Deck();
			gameDeck.shuffle();
			
			playerHand = new Hand();
			playerHand.addCard(gameDeck.drawCard(num));
			num++;
			
			System.out.println("\t***********************************");
			System.out.println("\t* Welcome to the Black Jack Table *");
			System.out.println("\t***********************************");
			
			while (userInput.equals("hit") && playerHand.calculateHandValue() < MAX)
			{
				playerHand = addCardToHand(playerHand, gameDeck, num);
				num++;
				
				System.out.println();
				System.out.println("Your hand is:");
				playerHand.printHand();
				System.out.println("<"+playerHand.calculateHandValue()+" points>");
				
				if(playerHand.calculateHandValue() < MAX)
				{
					System.out.println();
					System.out.print("Do you want to stand or hit? ");
					userInput = input.nextLine();
				}
				else if(playerHand.calculateHandValue() > MAX)
				{
					System.out.println("Bust!");
					
					System.out.println();
					System.out.println("The dealer wins!");
				}
				
				if (playerHand.calculateHandValue() == 21 && playerHand.getSize() == 2)
				{
					blackjack = true;
				}
			}
			
			if(playerHand.calculateHandValue() <= MAX)
			{
				dealerHand = new Hand();
				dealerHand.addCard(gameDeck.drawCard(num));
				num++;
				
				dealerHand = addCardToHand(dealerHand, gameDeck, num);
				num++;
				
				System.out.println();
				System.out.println("The dealer's hand is:");
				dealerHand.printHand();
				System.out.println("<"+dealerHand.calculateHandValue()+" points>");
				
				if (!blackjack)
				{	
					while (dealerHand.calculateHandValue() < playerHand.calculateHandValue() && dealerHand.calculateHandValue() < MAX)
					{
						System.out.println();
						System.out.println("The dealer draws a card...");
						
						dealerHand = addCardToHand(dealerHand, gameDeck, num);
						num++;
						
						System.out.println();
						System.out.println("The dealer's hand is now:");
						dealerHand.printHand();
						System.out.println("<"+dealerHand.calculateHandValue()+" points>");
						
						if(dealerHand.calculateHandValue() > MAX)
						{
							System.out.println("Bust!");
							
							userWon++;
							
							System.out.println();
							System.out.println("Hooray, you win!");
						}
					}
					
					if (dealerHand.calculateHandValue() >= playerHand.calculateHandValue() && dealerHand.calculateHandValue() <= MAX)
					{
						System.out.println();
						System.out.println("The dealer wins!");
					}
				}
				else if(blackjack && dealerHand.calculateHandValue() < 21)
				{
					userWon++;
					
					System.out.println();
					System.out.println("Hooray, you win!");
				}
				else
				{
					System.out.println();
					System.out.println("The dealer wins!");
				}
			}
			
			totalRounds++;
			
			System.out.println();
			System.out.println("You won " + (int) ((double) userWon/(double) totalRounds*100) + "% of all rounds.");
			System.out.println();
			
			System.out.print("Do you want to play again? (yes/no) ");
			userInput = input.nextLine();
			System.out.println();
			
		} while (userInput.equals("yes"));
		
		input.close();
	}

}
