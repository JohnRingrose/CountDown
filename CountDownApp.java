/*
 *John Ringrose
 *10/04/20
 *
 *CountDownApp.java
 *
 */

import java.util.*;
import javax.swing.JOptionPane;

public class CountDownApp {
    public static void main(String args[]) {

        //variables
        int roundsWanted = 0;//variable to store how many rounds players want to play
        int vowels;////variable to store vowels, after asking the player how many vowels do they want
        int consonants;//variable to store consonants, after asking the player how many consonants do they want
        char[] vowelC = new char[5];//an array to store vowels chosen by the player
        char[] consonantC = new char[21];//an array to store consonants chosen by the player
        String word1 = "";//string variable to store the word created by player 1 and send it to the instantiable to check if its valid
        String word2 = "";//string variable to store the word created by player 2 and send it to the instantiable to check if its valid
        String vowelNew="";//String variable to store randomized vowels in String brought over from instantiable class with getVowelChoice()
        String consonantNew="";//String variable to store randomized consonants in String brought over from instantiable class with getConsonantsChoice()
        String validWord1;//a string to store the variable to send to the instantiable class to see if the word chose by player 1 is valid
        String validWord2;//a string to store the variable to send to the instantiableclass to see if the word chose by player 2 is valid
        String winner;//String variable to use on object myCountDown with method getWinner(); from instantiable class
        int player1Scr = 0;//variable to storeplayer 1's score
        int player2Scr = 0;//variable to storeplayer 2's score
        String plyAgain = "";//variable to store the question if player wants to play again, to use with the encompassing do while loop



        //creating an instance of the object CountDown
        CountDown myCountDown;
        //declaring an instance of the object CountDown
        myCountDown = new CountDown();


        //do while loop - to encompass all for the app,to ask player at the end of the game do they wish to play again
       do {

        //input from to user to find out how many rounds they would like to play and storing that in roundsWanted
        roundsWanted = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome to Java CountDown, How many rounds would you like to play?"));

        //for loop to run the app as many rounds as the player requested, using roundsWanted int that I got from player
        for (int i = 0; i <= roundsWanted; i++) {

            //informing the players the rules of the game
            JOptionPane.showMessageDialog(null, "In Java CountDown you are asked to create a word from java, you are given 9 letters to choose from, a mix of vowels and consonants,\n  you choose how many  of each but not exceeding 9, but you must use each letter only once");

            //asking the player how many vowels do they want and storing in the variable int vowels
            vowels = Integer.parseInt(JOptionPane.showInputDialog(null, "How many vowels would you like? (Remember you only get 9 of both vowels and consonants in total)"));

            //sending the number of vowels wanted to the instantiable class
            myCountDown.setVowels(vowels);

            //asking player how many consonants wanted
            consonants = Integer.parseInt(JOptionPane.showInputDialog(null, "How many consonants would you like?"));

            //sending consonants wanted to instantiable class with the method setConsonants()
            myCountDown.setConsonants(consonants);


            //using computVowels method on the object to get randomized vowels for the player to choose from
            myCountDown.computVowels();

            //using computConsonant method on the object to get randomized consonants for the player to choose from
            myCountDown.computConsonant();

			//bringing over getVowelChoice() method;from instantiable class and using it to store randonized vowels in vowelNew
			vowelNew = myCountDown.getVowelChoice();


            //bringing over getConsonantChoice() method;from instantiable class and using it to store randonized consonants in consonantNew
             consonantNew = myCountDown.getConsonantChoice();


            // displaying the vowels and consonants that were randomly chosen
			JOptionPane.showMessageDialog(null, "Here are your vowels "+ vowelNew +" and here are your consonants "+ consonantNew +"Press enter when done.");

            //getting the word chosen from player 1 and storing it in word1
            word1 = JOptionPane.showInputDialog(null, "Player 1, please enter your word");

            //sending player 1's choice of word stored in word1 to instantiable class
            myCountDown.setWord1(word1);

            //getting the word chosen from player 2 and storing it in word2
            word2 = JOptionPane.showInputDialog(null, "Player 2, please enter your word");

            //sending player 2's choice of word, stored in word2 to instantiable class
            myCountDown.setWord2(word2);

            //using the getValidateWord1() method on the object to see if the player 1 words were valid
            validWord1 = myCountDown.getValidateWord1();

			//if statement to check if the word chosen by player 1 is valid from array jWords in the instantiable class
            if (validWord1.equals("validNo")) {
                	JOptionPane.showMessageDialog(null, "Sorry player 1, you have entered an invalid word.");
            } else {
                	JOptionPane.showMessageDialog(null, " Player 1 you have entered a valid word");
                //enter to check for longest word
            }

           //using the getValidateWord2() method on the object to see if the player 2 words were valid
            validWord2 = myCountDown.getValidateWord2();

            //if statement to check if the word chosen by player 2 is valid from array jWords in the instantiable class
           if (validWord2.equals("validYes")) {
                	JOptionPane.showMessageDialog(null, " Player 2 you have entered a valid word");
                	//enter to check for longest word
            } else {
                	JOptionPane.showMessageDialog(null, "Sorry player 2, you have entered an invalid word.");
            }

			//using the getWinner() method in the instantiable class on the object myCountDown and storing in String winner
            winner = myCountDown.getWinner();

			//if statement to display the round winner using JOption Pane using String winner
            if (winner.equals("Player 1")) {
                player1Scr = player1Scr + 1;
                	JOptionPane.showMessageDialog(null, "Congrats Player 1, you won this round");
            } else {
                player2Scr = player2Scr + 1;
               		JOptionPane.showMessageDialog(null, "Congrats Player 2, you won this round");
            }
        }//bracket for the end of the main for loop that encompasses the game

			//if statement to check who won the game and using Joption Pane to display winner of game
			if (player1Scr > player2Scr) {
					JOptionPane.showMessageDialog(null, "Congrats Player 1, you have won, your score was" + player1Scr + "Player 2 you only got" + player2Scr);
			} else {
					JOptionPane.showMessageDialog(null, "Congrats Player 2, you have won, your score was" + player2Scr + "Player 1 you only got" + player1Scr);
			}

			//using String plyAgain to store value to check if the player want to play the game again
			plyAgain = JOptionPane.showInputDialog(null, "Would you like to play again? press y for yes or hit enter for to quit");



		//closing bracket for the do while loop, used to ask the player if they wish to play again
   	   }while(plyAgain.equalsIgnoreCase("y"));
    }
}