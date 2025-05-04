
import javax.swing.*; //  l'interface graphique
import java.awt.*; //  la gestion des layouts et des couleurs
import java.awt.event.ActionEvent; //  représenter les événements d'action
import java.awt.event.ActionListener; //  gérer les événements de clic


public class DeleteContactFrame extends JFrame { 
    private JTextField emailField; // 
    private ContactManager contactManager; // Instance de ContactManager pour
    //gérer les opérations sur la base de données

    // Constructeur
    public DeleteContactFrame() { 
        contactManager = new ContactManager(); // pour interagir avec la base de données SQLite

        // Configuration de la fenêtre
        setTitle("♡ Supprimer un Contact ♡"); // 
        setSize(450, 250); 
        setLocationRelativeTo(null); // Centre 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        getContentPane().setBackground(new Color(255, 240, 245)); // fond rose 

        // En-tête 
        JPanel headerPanel = new JPanel(); // panneau pour l'en-tête
        headerPanel.setBackground(new Color(221, 160, 221)); // fond violet
        JLabel headerLabel = new JLabel("♡ Supprimer un Contact ♡"); //  un libellé 
        headerLabel.setForeground(Color.WHITE); //  texte en blanc
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18)); //  police 
        headerPanel.add(headerLabel); // Ajoute le libellé au panneau d'en-tête
        add(headerPanel, BorderLayout.NORTH); //  en haut de la fenêtre 

        // Formulaire de saisie de l'email
        JPanel formPanel = new JPanel(new GridBagLayout()); //  un panneau de formulaire 
        GridBagConstraints gbc = new GridBagConstraints(); //  un objet pour  la disposition des composants
        gbc.insets = new Insets(8, 8, 8, 8); //  des marges 
        gbc.gridx = 0; // Positionne  la colonne 0
        gbc.gridy = 0; // Positionne  la ligne 0
        gbc.anchor = GridBagConstraints.WEST; // Aligne le composant à gauche

        
        formPanel.add(new JLabel("♡ Email du contact à supprimer : "), gbc); 

        // Champ de saisie stylisé
        gbc.gridx = 1; // Positionne  à la colonne 1
        emailField = createStyledTextField(); // Crée un champ de texte pour l'email
        formPanel.add(emailField, gbc); // Ajoute le champ de texte au panneau du formulaire

        add(formPanel, BorderLayout.CENTER); 

        // Création du bouton Supprimer
        JButton deleteButton = new JButton("Supprimer ♡"); 
        deleteButton.setBackground(new Color(221, 160, 221)); // fond violet 
        deleteButton.setForeground(Color.WHITE); // texte en blanc
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14)); //la police 

        // Action du bouton Supprimer
        deleteButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { // Définit la méthode appelée lors du clic sur le bouton
                String email = emailField.getText().trim(); // Récupère l'email saisi et supprime les espaces inutiles

                
                if (email.isEmpty()) { // Vérifie si l'email est vide
                    JOptionPane.showMessageDialog(null, "♡ Veuillez entrer un email !", "Erreur", JOptionPane.ERROR_MESSAGE); 
                    return; 
                }

                // Vérifier si le contact existe dans la base
                boolean contactExiste = contactManager.contactExists(email); // Appelle ContactManager 

                if (!contactExiste) { 
                    JOptionPane.showMessageDialog(null, "♡ Contact introuvable dans la base !", "Erreur", JOptionPane.ERROR_MESSAGE); 
                    return; // Sort de la méthode
                }

                // Demande de confirmation
                int confirm = JOptionPane.showConfirmDialog(null, 
                        "♡ Voulez-vous vraiment supprimer ce contact ?", // Message de confirmation
                        "Confirmation", JOptionPane.YES_NO_OPTION); // Options Oui/Non

                if (confirm == JOptionPane.YES_OPTION) { // Si l'utilisateur clique sur "Oui"
                    boolean success = contactManager.removeContact(email); // Appelle ContactManager pour supprimer le contact

                    if (success) { // Si la suppression réussit
                        JOptionPane.showMessageDialog(null, "♡ Contact supprimé avec succès !"); // Affiche un message de succès
                        dispose(); // Ferme la fenêtre
                    } else { // Si la suppression échoue
                        JOptionPane.showMessageDialog(null, "♡ Erreur lors de la suppression !", "Erreur", JOptionPane.ERROR_MESSAGE); // Affiche un message d'erreur
                    }
                }
            }
        });

        // Panneau pour le bouton en bas
        JPanel buttonPanel = new JPanel(); // Crée un panneau pour le bouton
        buttonPanel.setBackground(new Color(255, 240, 245)); // Définit un fond rose pâle pour le panneau
        buttonPanel.add(deleteButton); // Ajoute le bouton au panneau
        add(buttonPanel, BorderLayout.SOUTH); // Ajoute le panneau du bouton en bas de la fenêtre (BorderLayout.SOUTH)

        setVisible(true); // Rend la fenêtre visible à l'écran
    }

    // Méthode pour créer un champ de texte stylisé girly
    private JTextField createStyledTextField() { 
        JTextField textField = new JTextField(15); 
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); //  police 
        textField.setBackground(new Color(255, 240, 245)); //  fond rose 
        textField.setForeground(new Color(102, 51, 153)); //  texte  violet 
        textField.setBorder(BorderFactory.createLineBorder(new Color(221, 160, 221), 2)); //  bordure violette 
        textField.setPreferredSize(new Dimension(250, 30)); //  taille  du champ )
        return textField; // Retourne le champ de texte stylisé
    }
}