
import java.util.Scanner;


class Word {

    int start;
    int end;
    String word;
    String reved;
}

public class Plaindrome {

    public static void main(String[] args) {
        //Folowing are some of the working sentences you can use
        //Able was I ere I saw Elba
        //Step on no pets
        String original;  // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome");
        original = in.nextLine();
        String finaltext = original.toLowerCase();
        String[] cutsen = finaltext.split("\\s+");
        int length = original.length();
        Word[] a = new Word[length + 1];

        //inserting word by word into the word class;
        for (int i = 0; i < cutsen.length; i++) {
            a[i] = new Word();
            a[i].word = cutsen[i];
            if (i == 0) {
                a[i].start = 0;
                a[i].end = cutsen[i].length() - 1;
            } else {
                a[i].start = a[i - 1].end + 2;
                a[i].end = a[i].start + cutsen[i].length() - 1;
            }
        }
        System.out.println("Checking each word of given sentence is palindrome or not ");
        
        for (int i = 0; i < cutsen.length; i++) {
            palcheck(a[i]);
        }
        System.out.println("****************************************************************************");
        System.out.println("Checking every subquires of string that can be genrated by given setence is palindrome or not");
        for (int i = 0; i < cutsen.length; i++) {
            Word concat = new Word();
            concat.word = a[i].word;
            concat.reved = reversword(a[i].word);
            for (int j = i + 1; j < cutsen.length; j++) {
                concat.word += " " + a[j].word;
                concat.reved += " " + reversword(a[j].word);
                concat.start = a[i].start;
                concat.end = a[j].end;
                palchecksen(concat);
            }

        }

    }
    
    //method for chekcing setence is plaindrome or not
    static void palchecksen(Word object) {
        int length = object.reved.length();
        String reverse = "";
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + object.word.charAt(i);
        }

        if (object.word.equals(reverse)) {
            System.out.println("[" + object.start + "," + object.end + "]" + "->Substring \"" + object.word + "\" is a plaindrome");
        } else {
            System.out.println("[" + object.start + "," + object.end + "]" + " ->Substring \"" + object.word + "\" is not plaindrome");
        }

    }
    
    //method for reversing characters
    static String reversword(String word) {
        String result = "";
        char[] ch = word.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            result += ch[i];
        }
        return result;

    }

    // method for chekcing whther give word is a plaindrome or not
    static void palcheck(Word object) {
        int length = object.word.length();
        String reverse = "";
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + object.word.charAt(i);
        }

        if (object.word.equals(reverse)) {
            System.out.println("[" + object.start + "," + object.end + "]" + "->Substring \"" + object.word + "\" is a plaindrome");
        } else {
            System.out.println("[" + object.start + "," + object.end + "]" + " ->Substring \"" + object.word + "\" is not plaindrome");
        }

    }

}
