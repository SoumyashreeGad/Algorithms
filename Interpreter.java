package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;

public class Interpreter {
	public static Token currentToken;
	
	public static void main(String[] args) throws IOException{
		InputStreamReader in= new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(in);
		MoveToNext(input);
		Parser(input);
	}

	public static void Parser(BufferedReader input){
		BinaryTree bt = null;
		do { 
			if(currentToken.type==5){
				MoveToNext(input);
			}
			bt = Expr(input,bt);
			if(bt == null){
				break;
			}
			printBinaryTree(bt);
			System.out.println();
			if(currentToken.type==5){
				MoveToNext(input);
			}
		} while (currentToken.type != 6); 
		
	}
	
	public static BinaryTree  Expr(BufferedReader input,BinaryTree bt){
		bt= new BinaryTree("--", null, null);
		BinaryTree temp = bt;
		if (currentToken.type==6) { 										// consume whitespace
			System.out.println("ERROR: Empty Statement");
			return null;
		}
		if (currentToken.type==5) { 										// consume whitespace
			MoveToNext(input); 
		}
		if (Arrays.asList(1,2).contains(currentToken.type)) { 				// consume atom
			temp.value=currentToken.name;	
			MoveToNext(input); 
		}else if (currentToken.type==3 ) {
			MoveToNext(input); 												// consume open parenthesis
			if (currentToken.type==5) { 									// consume whitespace
				MoveToNext(input); 
			}
			while (currentToken.type!=4) { 
				if (currentToken.type==5) { 								// consume whitespace
					MoveToNext(input); 
				}else if (currentToken.type==6) { 									// consume whitespace
					System.out.println("ERROR: no ending ')' for '(' ") ;
					//MoveToNext(input);
					return null;
				}else{
					temp.leftChild = Expr(input,null); 
					temp.rightChild = new BinaryTree("--", null, null);
					temp = temp.rightChild;
				}
			}
			temp.value="NIL";
			MoveToNext(input); 												// consume closing parenthesis			
		} else { 
			System.out.println("ERROR: no starting '(' for ')' ") ;
			MoveToNext(input);
			bt = null;
		} 
		return bt;
	}
	
	static Token  GetCurrent() { 
		return currentToken; 
	}
	
	static void  MoveToNext(BufferedReader input) { 
		currentToken = getNextToken(input); 
		//System.out.println(currentToken.name);
	} 

	public static Token getNextToken(BufferedReader input) {
		int c = 0;	
		try{	
			if(!input.ready()){
				return new Token("EOF",6);
			}
			input.mark(0);
			c = input.read();
			if(c == 10 || c==32 || c==13 ){		
				do{
					input.mark(0);
					if(input.ready()){
						c = input.read();
					}else{
						c = 11;
					}
				}while(c == 10 || c==32 || c==13 );
				input.reset();
				return new Token(" ",5);
			}else if (c==40){
				return new Token("(",3);
			}else if(c==41){
				return new Token(")",4);
			}else if(c>=65&&c<=90){
				String res = "";
				do{
					res += (char)c;
					input.mark(0);
					if(input.ready()){
						c = input.read(); 
					}else{
						c=11;
					}
				}while((c>=65&&c<=90)||(c>=48&c<=57));
				input.reset();
				return new Token(res,1);
			}else if(c>=48&&c<=57){
				String res = "";
				do{
					res += (char)c;
					input.mark(0);
					if(input.ready()){
						c = input.read(); 
					}else{
						c=11;
					}
				}while(c>=48&c<=57);
				input.reset();
				input.mark(0);
				if(input.ready()){
					c = input.read();
					if(c>=65&&c<=90){
						do{
							res += (char)c;
							input.mark(0);
							if(input.ready()){
								c = input.read(); 
							}else{
								c=11;
							}
						}while((c>=65&&c<=90)||(c>=48&c<=57));
						input.reset();
						System.out.println("ERROR: Invalid token " + res);
						System.exit(1);
						return new Token(res,7);
					}else{
						input.reset();
					}
				}
				return new Token(res,2);
			}
		}catch (Exception e){
			System.out.println("error in program");
		}
		return new Token(" ",8);
	}
	
	public static void printBinaryTree(BinaryTree bt){
		if(bt==null){
			
		}else if(bt.leftChild==null && bt.rightChild==null){
			System.out.print(bt.value);
		}else{
			System.out.print("(");
			printBinaryTree(bt.leftChild);
			System.out.print(" . ");
			printBinaryTree(bt.rightChild);
			System.out.print(")");
		}
	}
}

