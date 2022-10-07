/*
*John Ringrose
*10/04/20
*
*CountDown.java
*
*/
import java.util.*;
public class CountDown{

	//variables

	private int vowels;//variable for storing how many vowels player wants
	private int consonants;//variable for storing how many consonants player wants
	private String word1;//variable for storing player 1 choice of word
	private String word2;//variable for storing player 2 choice of word
	private String vowelChoice;//variable for storing vowels chosen
	private String consonantChoice;//variable for storing consonants chosen
	private String validWord1;//variable to store the input of whether the word created by player 1 is in jWords[]in the instantiable class
	private String validWord2;//variable to store the input of whether the word created by player 2 is in jWords[]in the instantiable class
	private int len1=0;//using len1 to store the length of player 1's word to caluate which word is longer
	private int len2=0;//using len2 to store the length of player 2's word to caluate which word is longer
	private String winner;//String to store who has the longest word to send to app class


	//arrays
	private	char vowelsArr[] = { 'a','e','i','o','u'};//array to store vowels
	private char consonantsArr[] = { 'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','x','z'};//array to store consonants
	//array to store java words
	private String jWords[] = {"abstract","assert","boolean","break","byte","case","catch","char","class","continue","default","do","double","else","enum","extends","final","finally","float","for","if","import","int","interface","long","native","new","package","private","protected","public","return", "short","static","strictfp","super","switch","this","throw","throws","transient","try","void","volatile","while"};
	private char[] vowelChoiceArr = new char[6];//array to store the randomized vowels that are generated from the players choice of vowels
	private char[] consonantChoiceArr = new char[22];//array to store the randomized consonants that are generated from the players choice of consonants
	//constructor
	public CountDown(){


		vowels=0;
		consonants=0;
		word1=" ";
		word2=" ";
		validWord1=" ";
		validWord2=" ";
	}

	//setters

	//..setting how many vowels the player wants from the main class
	public void setVowels( int vowels){
			this.vowels=vowels;
	}
	//..setting how many consonants the player wants  from the main class
	public void setConsonants(int consonants){
			this.consonants=consonants;
	}
	//.setting player 1 choice of word  from the main class
	public void setWord1(String word1){
			this.word1=word1;
	}
	//.setting player 2 choice of word  from the main class
	public void setWord2(String word2){
			this.word2=word2;
	}




	//process

	//putting number of vowels in in vowelsArr from vowels(the number of vowels wanted)

	//method to get randomly chosen vowels
	public void computVowels(){


		//putting random generated vowels into the vowelChoiceArr[] for the next step of process to display to player
		for (int i=0;i < vowelsArr.length;i++){

			vowelChoiceArr[i] = vowelsArr[(int)(Math.random()*4)+1];//randomize a vowel



		}//bracket for for loop
	//for loop to convert the random generated vowels in vowelChoiceArr into a String called vowelChoice
   		for (int i=0;i < vowelChoiceArr.length;i++){


   			vowelChoice = Arrays.toString(vowelChoiceArr);

		}

		//vowelChoice = vowelChoiceArr;
	}//bracket for method computVowels

	//putting random generated consonants into the consonantChoiceArr[] for the next step of process to display to player
   public void computConsonant(){



		//trying to check how many consonant player asked for then generate random consonant from consonantArr and put the values in consonantChoiceArr****
		for (int i=0;i < consonantsArr.length;i++){

			consonantChoiceArr[i]= consonantsArr[(int)(Math.random()*6)+1];//randomize a consonant



		}//bracket for for loop
	//for loop to convert the random generated consonants in consonantChoiceArr into a String called consonantChoice
		for (int i=0;i < consonantChoiceArr.length;i++){


		   	consonantChoice = Arrays.toString(consonantChoiceArr);

		}


	}//bracket for method computVowels


	//checking that the word entered by player 1 is valid by running it through the Jwords[] array
	public String validateWord1(){
	     for (int i = 0; i < jWords.length; i++){

	            if(word1.equalsIgnoreCase(jWords[i])){

                    String vaildWord1 = "validYes";
		}else{
				 validWord1 = "validNo";
		}
	  }
				return validWord1;

	}
	//checking the word entered by player 2 is valid by running it through the Jwords[] array
	public String validateWord2(){
		  for (int i = 0; i < jWords.length; i++){

		            if(word2.equalsIgnoreCase(jWords[i]))
		    {
	                    String vaildWord2 = "validYes";
			}else{
					 validWord2 = "validNo";
			}

			}
				return validWord2;

	}
	//checking to see which is the longest word
	public void longWordCheck(){
		len1=word1.length();
		len2=word2.length();
		if(len1<len2){
				winner="Player 2";
			}
			else{
				winner ="Player 1";
			}
	}



	//getters
	//getting the randomly generated vowels in the String vowelChoice to be called in the app
	public String getVowelChoice(){

			return vowelChoice;
	}

	//getting the randomly generated consonants in the String consonantChoice to be called in the app
	public String getConsonantChoice(){

			return consonantChoice;
	}

	//getter for app class to validate playe 1's word is in jWords[]
	public String getValidateWord1(){

			return validWord1;
	}
	//getter for app class to validate playe 2's word is in jWords[]
	public String getValidateWord2(){

			return validWord2;
	}
	//getter for app class to return who was the winner from longWordCheck() method
	public String getWinner(){
			 return winner;
	 }



}//bracket for whole class