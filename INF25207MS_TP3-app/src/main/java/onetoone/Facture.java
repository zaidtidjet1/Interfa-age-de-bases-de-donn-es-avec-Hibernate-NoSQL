package onetoone;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import onetomany.Client;

@Entity
public class Facture {
	
	@Id
	@GeneratedValue
	private int idFacture;
	private double total;
	private int idClient;

	@OneToOne
	@JoinColumn(name="idFacture")
	private Commande commande;
	
	// one to many avec Client
	
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
	
	public int getIdCommande() {
		return idFacture;
	}
	public void setIdCommande(int idFacture) {
		this.idFacture = idFacture;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient ) {
		this.idClient = idClient;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	

}
