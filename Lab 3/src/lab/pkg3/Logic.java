/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3;

/**
 *
 * @author domingodavid
 */
public class Logic {
    
    /**
     * Return an updated score if won is true.
     * updateScore(1,true)-> 2
     * updateScore(2,false)->2
     * @param score
     * @param won
     * @return the updated score
     */
    public static int updateScore(int score, boolean won)
    {
        if (won == true)                                                        //check if the player has won the current game
        {
            return score +1;                                                    //update the score if they won that game
        }
        return score;                                                           //otherwise, keep the score as is because they lost
    }
    
    /**
     * Given an existing string that keeps track of guessed letters/words
     * add the current guess to the list
     * addStrike("rslt","n")->"rsltn"
     * addStrike("abc","n")->"abcn"
     * @param list current list of strikes or incorrect guesses
     * @param guess current incorrect guess
     * @return the new list containing the newly made incorrect guess
     */
    public static String addStrike(String list, String guess)
    {
        return list + guess;                                                    //simply add your incorrect guess to the growing list...
    }
    
    /**
     * Checks if the user word guess matches the word to be guessed.
     * GuessWord("test", "best")->False GuessWord("test", "TEST")->True
     * GuessWord("test", "t est")->False
     *
     * @param word
     * @param guess
     * @return
     */
    public static boolean guessWord(String word, String guess)
    {
        if (word.equalsIgnoreCase(guess))                                       //checks if the guess is the same as the word
        {
            return true;                                                        //confirmation that it is right
        }
        return false;                                                           //negation if it is wrong
    }
    
    /**
     * A method used to figure out if a player's guess is successful or not.
     * A guess is successful if the letter has not already been guessed and is 
     * in the word to be guessed.
     * guessLetter("apcs","A_CS","A")->false
     * guessLetter("apcs","A_CS","P")->true
     * @param word the word to be guessed
     * @param curr the current displayed text to the user
     * @param guess the letter being guessed
     * @return true or false
     */
    public static boolean guessLetter(String word, String curr, String guess)
    {
        for (int i = 0; i < word.length(); i ++)                                //loop to check every character one at a time
        {
            if (word.substring(i, i+1).equalsIgnoreCase(guess))                 //check if the guess is in the word
            {
                if (curr.substring(i, i+1).equalsIgnoreCase(guess))             //check if the guess is in the currecnt string
                {
                    return false;                                               //if there is a repeat, it is wrong
                }
                return true;                                                    //if there is no repeat then it is right
            }
        }
        return false;                                                           //if the guess is wrong, it is all wrong
    }

    /**
     * The word shown to a player for Hang-Man must be coded such that only the
     * correctly guessed letters are visible to the player. The rest of the
     * letters must be underscores __.
     *
     * This method has three parameters as described below. Given the word, the
     * current displayed text and the letter that was guessed return a new
     * version of the display word.
     *
     * @param word to be guessed
     * @param curr text shown to the player
     * @param guess letter or word guessed by the player
     * @return new version of displayed text
     */
    public static String encrypt(String word, String curr, String guess)
    {
        String result = curr;                                                   //set result as a temporary copy of the string
        for (int i = 1; i < word.length() +1; i ++)                             //checks every character
        {
            if (word.substring(i-1, i).equalsIgnoreCase(guess))                 //checks if the guess is right
            {
                result = result.substring(0,i-1) + guess + result.substring(i); //updates the string being displayed
            }
        }
        return result;                                                          //return the updated string
    }
    
    /**
     * Return a version of the given string without spacing
     * You may assume that each character is followed immediately by a 
     * white space
     * withoutSpace("a b ")->"ab". 
     * withoutSpace("t _ r _ ")-> "t_r_"
     * @param str the string to be transformed
     * @return version of the string without spaces as shown above
     */
    public static String withoutSpaces(String str)
    {
        String result = str;                                                    //set result as the temporary string
        int andrew = str.length();                                              //find the length of the string
        for (int i = 1; i < andrew +1; i ++)                                    //check for the every character
        {
            if (result.substring(i-1, i).equals(" "))                           //checks if it is an empty space
            {
                result = result.substring(0,i-1) + result.substring(i);         //removes the empty space
                andrew--;                                                       //updates string length
            }
        }
        return result;                                                          //return the result
    }
    
    /**
     * Return a version of the string with spaces in between the letters
     * withSpaces("hi")->"h i "
     * withSpaces("apcs")-> "a p c s "
     * @param str the word to be transformed
     * @return the word with spaces as shown above
     */
    public static String withSpaces(String str)
    {
        String result = "";                                                     //set up an empty string
        int andrew = str.length();                                              //find the length of the string
        for (int i = 0; i < andrew; i ++)                                       //go through the string one at a time
        {
            result = result + str.substring(i,i+1) + " ";                       //build upon the empty string
        }
        return result;                                                          //return the result
    }

  
    /**
     * Return an empty string
     * @return an empty string
     */
    public static String clearText()
    {
        return "";                                                              //return an empty string
    }

    /**
     * Return a version of the string where each letter is replaced with
     * underscores (_)
     * reset("reset")->"_____";
     * reset("David")->"_____";
     * @param word the word to be transformed
     * @return a version of the word all with underscores
     */
    public static String reset(String word)
    {
        int andrew = word.length();                                             //find the length of the string
        String result = "";                                                     //set up an empty string
        for (int i = 0; i < andrew; i ++)                                       //run for every character
        {
            result = result + "_";                                              //add a blank space for every character
        }
        return result;                                                          //return the list of blank spaces
    }
}		        		        		        		        		        		        		        		        		        		        		        		        