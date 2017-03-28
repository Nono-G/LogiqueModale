package demonstrateur;

public class Monde {

	public String nom;
	
	@Override
	public boolean equals(Object o){
		return (o instanceof Monde)&&(((Monde)o).nom.equals(this.nom));
		
	}
}


