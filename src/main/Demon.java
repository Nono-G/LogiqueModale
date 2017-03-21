package main;

public class Demon {

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
}
