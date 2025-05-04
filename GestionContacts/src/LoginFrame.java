
import javax.swing.*;   // Importation des composants Swing pour créer l'interface graphique
import java.awt.*;      // Importation des classes pour la gestion des couleurs, polices, etc
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Pour gérer les événements (clic sur bouton)

public class LoginFrame extends JFrame {  // Création  classe LoginFrame qui hérite de JFrame (fenêtre principale)

    private JTextField userField; // taper le nom d'user
    private JPasswordField passField; // taper

    public LoginFrame() {
        setTitle("Authentification"); // Titre de la fenêtre
        setSize(400, 250); // Taille 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application si on clique sur "X"
        setLocationRelativeTo(null); // position : centre
        setLayout(null); // I put les coordonnées comme je veux

        // Couleur de fond principale rose clair
        getContentPane().setBackground(new Color(255, 228, 232)); 
        
        

        // Label Utilisateur
        JLabel userLabel = new JLabel("Utilisateur:");
        userLabel.setBounds(50, 30, 100, 30); // positionnement de label
        userLabel.setForeground(new Color(130, 70, 110)); // Violet doux
        userLabel.setFont(new Font("Serif", Font.BOLD, 15)); // Police 
        add(userLabel); // Ajouter à la fenêtre
        
        
        

        // Champ utilisateur 
        userField = new JTextField();
        userField.setBounds(150, 30, 160, 30); // Positionnement de champ texte
        userField.setBackground(new Color(255, 240, 245)); // Couleur de fond beige rosé, douce et féminine
        userField.setForeground(new Color(80, 50, 70)); // Texte foncé 
        add(userField); // Ajouter le champ de texte à la fenêtre

        
        
        // Label Mot de passe
        JLabel passLabel = new JLabel("Mot de passe:");
        passLabel.setBounds(50, 80, 100, 30); // positionnement de label
        passLabel.setForeground(new Color(130, 70, 110)); // Violet 
        passLabel.setFont(new Font("Serif", Font.BOLD, 15)); // Police 
        add(passLabel); // Ajouter  à la fenêtre
        

        
        
        // Champ mot de passe 
        passField = new JPasswordField();
        passField.setBounds(150, 80, 160, 30); // Positionner le champ mot de passe
        passField.setBackground(new Color(255, 240, 245)); // Fond beige rosé 
        passField.setForeground(new Color(80, 50, 70)); // Texte foncé 
        add(passField); // Ajouter  à la fenêtre
        
        

        // Création du bouton "Se connecter"
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBounds(100, 140, 200, 40); // Positionner et dimensionner le bouton
        loginButton.setBackground(new Color(220, 120, 180)); // Couleur du bouton rose/violet 
        loginButton.setForeground(Color.WHITE); // Texte en blanc 
        loginButton.setFocusPainted(false); // Supprimer le contour bleu par défaut
        loginButton.setFont(new Font("Arial", Font.BOLD, 15)); // Texte  en gras 
        
        
        
        // Action sur le bouton 
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérification d'identifiant
                if (userField.getText().equals("admin") && new String(passField.getPassword()).equals("admin")) {
                	ContactManager contactManager = new ContactManager();
                	new MainFrame(contactManager);
                	dispose();
 // Fermer la fenêtre de connexion
                } else {
                    // si incorrect afficher un msg 
                    JOptionPane.showMessageDialog(null, "Identifiants incorrects !");
                }
            }
        });
        

        add(loginButton); // Ajouter le bouton à la fenêtre
        setVisible(true); // Afficher la fenêtre
    }
}

