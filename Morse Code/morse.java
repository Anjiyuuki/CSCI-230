// Angie Bui, Buia@g.cofc.edu
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
// Status: 
// It will decode the morse code but everything will be
// stuck together, I was not able to figure out how to
// separate it by the 3 space
// 
import java.util.*;
public class morse {

	// switch case to decode morse code
	public static String code(String morseCode) {
		
            switch (morseCode) {
	            case ".-":
	                return "A";
	            case "-...":
	                return "B";
	            case "-.-.":
	                return "C";
	            case "-..":
	                return "D";
	            case ".":
	                return "E";
	            case "..-.":
	                return "F";
	            case "--.":
	                return "G";
	            case "....":
	                return "H";
	            case "..":
	                return "I";
	            case ".---":
	                return "J";
	            case "-.-":
	                return "K";
	            case ".-..":
	                return "L";
	            case "--":
	                return "M";
	            case "-.":
	                return "N";
	            case "---":
	                return "O";
	            case ".--.":
	                return "P";
	            case "--.-":
	                return "Q";
	            case ".-.":
	                return "R";
	            case "...":
	                return "S";
	            case "-":
	                return "T";
	            case "..-":
	                return "U";
	            case "...-":
	                return "V";
	            case ".--":
	                return "W";
	            case "-..-":
	                return "X";
	            case "-.--":
	                return "Y";
	            case "--..":
	                return "Z";
	}
		return morseCode;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Reads in the string morse-code
		String text = input.nextLine();
		
		// split the morse by the space
		String[] result = text.split(" ");
		
		// loop through the array for each coded letter
		for (String str: result) {
			System.out.print(code(str));
			}
			
		}

		
//		 ArrayList<String> al = new ArrayList<String>();
//		 
//		String sentence = input.nextLine();
//		al.add(sentence);
//		System.out.print(al);
//		
//		
//		for(int i = 0; i < al.size(); ++i) {
//			System.out.print(al.get[i]);
//		}
		
		
		// System.out.println(code(sentence));
	}
		
	
