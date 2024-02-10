package onetomany;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import hibernate_validator.NumSerieValide;

@Entity
public class Article   {
	@NumSerieValide
	private String numSerie;
	
	
	
	@Id
	@GeneratedValue
	private int idArticle;
	
	private String description;
	private int quantite_disponible;
	private float prix_unitaire;

	@OneToMany(mappedBy="departement", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<LigneDeCommande> ligneC = new ArrayList<LigneDeCommande>();
	
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//
	public int getQuantite_disponible() {
		return quantite_disponible;
	}
	public void setQuantite_disponible(int quantite_disponible) {
		this.quantite_disponible = quantite_disponible;
	}
	//
	public float getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	//
	public Collection<LigneDeCommande> getLignesCommandes() {
		return ligneC;
	}
	public void setLignesCommandes(Collection<LigneDeCommande> ligneC) {
		this.ligneC = ligneC;
	}

}
