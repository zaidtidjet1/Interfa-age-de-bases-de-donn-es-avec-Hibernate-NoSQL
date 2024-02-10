
package onetoone;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import onetomany.Client;
import onetomany.LigneDeCommande;

public class Commande {
	
	// one to many avec la classe client
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	@JoinColumn(name="idClient")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Collection<Client> clients = new ArrayList<Client>();
	
	
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	// one to many avec l'entity ligne de commande
	
	// one to many avec la classe client
		@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
		@JoinColumn(name="idClient")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private Collection<LigneDeCommande> lignesCommandes = new ArrayList<LigneDeCommande>();
		
		
		public Collection<LigneDeCommande> getLignesCommandes() {
			return lignesCommandes;
		}
		public void setLignesCommandes(Collection<LigneDeCommande> lignesCommandes) {
			this.lignesCommandes = lignesCommandes;
		}
	
	// one to one avec la classe facture

	@Id
	@GeneratedValue
	@Column(name ="idCommande")
	private int idCommande;
	
	private String date;
	private int idClient;

	@OneToOne(mappedBy="facture")
	private Facture facture;
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setidClient(int idClient) {
		this.idClient = idClient;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture Facture) {
		this.facture = facture;
	}

}
