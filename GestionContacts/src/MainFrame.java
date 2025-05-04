

import javax.swing.*; // Importation des composants Swing (fenêtres, boutons, labels...)
import java.awt.*;     // Importation des classes pour la gestion de l'affichage (Layout, Couleurs, Fonts, etc.)

// Classe principale de la fenêtre d’accueil de l’application
public class MainFrame extends JFrame {
	
	private ContactManager contactManager;


    // Constructeur de la fenêtre principale
    public MainFrame(ContactManager contactManager) {
    	 this.contactManager = contactManager;
        // Configuration de base de la fenêtre
        setTitle("Gestion des Contacts"); // Titre affiché dans la barre supérieure
        setSize(500, 400); // Dimensions de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l’application quand on ferme la fenêtre
        setLocationRelativeTo(null); // Centre la fenêtre à l’écran
        setLayout(new BorderLayout()); // Utilise un layout en "zones" (Nord, Sud, Centre, etc.)

        // Couleur de fond de la fenêtre (rose pastel)
        getContentPane().setBackground(new Color(255, 228, 235));

        // Création du titre principal
        JLabel titleLabel = new JLabel("Gestion des Contacts", JLabel.CENTER); // Label centré
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Police et taille
        titleLabel.setForeground(new Color(155, 89, 182)); // Couleur violette douce
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Marge autour du texte
        add(titleLabel, BorderLayout.NORTH); // Ajoute le titre en haut de la fenêtre (NORD)

        // Panel pour contenir les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 15, 15)); // Organisation en 3 lignes et 1 colonne avec espacement
        buttonPanel.setBackground(new Color(255, 228, 235)); // Même fond que la fenêtre

        // Création des boutons avec style personnalisé
        JButton addButton = styledBouton("Ajouter un contact", new Color(255, 192, 203)); // Rose clair
        JButton modifyButton = styledBouton("Modifier un contact", new Color(221, 160, 221)); // Violet clair
        JButton deleteButton = styledBouton("Supprimer un contact", new Color(255, 182, 193)); // Rose plus foncé

        // Ajout des actions aux boutons (ouvre une nouvelle fenêtre selon le bouton)
        addButton.addActionListener(e -> new AddContactFrame()); // Ouvre la fenêtre pour ajouter un contact
        modifyButton.addActionListener(e -> new ModifyContactFrame(contactManager, "", "", "", "").setVisible(true)
); // Ouvre celle pour modifier
        deleteButton.addActionListener(e -> new DeleteContactFrame()); // Ouvre celle pour supprimer

        // Ajout des boutons dans le panel
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);

        // Ajout du panel de boutons au centre de la fenêtre
        add(buttonPanel, BorderLayout.CENTER);

        // Rend la fenêtre visible
        setVisible(true);
    }

    // Méthode pour créer un bouton personnalisé avec texte et couleur
    private JButton styledBouton(String text, Color bgColor) {
        JButton button = new JButton(text); // Création du bouton
        button.setFont(new Font("Arial", Font.BOLD, 15)); // Style de police
        button.setBackground(bgColor); // Couleur de fond
        button.setForeground(Color.WHITE); // Couleur du texte
        button.setFocusPainted(false); // Retire le cadre par défaut du focus
        button.setBorder(BorderFactory.createLineBorder(new Color(155, 89, 182), 2)); // Bordure violette
        button.setPreferredSize(new Dimension(200, 50)); // Taille préférée
        return button; // Retourne le bouton prêt à être utilisé
    }
}
