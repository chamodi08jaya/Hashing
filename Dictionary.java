import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Dictionary{
	
		//Structure
		static class Word {
        public String english = "";
        public String french = "";
        public String spanish = "";
        public Word(String eng,String fre,String spn){
            this.english = eng;
            this.french = fre;
            this.spanish = spn;
        }    
		}

		//Generating hash value	to english word and get the key using linear probing.
		public static int hashfunc(String eng){
			int key;
			int temp = 0;
			for(char letter :eng.toCharArray())
			{
				temp = temp + (int)letter;
			}
			key = temp/100;
			return key;
		}

		//find out the index to given array list
		public static int finder(int index,ArrayList<Word> dic) {
			try {
				while(true)
				{
					if(dic.get(index)!=null)
					{
						index++;
					}
					else{
						return index;
					}
				}
			} catch ( IndexOutOfBoundsException e ) {
				while (dic.size() <= index)
				{
					dic.add(null);
				}
				return index;
			}
			
		}
		
		//Function which make the sentence simple by removing follwing words replace it by space character.
		public static String simplify(String sentence) {
			String deleteWords[] = {"the ","The ","a ","A ","be ","Be ","am ","Am ","is ","Is ","are ","Are ","was ","Was ","were ","Were ","has ","Has ","have ","Have ","do ","Do ","does ","Does ","did ", "Did ","it ", " .",", "," !"," ?"};
			String simple = sentence;
			for (String deleteWord:deleteWords) {
				simple = simple.replace(deleteWord, "");
			}
			return simple;
		}
			
		//GetIndex function to check whether the the index of the  word is in the hashtable
		public static int getIndex(int key,ArrayList<Word> dict,String word) {
			try{
				while(true)
				{
					if(dict.get(key).english.equals(word) || dict.get(key).english.equals(word.toLowerCase()))
					{ 
						return key;
					}
					else{
						key++;
					}
				}
			}catch(IndexOutOfBoundsException e){
				return -1;
			}
		}

		//convert all string the first character capital and the other characters are simpled.
		public static String capitalize(String str){
        
			if(str == null || str.length() == 0)
				return "";
        
			if(str.length() == 1)
				return str.toUpperCase();
        
			return str.substring(0, 1).toUpperCase() + str.substring(1);
    
		}

		//Read a  Word dictionary CSV file
		public static void dictionaryLoader(ArrayList<Word> dic,String csvFile,String splitBy){
			String line = " ";
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				//ignore first line
				br.readLine();
				while((line = br.readLine()) != null){
					// use comma as separator
					String[] temp = line.split(splitBy);
					//create the hash value
					int key = hashfunc(temp[0]);
					
					int index = finder(key, dic);
                
					//making array structure and put it into a hash table
					Word word = new Word(temp[0], temp[1], temp[2]);
					//set index and word to the dictionary file
					dic.set(index, word);

					//System.out.println(line);
				}
			} catch (IOException e){
				e.printStackTrace();
				//System.out.println(e);
			}
		
		}	
		
		//Translate function
		public static void translator(ArrayList<Word> dictionay,String csvFile) {
			String line = "";
			String splitBy = " ";

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

				while ((line = br.readLine()) != null) {
					//Original sentence read from the sentence file csv
					System.out.println("Original sentence :\n"+line);
					//called the simpleLine function
					String simpleLine = simplify(line);
					//print the processed sentence
					System.out.println("Processed sentence :\n"+simpleLine);
					String[] words = simpleLine.split(splitBy); 
					//print the french translate
					System.out.println("French sentence :");
				
					for(String word: words)
					{
						//captilize the function
						int key = hashfunc(capitalize(word));
						//called the getndex function to check whether the relevent key in the index of hashtable.
						int index = getIndex(key, dictionay, capitalize(word));
						if(index!=-1)
						{
							//System.out.print(dictionay.get(index).spanish+" ");
							System.out.print(dictionay.get(index).french+" ");
						}
						else{
							System.out.print("["+word+"] ");
						}

					}
					System.out.println("");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static void main(String[] args){
				//making an array list of word to the dictionary
				ArrayList<Word> dictionary = new ArrayList<Word>();
				
				//get the word dictionary csv file in to a variable.
				String diccsvFile = "Word_dictionary_For_Q2.csv";
				
				//get the sentence csv file in to a variable.
				String sentencecsvfile = "Sentence.csv";
				
				//split the words using comma is get in to a variable
				String splitBy = ",";
				
				dictionaryLoader(dictionary,diccsvFile,splitBy);
				//Traslate fuction of sentence to the relevent languge
				translator(dictionary, sentencecsvfile);


		}

}