public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        // 🔹 Ajout de contacts avec 4 paramètres (nom, prénom, email, téléphone)
        Contact contact1 = new Contact("hanin", "hedhli", "hanin@gmail.com", "123456789");
        Contact contact2 = new Contact("sabrin", "Soussi", "ella@gmail.com", "987654321");

        manager.addContact(contact1);
        manager.addContact(contact2);

        // 🔹 Affichage des contacts après ajout
        System.out.println("📌 Contacts après ajout :");
        for (Contact c : manager.getContacts()) {
            System.out.println(c);
        }
        
        
    }
}

