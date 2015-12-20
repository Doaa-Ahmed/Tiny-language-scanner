import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
public class Scan {
	public static void main (String args[]) throws IOException{
		File testFile = new File("testCode.txt") ;
		
		 //Scanner in = new Scanner (testFile);
		@SuppressWarnings("resource")
		FileInputStream q = new FileInputStream (testFile) ;
		byte [] in = new byte [q.available()] ;
		q.read(in, 0, in.length) ;
		/*
		for(int i = 0 ; i < in.length ; i++){
			System.out.println((char)in[i]);
		}
		*/
		// state 1 is START               state 2 is INCOMMENT
		// state 3 is INNUM               state 4 is INID
		// state 5 is INASSIGN            state 6 is DONE
		System.out.println ("Enter your string");
		//String x=in.nextLine();
		//String x = in.next() ; // this is better because the code generating
		int i= in.length;// variable that tells me how many characters remain in the string
		int j=0; // variable that goes through the string
		String y=null, k=null;
		char w ;// x.charAt(j);
		//System.out.print(i);
		
		
		int state=1;
		char [] realData = new char [in.length] ;
		for(int i1 = 0 ; i1 < in.length ; i1++){
			realData[i1] = (char)in[i1] ;
		}
		j = 0 ;
		Vector <Character> token = new Vector <Character> () ;
		while (j < realData.length ){
			w = realData[j] ;
			switch (state){
			
			case 1:
				System.out.println("State one");
				if(w == ' ' ){
					state = 1 ;
					break ;
				}
				else if(w == '{'){
					state = 2 ;
					break ;
				}
				else if(Character.isDigit(w)){
					state = 3 ;
					token.add(w) ;
					break ;
				}
				else if(Character.isLetter(w)){
					state = 4 ;
					token.add(w) ;
					break ;
				}
				else if(w == ':' || w == '='){
					state = 5 ; 
					token.add(w) ;
					break ;
				}
				else{
					state = 6 ;
					break ;
				}
				/******************/
		
			case 2 :
				System.out.println("State two");
				if(w == '}'){
					state = 1 ;
					break ;
				}
				else{
					state = 2 ;
					break ;
				}
				/*******************/
		
			case 3 :
				System.out.println("State three");
				if(Character.isDigit(w)){
					state = 3 ;
					token.add(w) ;
					break ;
					
				}
				else{
					state = 6 ;
					//j-- ;
					break ;
				}
				/*******************/
			case 4 :
				System.out.println("State four");
				if(Character.isLetter(w)){
					state = 4 ;
					token.add(w) ;
					break ;
				}
				else{
					state = 6 ;
					//j-- ;
					break ;
				}
				/*******************/
			case 5 :
				System.out.println("State five");
				if(w == '='){
					token.add(w) ;
					state = 5 ;
					
					break ;
				}
				else{
					//j-- ;
					break ;
				}
				/*******************/
			case 6 :
				System.out.println("State six");
				System.out.println(token);
				state = 1 ;
				j-=2 ;
				//token.clear();
				break ;
			}
			j++ ;
		}
		/*
		while (i != 0){ // ممكن احسن يعني انك تخلي كده j < x.length() ;
			// نصيحه صغيره بلاش != خليها احسن i >= 0
			System.out.print("hi");
			//
			w= x.charAt(j);
			//
			switch (state){
			case 1: 
				System.out.println("State one");
				if (w== ' ')
				{
					state=1;
					i--;
					j++;
					break;
				}
			     else if (w== '{') {
			    	 state=2;
			    	 i--; 
			    	 j++;
			    	 break;
			    }
	        	else if (w==':') {state=5;
	        	i--;
	        	j++; 
	        	
	        	break;}
			else if (Character.isDigit(w))
			{state=3;
     			break;}
     			else if (Character.isLetter(w))
     			{state=4;
     				break;
     			}
		
			
			/***********/
/*
			case 2:
				System.out.println("state 2");
			if (w=='}') {state=1;
			i--; 
			j++; 
			break;}
			else {state=2;i--; j++; break;}
			/************/
/*			
			case 3: 
				System.out.println("state three");
				while (x.charAt(j)!= ' '){
			
				y+=in.next().charAt(j);
				i--;
				j++;
			}
			System.out.println (y + " is a number");
			break;
				
				/*************/
/*
		case 4:
				System.out.println("state four");
				while (x.charAt(j)!= ' '){
			k+=	x.charAt(j);
			i--;
				j++;
			}
			System.out.println(k+ " is an identifier");
			/**************/	
/*
		case 5:
				System.out.println("state five");
				if (w== '=')
			{ i--;
			j++;
			System.out.println("="+ "is assignment");
				break;}
		/*************/
/*
			default:
				break;
			
			}
		}
*/
		}
}
