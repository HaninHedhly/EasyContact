
public class main3 {

	public static void main(String[] args) {
	    ContactManager cm = new ContactManager();
	    if (cm.connect() != null) {
	        System.out.println("Connexion réussie !");
	    } else {
	        System.out.println("Échec de la connexion.");
	    }
	}


}
