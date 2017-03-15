package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Steps {

	public static void main(String[] args) {
	int n=15;
	ArrayList<Integer> Num=new ArrayList<Integer>();
	//int[] Num=null;
	int[] J={2,3,4};
	for(int i=1;i<1112;i++){
		Num.add(i);
	}
	int i=0;
	while(i<J.length){
		int j=J[i]-1;
		while(j<Num.size()){
			if(Num.get(j)==n){
				System.out.println(n+" dies for " +J[i]);
				break;
			}
			else{
				
				Num.remove(j);
				j=j+J[i]-1;
			}
		}
		if(j<Num.size())
			break;
		i++;
	}
	if(i==J.length){
		System.out.println("It survived");
	}
	}
}