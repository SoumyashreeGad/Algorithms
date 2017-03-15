package basic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.portable.InputStream;

class main {
	public File file;
	public static String line="";
	static String token;
	public static String Literal="";
	static int Numeric=0;
	public static int pointer=0;
	
	public static void main(String args[]) throws IOException{
		int Num_cnt=0,Lit_cnt=0,Open_cnt=0,Closing_cnt=0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String wholestr="";
		StringBuilder wholest=new StringBuilder();
		while((line = reader.readLine()) != null){
			wholest.append(line);
		}
		wholestr=wholest.toString();
	while((token=getNextToken(wholestr))!="EOF"){
		switch(token){
		case "OpenParenthesis":Open_cnt++;		
		break;
		case "ClosingParenthesis":Closing_cnt++;
		break;
		case "literalVal":Lit_cnt++;
		break;
		case "numericVal":Num_cnt++;
		break;
		default:
			break;
		}		
	}
	System.out.println("Literal Atoms: " + Lit_cnt+Literal);
	System.out.println("Numeric Atoms: " + Num_cnt+","+Numeric);
	System.out.println("Open Paranthesis: " + Open_cnt);
	System.out.println("Closing Paranthesis: " + Closing_cnt);
	/*FileWriter fw=new FileWriter(args[1]);
	BufferedWriter out = new BufferedWriter(fw);
	
	out.write("Literal Atoms: "+Lit_cnt+Literal);
	out.newLine();
	out.write("Numeric Atoms: " + Num_cnt+","+Numeric);
	out.newLine();
	out.write("Open Paranthesis: " + Open_cnt);
	out.newLine();
	out.write("Closing Paranthesis: " + Closing_cnt);
	out.newLine();
	out.close();*/
	}
	static String getNextToken(String tempchar) {
		try {
			
			//String tempchar;
			//System.out.println("I am here");
			//tempchar = reader.readLine();
			//int i=0;
			char[] tempchararray=tempchar.toCharArray();
			int lengthofarr=tempchararray.length;
			//System.out.println("I am here");
			while(pointer!=lengthofarr){
			if(tempchararray[pointer] == -1) {
				//System.out.println("EOF");
				return "EOF";
			}
			else if(tempchararray[pointer] == '\n') {
				//System.out.println("EOL");
				pointer++;
				return "EOL";
			}
			else if(tempchararray[pointer] == '\r') {
		//		System.out.println("Carriage Return");
				pointer++;
				return "CarriageReturn";
			}
			else if(tempchararray[pointer] == '(') {
				//return "("; //OpenParenthesis";
			//	System.out.println("Opening Parenthesis");
				pointer++;
				return "OpenParenthesis";
			}
			else if(tempchararray[pointer] == ')') {
				//return ")"; 
				//System.out.println("Closing Parenthesis");
				pointer++;
				return"ClosingParenthesis";
			}
			
			else if(tempchararray[pointer] >= 'A' && tempchararray[pointer] <= 'Z') {
				String literalVal = new String();
				while((tempchararray[pointer] >= 'A' && tempchararray[pointer] <= 'Z') || (tempchararray[pointer] >= '0' && tempchararray[pointer] <='9')) {
					//reader.mark(32);
					literalVal += tempchararray[pointer];
					//tempchararray = reader.read();
					pointer++;
				}
				Literal+=","+literalVal;
			//	System.out.println(Literal);
				//System.in.reset();
				return "literalVal";
			}
			else if(tempchararray[pointer] >= '0' && tempchararray[pointer] <= '9') {
				String numericVal = new String();
				while(tempchararray[pointer] >= '0' && tempchararray[pointer] <='9') {
					//reader.mark(32);
					numericVal += tempchararray[pointer];
					//tempchararray = reader.read();
						//System.out.println(numericVal);
						pointer++;
					if(tempchararray[pointer] > '9') {
						System.out.println(numericVal);
						System.out.println("Invalid Token: " + numericVal + tempchararray[pointer]);
						System.exit(1);
					}
					
				}
				Numeric+=Integer.parseInt(numericVal);
				//reader.reset();
				return "numericVal";
			} 
			else if(tempchararray[pointer] == ' ') {
				while(tempchararray[pointer] == ' ') {
					//reader.mark(32);
					//tempchararray = reader.read();
					pointer++;
				}			
				//reader.reset();
				//return getNextToken(tempchar);
				//pointer++;
			}
			else {
				System.out.println("Invalid Input: " + (tempchararray[pointer]));
				System.exit(1);
			}
			}
			return "EOF";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERR";
	}


}
