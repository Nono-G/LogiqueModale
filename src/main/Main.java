package main;

import exprs.*;
import demonstrateur.*;

public class Main {

	public static void main(String[] args) {
		//Expr e = Parse.parse(args[1]);
		Expr e = Parse.parse("(((!(!(a)))^(!(a)))+((!(!(b)))^(!(b))))");
		System.out.println(e);
		Tableau t = new Tableau();
		AssertionSat a = new AssertionSat(new Monde(), e);
		t.ajouter(a);
		System.out.println(t);
		boolean sat = Demon.sat(t);
		System.out.println(sat);
	}
	
	/*
	public static void main(String[] args) {
		String infixeExpr = args[0];
		infixeExpr = infixeExpr.replace(" ","");
		if(count(infixeExpr,'(') != count(infixeExpr,')')){
			System.out.println("ERR : Parenthèses déséquilibrées");
			return;
		}else{
			System.out.println("OK : Parenthèses équilibrées");
		}
		
	}
	
	public static int count (String str, char c){
		int res = 0;
		int i = 0;
		while(i<str.length()){
			if(str.charAt(i)== c){
				res++;
			}
			i++;
		}
		return res;
	}
	*/

}
