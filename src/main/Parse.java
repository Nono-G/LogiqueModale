package main;

import exprs.*;

public class Parse {
	
	public static final int TAILLE_PILE = 150;
	/* OPERANDES
	 * NON !
	 * ET ^
	 * OU +
	 * IMPLIQUE >
	 * CARRE (NECESSITE) #
	 * (LOSANGE) *
	 */
	public static final char[] operandesStandard = {'!','^','+','>','#','*'};
	
	public static Expr parse(String str){
		return constr(infixeToPrefixe(str, operandesStandard));
	}
	
	public static void main (String[] args){
		System.out.println("D");
		String prefixe = infixeToPrefixe("(a^(a>b))>b", operandesStandard);
		System.out.println(prefixe);
		Expr ex = constr(prefixe);
		System.out.println(ex);
		System.out.println(ex.toStringInfixe());
		System.out.println("F");
	}
	
	public static String infixeToPrefixe(String infixe, char[] operandes){
		if(! correct(infixe)){
			throw new RuntimeException("incorrect");
		}
		char[] pref = new char[2*infixe.length()];
		int iPref = 0;
		char[] pile = new char[TAILLE_PILE];
		int iPile = 0;
		String infixeRev = reverse(infixe);
		int k = 0;
		while(k<infixeRev.length() /*&& iPile > 0*/) {
			char c = infixeRev.charAt(k);
			//
			if(c==')'){
				pile[iPile]='(';
				iPile++;
			}else if(c=='('){
				while(iPile > 0 && pile[iPile-1]!='('){
					pref[iPref] = pile[iPile-1];
					iPref++;
					iPile--;
				}
				if(iPile > 0){iPile--;}
			}else if(appartient(operandes, c)){
				while(iPile > 0 && appartient(operandes, pile[iPile-1])){
					pref[iPref] = pile[iPile-1];
					iPref++;
					iPile--;
				}
				pile[iPile]=c;
				iPile++;
			}else{
				pref[iPref] = c;
				iPref++;
			}
			//
			k++;
		}
		while(iPile > 0){
			pref[iPref] = pile[iPile-1];
			iPref++;
			iPile--;
		}
		String prefixe = new String(troncat(iPref,pref));
		return reverse(prefixe);
	}
	
	public static String reverse(String str){
		char[] chars = new char[str.length()];
		int i = str.length();
		while(i > 0){
			chars[i-1] = str.charAt(str.length()-i);
			i--;
		}
		return (new String(chars));
	}
	
	public static boolean appartient(char[] t, char c){
		int i = 0;
		while(i < t.length && t[i] != c){i++;}
		return (i!=t.length);
	}
	
	/*public <N> N[] troncat(int s, N[] t){
		if(s > t.length){throw new RuntimeException("Err troncat");}
		int i = 0;
		N[] r = (N[]) new Object[s];
		while(i < s){
			r[i] = t[i];
			i++;
		}
		return r;
	}*/
	
	public static char[] troncat(int s, char[] t){
		if(s > t.length){throw new RuntimeException("Err troncat");}
		int i = 0;
		char[] r = new char[s];
		while(i < s){
			r[i] = t[i];
			i++;
		}
		return r;
	}
	
	public static boolean correct(String expr){
		return true;
	}
	
	public static Expr constr(String expr){
		ConstrRet c = constr0(expr, 0);
		return c.e;
	}
	
	private static ConstrRet constr0(String expr, int d){
		char c = expr.charAt(d);
		Expr e;
		int nd;
		ConstrRet cr;
		switch(c){
		case '!': //NON
			e = new NonExpr();
			cr = constr0(expr, d+1);
			((Op1Expr)e).membre = cr.e;
			nd = 1+cr.n;
			break;
		case '^': // ET
			e = new EtExpr();
			cr = constr0(expr, d+1);
			((Op2Expr)e).membre1 = cr.e;
			nd = 1+cr.n;
			cr = constr0(expr, d+cr.n+1);
			((Op2Expr)e).membre2 = cr.e;
			nd+= cr.n;
			break;
		case '+': //OU
			e = new OuExpr();
			cr = constr0(expr, d+1);
			((Op2Expr)e).membre1 = cr.e;
			nd = 1+cr.n;
			cr = constr0(expr, d+cr.n+1);
			((Op2Expr)e).membre2 = cr.e;
			nd+= cr.n;
			break;
		case '>': //IMPLIQUE
			e = new ImplExpr();
			cr = constr0(expr, d+1);
			((Op2Expr)e).membre1 = cr.e;
			nd = 1+cr.n;
			cr = constr0(expr, d+cr.n+1);
			((Op2Expr)e).membre2 = cr.e;
			nd+= cr.n;
			break;
		case '#': //CARRE
			e = new CarreExpr();
			cr = constr0(expr, d+1);
			((Op1Expr)e).membre = cr.e;
			nd = 1+cr.n;
			break;
		case '*': //LOSANGE
			e = new LosangeExpr();
			cr = constr0(expr, d+1);
			((Op1Expr)e).membre = cr.e;
			nd = 1+cr.n;
			break;
		default : //VAR
			e = new Var();
			((Var)e).nom = ""+c;
			nd = 1;
			break;
		}
		return new ConstrRet(nd,e);
		/* OPERANDES
		 * NON !
		 * ET ^
		 * OU +
		 * IMPLIQUE >
		 * CARRE (NECESSITE) #
		 * (LOSANGE) *
		 */
	}

}
