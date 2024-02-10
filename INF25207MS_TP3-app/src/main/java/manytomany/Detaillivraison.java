package manytomany;

import java.util.ArrayList;
import onetomany.LigneDeCommande;
import java.util.Collection;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity 
public class Detaillivraison {
	
	@Id
	@GeneratedValue
	private int idLivraison;
	private int idArticle;
	private int idCommande;
	private int quantite_livree;
	 
	
  
	@ManyToMany(mappedBy = "detaillivarisons", cascade=CascadeType.ALL)  
	private Collection<Livraison> livraison = new ArrayList<Livraison>();
	
	public int getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}
	
	///
	// one to many avec LigneDeCommande
	@OneToMany(mappedBy="ligneCommandes", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<LigneDeCommande> ligneC = new ArrayList<LigneDeCommande>();
	
	
	
//
	
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	//
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	//
	public int getQuantiteLivree() {
		return quantite_livree;
	}
	public void setQuantiteLivree(int quantite_livree) {
		this.quantite_livree = quantite_livree;
	}
	//
	

	public Collection<Livraison> getLivraison() {
		return livraison;
	}
	public void setLivraison(Collection<Livraison> livraison) {
		this.livraison = livraison;
	}

}
