package manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Livraison {
	
	@Id
	@GeneratedValue
	private int idLivraison;
	 
	private String date;

	@ManyToMany

				
	private Collection<Detaillivraison> detaillivraison = new ArrayList<Detaillivraison>();
	
	public int getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Collection<Detaillivraison> getDetaillivraison() {
		return detaillivraison;
	}
	public void setDetaillivraison(Collection<Detaillivraison> detaillivraison) {
		this.detaillivraison = detaillivraison;
	}
	
	

}
