package cap.programs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class StringPrograms {

	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		StringPrograms test=new StringPrograms();
	
		outer:while (true) {
			System.out.println("Enter your choice: \n 1.Prime Fraction of a number \n 2.String in alphabetical manner"
					+ " \n 3.Capitalize String \n 4.Replace and capitalize vowels \n 5.Reverse string\n 6.First Factorial\n 7.Longest word"
					+ "\n 8.Anagram \n 9.exit ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
			{
				System.out.println("enter number");
				int number = sc.nextInt();
			     
			      for(int i = 2; i< number; i++) {
			         while(number%i == 0) {
			            System.out.println(i+" ");
			            number = number/i;
			         }
			      }
			      if(number >2) {
			         System.out.println(number);
			      }
			      break;
			}
			case 2:{
				System.out.println("enter the string to sort");
				String str=sc.next();
				String s1=test.AlphabetSoup(str);
				System.out.println("sorted string "+s1);
			//	System.out.println("sorted string "+test.AlphabetSoup(str));
				break;
			}
			case 3:
				{
					System.out.println("enter the string to capitalize");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuffer sb=new StringBuffer();
			String str="";
			while((str = br.readLine())!= null){
		         sb.append(str);
		      }
			System.out.println(sb.toString());
			//String s1=test.LetterCapitalize(sb.toString());
			//System.out.println("capitalize string "+s1);
			System.out.println("capitalize string "+test.LetterCapitalize(sb.toString()));
			break;
	}
			case 4:{
				System.out.println("enter the string to replace and capitalize vowels");
				String str=sc.next();
				System.out.println("Letter Change "+test.LetterChanges(str));
				break;
			}
			case 5:{
				System.out.println("enter the string to reverse");
				String str=sc.next();
				System.out.println("Reverse order "+test.ReverseOrder(str));
				break;
			}
			case 6:{
				System.out.println("enter number");
				int factorialnumber=sc.nextInt();
				System.out.println("Factorial number  "+test.FirstFactorial(factorialnumber));
				break;
			}
			case 7:{
				System.out.println("enter the string");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringBuffer sb=new StringBuffer();
				String str="";
				while((str = br.readLine())!= null){
			         sb.append(str);
			      }
				System.out.println("Longest word  "+test.LongestWord(sb.toString()));
				break;
			}
			case 8:
			{
				System.out.println("enter anagram first string");
				String first=sc.next();
				System.out.println("enter anagram second string");
				String second=sc.next();
				char firstarray[]=first.toCharArray();
				char secondarray[]=second.toCharArray();
				Arrays.sort(firstarray);
				Arrays.sort(secondarray);
				String sortFirst=new String(firstarray);
				String sortSecond=new String(secondarray);
				if(sortFirst.equalsIgnoreCase(sortSecond))
				{
					System.out.println("Strings are anagram");
				}
				else {
						System.out.println("Strings are not an anagram");	
				}
			break;

			}
			case 9:
				System.out.println("Thank you visit again");
				break outer;
			}
	}
	}
	
	String  AlphabetSoup(String str) {
		char sortingArray[]=str.toCharArray();
		Arrays.sort(sortingArray);
		return new String(sortingArray);
	}
	String LetterCapitalize(String str) {
		String capitalize="";
		String capitalizeArray[]=str.split(" ");
		for(String s:capitalizeArray) {
			 String first=s.substring(0,1);  
		        String afterfirst=s.substring(1).toLowerCase();  
		        capitalize+=first.toUpperCase()+afterfirst+" "; 
		}
		return capitalize;
	}
	String  LetterChanges(String str) {
		char temp[]=str.toCharArray();
		String str1;

		for(int i=0;i<temp.length;i++) {
			if(temp[i]=='z') {
				temp[i]='a';
			}
			else {
				temp[i]=++temp[i];
			}
		}
		str1=new String(temp);
		str1=str1.replace('a','A');
		str1=str1.replace('e','E');
		str1=str1.replace('i','I');
		str1=str1.replace('o','O');
		str1=str1.replace('u','U');
		return str1;
	}
	String  ReverseOrder(String str) {
		StringBuffer sb=new StringBuffer(str);
		return sb.reverse().toString();
	}
	
	int FirstFactorial(int num) {
		int temp=1;
		if(num>=1 && num<=18) {
		 for(int i=1;i<=num;i++){    
			 temp=temp*i;    
		  }   
		}
		else {
			return 0;
		}
		 return temp;
	}
	String  LongestWord(String sentence) {
		int length=0;
		int index=0;
//		System.out.println(sentence);
		String demo[]=sentence.split(" ");
		for(int i=0;i<demo.length;i++) {
			if(demo[i].length()>length)
			{
				length=demo[i].length();
				index=i;	
			}
		}
		System.out.println(index);
		return demo[index];
	}
}