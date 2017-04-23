package main;

import exprs.*;
import demonstrateur.*;
import regles.Systeme;

public class Main {

/* OPERANDES
 * NON !
 * ET ^
 * OU +
 * IMPLIQUE >
 * CARRE (NECESSITE) #
 * (LOSANGE) *
 */
	public static void main(String[] args) {
		//Expr e = Parse.parse(args[1]);
		//Expr e = Parse.parse("(((!(!(a)))^(!(a)))+((!(!(b)))^(!(b))))");
		//Expr e = Parse.parse("((!(a))^(!(a+b)))");
		//Expr e = Parse.parse("(!((b+(!(a)))^(!(a>b))))");
		//Expr e = Parse.parse("((!(a^b))^(a^b))");
		//Expr e = Parse.parse("((!(#(a)))^(!(#(!(a)))))");
		//Expr e = Parse.parse("((!(#(a)))^(#(a)))");
		//Expr e = Parse.parse("((#(a))^(!(#(a))))");
		//Expr e = Parse.parse("(!((!(b))^(b>a)))");
		//Expr e = Parse.parse("(!(((#(((!(q))+r)^(s^t)))>(#(#((*((!(q))+r))>(*(s^t))))))))");//EXAM
		//Expr e = Parse.parse("(*(a))");
		Expr e = Parse.parse("((a)^(#(!(a))))");
		System.out.println(e);
		Tableau t = new Tableau();
		AssertionSat a = new AssertionSat(new Monde(), e);
		t.ajouter(a);
		System.out.println(t);
		Demon sysT = new Demon(Systeme.T, true);
		boolean sat = sysT.sat(t);
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
