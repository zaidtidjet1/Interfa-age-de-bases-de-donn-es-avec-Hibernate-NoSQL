
package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import onetoone.Facture;
import onetoone.Commande;
import manytomany.Livraison;
import manytomany.Detaillivraison;
import onetomany.Client;
import onetomany.LigneDeCommande;
import onetomany.Article;



public class Main {

	public static void main(String[] args) {
		factureCommande();
		livaraisondetaillivraison();
		commandeClient();
		commandeligneCommande();
		articleligneDecommande();
		ligneDecommandeDetaillivraison();
		general();
		
	}
	
	public static void factureCommande() {
		
		Facture f1 = new Facture();
		f1.setIdClient(15);

		Commande c1 = new Commande();
		c1.setIdCommande(12);
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		

		
		f1.setCommande(c1);
		session.save(f1);
		session.save(c1);
		 
		session.getTransaction().commit();
		session.close();
		//sf.close();
}
	
public static void livaraisondetaillivraison() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Livraison l1 = new Livraison();
		l1.setDate("25/05/2023");
		
		Livraison l2 = new Livraison();
		l2.setDate("12/02/2023");


		Detaillivraison d1 = new Detaillivraison();
		d1.setQuantiteLivree(15);
		
		Detaillivraison d2 = new Detaillivraison();
		d2.setQuantiteLivree(20);
		
		session.save(d1);
		session.save(d2);
		
		Set<Detaillivraison> listeDetaillivraison = new HashSet<Detaillivraison>();
		listeDetaillivraison.add(d1);
		listeDetaillivraison.add(d2);
		
		l1.setDetaillivraison(listeDetaillivraison);
		l2.setDetaillivraison(listeDetaillivraison);
		
		session.save(l1);
		session.save(l2);
		 
		session.getTransaction().commit();
		session.close();
		//sf.close();
	}

public static void commandeClient() {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	Commande cm1 = new Commande();
	cm1.setDate("12/02/2023");
	session.save(cm1);
	
	Client cl1 = new Client();
	cl1.setNom("Toto");
	
	Client cl2 = new Client();
	cl2.setNom("Tata");

	cl1.setCommande(cm1);
	cl2.setCommande(cm1);
	
	session.save(cl1);
	session.save(cl2);
	 
	session.getTransaction().commit();
	session.close();
	//sf.close();
	
}
//
public static void commandeligneCommande() {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	Commande cm1 = new Commande();
	cm1.setDate("28/02/2023");
	session.save(cm1);
	
	LigneDeCommande lign1 = new LigneDeCommande();
	lign1.setQuantite(12);
	
	LigneDeCommande lign2 = new LigneDeCommande();
	lign2.setQuantite(14);

	lign1.setCommande(cm1);
	lign2.setCommande(cm1);
	
	session.save(lign1);
	session.save(lign2);
	 
	session.getTransaction().commit();
	session.close();
	//sf.close();
	
}
/////
public static void articleligneDecommande() {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	Article cm1 = new Article();
	cm1.setQuantite_disponible(14);
	session.save(cm1);
	
	LigneDeCommande lign1 = new LigneDeCommande();
	lign1.setQuantite(12);
	
	LigneDeCommande lign2 = new LigneDeCommande();
	lign2.setQuantite(14);

	lign1.setArticle(cm1);
	lign2.setArticle(cm1);
	
	session.save(lign1);
	session.save(lign2);
	 
	session.getTransaction().commit();
	session.close();
	//sf.close();
	
}
////
public static void ligneDecommandeDetaillivraison() {
	
	/*SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	Detaillivraison lign1 = new Detaillivraison();
	lign1.setIdCommande(14);
	session.save(lign1);
	
	LigneDeCommande Id1 = new LigneDeCommande();
	Id1.setQuantite(1);
	
	LigneDeCommande Id2 = new LigneDeCommande();
	Id1.setQuantite(2);

	Id1.setIdArt(lign1);
	Id2.setLigneCommande(lign1);
	
	session.save(Id1);
	session.save(Id2);
	 
	session.getTransaction().commit();
	session.close();
	//sf.close();*/
}
public static void general() {
	
	// Lire les enregistrements existants  
	System.out.println("******* Lecture *******");
	List<Client> clients = list();
	System.out.println("Total clients: " + clients.size());
	
	
	// Ajouter de nouveaux enregistrements 
	System.out.println("******* �criture *******");
	
	Client client = new Client(1, "yes", "418999999");
	
	Commande com = new Commande();
	com.setIdCommande(12);
	com.setDate("12/02/2022");
	com.setidClient(11);

	
	Set<Commande> listeCommandes = new HashSet<Commande>();
	listeCommandes.add(com);
	client.setListeCommandes(listeCommandes);
	
	client = save(client);
	client = read(client.getIdClient());
	System.out.printf("%d %s %s \n", client.getIdClient(), client.getNom(), client.getNom());
	
	// Mettre � jour
	System.out.println("******* Mettre � jour *******");
	Client client2 = read(1); // lire le client ayant un idClient = 1
	
	
	System.out.println("Prenom:" + client2.getNom());
	client2.setNom("allo");
	update(client2);	// sauvegarder les d�tails du client dans la basesave the updated employee details
	
	client2 = read(1); // lire de nouveau le client ayant un idClient = 1
	System.out.println("Prenom apres modification:" + client2.getNom());
	
	// Supprimer
	System.out.println("******* Supprimer *******");
	delete(client); 
	Client client3 = read(client.getIdClient());
	System.out.println("Objet:" + client3);
}





private static List<Client> list() {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();

	List<Client> clients = session.createQuery("from Client", onetomany.Client.class).list();
	 
	session.close();
	return clients;
}

/**
 * lire le client � partir de son idClient
 * @return Client2
 */
private static Client read(Integer idClient) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();

	Client client = (Client) session.get(Client.class, idClient);
	
	session.close();
	return client;
}

/**
 * enregistrer un objet de type Client
 * @return Client
 */
private static Client save(Client client) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();

	session.beginTransaction();
	
	Integer idClient = (Integer) session.save(client);
	
	client.setIdClient(idClient);
	 
	session.getTransaction().commit();
	
	session.close();
	return client;
}

/**
 * Mettre � jour un objet de type Client2
 * @return Client2
 */
private static Client update(Client client) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();

	session.beginTransaction();

	session.merge(client);
	
	session.getTransaction().commit();
	
	session.close();
	return client;

}

/**
 * Supprimer un objet de type Client2
 * @return void 
 */
private static void delete(Client client) {
	
	//Configuration conf = new Configuration().configure();
	//SessionFactory sf = conf.buildSessionFactory(new ServiceRegistryBuilder()
	//							.applySettings(conf.getProperties()).buildServiceRegistry());
	//Session session = sf.openSession();
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	
	session.beginTransaction();
	
	session.delete(client); 
	
	session.getTransaction().commit();

	
	session.close();
}


}
