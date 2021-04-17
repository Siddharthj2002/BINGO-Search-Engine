/**
* FileRelations is intended to be a simple search engine to find the most related text files possible
* @author Siddharth Jain
* @version 1.0
*/

public class BingoSE{

   /**
   * A String variable holding the file name for the highest scoring file
   */
   private String topFile;
   
   /**
   * A double variable holding the score for the highest scoring file
   */
   private double topScore;
   
   /**
   * A String array holding all the key words to search for
   */
   private String[] wordsToFind;
   
   
   /**
   * This is the primary and only constructor for the FileRelations class.
   * @param toFind holds all the key words to search for
   */
   public BingoSE(String[] toFind){
      topFile = "";
      topScore = 0;
      wordsToFind = toFind;
   }
   
   
   /**
   * Analyses the file based on the keywords and updates the top scoring file and score once done.
   * @param fileContent an array of Strings each representing a line in the original file
   * @param fileName the name of the file being analysed
   */ 
   public void analyseFile(String[] fileContent, String fileName){
      double fileScore = 0;
      for(int i = 0; i < fileContent.length; i++){
         fileScore = fileScore + scoreLine(fileContent[i]);
      }
      fileScore = fileScore / (fileContent.length);
      if((fileScore > topScore) || (fileScore == 0 && topScore == 0)){
         topScore = fileScore;
         topFile = fileName;
      }
           
   }
   
   
   /**
   * Analyses the line passed in and scores it based on frequency of the key words. 
   * (A helper method for analyseFile).
   * @param line a String representing a single line in a file
   * @returns the score of the line passed in
   */ 
   private int scoreLine(String line){
      int lineScore = 0;
      String[] wordsInLine = line.split(" ");
      for(int i = 0; i < wordsInLine.length; i++){
         lineScore = lineScore + countWord(wordsInLine[i]);
      }
      return lineScore;
   }
   
   
   /**
   * Analyses the word passed in and scores it based on if it is one of the key words. 
   * (A helper method for scoreLine).
   * @param word a String representing a single word in a file
   * @returns the score of the word passed in
   */ 
   private int countWord(String word){
      int wordScore = 0;
      for(int i = 0; i < wordsToFind.length; i++){
         if(wordsToFind[i].equalsIgnoreCase(word)){
            wordScore++;
         }
      }
      return wordScore;
   }
   
   
   /**
   * A getter method for the key words used in this object's search
   * @returns a String array containing the key words to search for.
   */ 
   public String[] getWords(){
      return wordsToFind;
   }
   
   
   /**
   * A getter method for the top scoring file in the object currently
   * @returns a String representing the file name of the top scoring file.
   */ 
   public String getTopFile(){
      return topFile;
   }
   
   
   /**
   * A getter method for the score of the top scoring file in the object currently
   * @returns a double representing the score of the top scoring file.
   */ 
   public double getTopScore(){
      return topScore;
   }
}