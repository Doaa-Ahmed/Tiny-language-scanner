	import java.util.Scanner;

public class Scannerr {

		public static void main (String[] args){
		
		String token="";
		int state=1;
		String input="(yossra) x=1 y=2 ggg=11111+2 nnooo+o(yossra)";
	Character in ;
		
		int i=0;
		while(i<input.length()){
			
		 in =input.charAt(i);
			
			
			switch (in){
			
			case ' ': state=1 ;
			break;
			case '(': state =5;break; 
			case ')': state =6;break;
			case '0': case '1': case '2': case '3': case '4': 
			case '5': case '6': case '7': case '8': case '9':  state=2;break; 
			case 'a': case 'b':case 'c':case 'd':case 'e':case 'f':case 'g':case 'h':case 'i':case 'j':case 'k':case 'l':case 'm':case 'n':case 'o':case 'p':case 'q':case 'r':case 's':case 't':case 'u':case 'v':case 'w':case 'x':
			case 'y':case 'z': state=3;break;
			case '+': case '-':case '*':case '=': state =4;break;
			
			}
			
			
			switch (state){
			
			case 1:
				i++;
				break;
			case 3:
	        while(Character.isLetter(in))
	        
			{  
		    	 token+=in;
	             i++;
	             if(i<input.length())
	       { 
	        in=input.charAt(i);}
		     }
	         System.out.println("identifier\t"+token);
	         token="";
		     break;
	    	 
	    	 
	    case 2:
	        while(Character.isDigit(in))
	    {
	   	 token+=in;
	        i++;
	        if(i<input.length())
	       { 
	        in=input.charAt(i);
	        }}
	        
	        System.out.println("number     \t"+token);
	        token="";
	    break;
	    case 4:
	        token+=in;
	        i++;
	        System.out.println("assigment     \t"+token);
	        token="";
	          break;
	    case 5:
	        while(in!=')')	
	   { token+=in;
	       i++;
	    if(i<input.length())
	       { 
	        in=input.charAt(i);}
	        
	   }
	   token+=in;
	   System.out.println("comment   \t"+token);
	   token=" ";
			break;
			
	   case 6:i++; 
	         break;
			}}

		}}



