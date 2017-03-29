package demonstrateur;

public class Monde {

	private static int imonde = 0;
	private int id;
	
	
	public String nom;
	
	@Override
	public boolean equals(Object o){
		return (o instanceof Monde)&&(((Monde)o).nom.equals(this.nom));
	}
	
	public String toString(){
		return this.nom;
	}
	
	public Monde(){
		this.id = imonde;
		imonde++;
		this.nom = "X"+id;
	}
}


