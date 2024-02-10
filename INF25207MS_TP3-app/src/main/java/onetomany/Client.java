package onetomany;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.GenericGenerator;
import onetoone.Commande;
import onetoone.Facture;

 



@Entity
public class Client {
	
	@CollectionId(columns={@Column(name="id_Commande")}, generator = "adresse_generator", type=@Type(type="long"))
	private Collection<Commande> listeCommandes = new ArrayList<Commande>();
	
	public Collection<Commande> getListCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(Collection<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}
	
	
	

	@Id 
	@GeneratedValue
	@Column(name = "idClient")
	private Integer idClient;

	@Column(name = "nom")
	private String nom;

	@Column(name = "tel")
	private String tel;

	@Column(name = "tel")
	private String phoneNumber;
 
	@ManyToOne
	
	private Commande commande;
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	//

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
		}
	
	public Client() {

	} 

	public Client(Integer idClient, String nom, String tel) {
		this.idClient   = idClient;
		this.nom    = nom;
		this.tel = tel;
	}

	

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	

	
	
	//Many to one avec facture
	@ManyToOne
	private Facture facture;
	public Facture getFacture() {
		return facture;
		
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	///
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	//
	
	
	
	

}


