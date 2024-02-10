package onetomany;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import onetoone.Commande;

@Entity
public class LigneDeCommande {
	private Commande commande;
	
	@Id
	@GeneratedValue
	private int quantite;
	@JoinColumn(name="idLivraison")
	
	@JoinColumn(name="idCommande")

	@OneToMany(mappedBy="commande", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Commande> commandess = new ArrayList<Commande>();
	
	// Many to one avec Article
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	public Article getArticle() {
		return article;}
	public void setArticle(Article article) {
		this.article = article;
	}
	//
	// Many to one avec detaillivraison
	@ManyToOne
	
	private LigneDeCommande ligneCommande;
	
	public LigneDeCommande getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(LigneDeCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	////
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;}
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	//
	
		
		
	
	

	
	
	

}
