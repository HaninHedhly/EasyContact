
import javax.swing.*; //  pour l'interface graphique
import java.awt.*; //  la gestion des layouts et des couleurs

public class AddContactFrame extends JFrame { 
    private JTextField nom, prenom, email, telephone; // Champs de texte pour saisir les informations du contact
    private ContactManager contactManager; // Instance de ContactManager pour gérer la base de données

    // Constructeur de la classe
    public AddContactFrame() { 
        contactManager = new ContactManager(); // Crée une instance de ContactManager
        //pour interagir avec la base de données

        setTitle("♡ Ajouter un Contact ♡"); 
        setSize(500, 400); // taille de la fenêtre 
        setLocationRelativeTo(null); // Centre 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ferme la fenêtre sans quitter l'application

        getContentPane().setBackground(new Color(255, 240, 245)); //  rose 

        JPanel panel = new JPanel(new GridBagLayout()); //  une zone  pour organiser les composants
        panel.setBackground(new Color(255, 240, 245)); // font rose

        GridBagConstraints gbc = new GridBagConstraints(); //  la disposition des composants
        gbc.insets = new Insets(8, 8, 8, 8); //  marges  autour des composants
        gbc.fill = GridBagConstraints.HORIZONTAL; // Étire les composants horizontalement 

        nom = createStyledTextField(); 
        prenom = createStyledTextField(); 
        email = createStyledTextField(); 
        telephone = createStyledTextField(); // Crée un champ de texte stylisé pour le téléphone

        addLabelAndField(panel, gbc, "♡ Nom :", nom, 0); // Ajoute le libellé et le champ pour le nom à la ligne 0
        addLabelAndField(panel, gbc, "♡ Prénom :", prenom, 1); 
        addLabelAndField(panel, gbc, "♡ Email :", email, 2); 
        addLabelAndField(panel, gbc, "♡ Téléphone :", telephone, 3); 

        JButton addButton = new JButton("Ajouter ♡"); 
        addButton.setFont(new Font("Arial", Font.BOLD, 16)); //  police 
        addButton.setBackground(new Color(221, 160, 221)); // fond violet 
        addButton.setForeground(Color.WHITE); //  texte du bouton en blanc
        addButton.setFocusPainted(false); // Désactive l'effet de focus visuel sur le bouton
        addButton.setPreferredSize(new Dimension(130, 45)); //  taille  du bouton
        addButton.setBorder(BorderFactory.createLineBorder(new Color(255, 182, 193), 2, true)); // bordure rose 

        gbc.gridx = 0; // Positionne le bouton à la colonne 0
        gbc.gridy = 4; // Positionne  la ligne 4
        gbc.gridwidth = 2; //  occupe 2 colonnes
        gbc.anchor = GridBagConstraints.CENTER; // Centre le bouton horizontalement
        panel.add(addButton, gbc); // Ajoute le bouton au panneau

        addButton.addActionListener(e -> { //écouteur d'événements pour gérer le clic sur le bouton
            String name = nom.getText(); // Récupère le texte saisi dans le champ nom
            String prenomm = prenom.getText();
            String gmail = email.getText(); 
            String phone = telephone.getText(); 

            if (!name.isEmpty() && !gmail.isEmpty()) { 
                Contact personne = new Contact(name, prenomm, phone, gmail); // nouvel objet Contact avec les données saisies
                contactManager.addContact(personne); // Appelle ContactManager pour ajouter le contact à la base de données
                JOptionPane.showMessageDialog(null, "♡ Contact ajouté avec succès ♡"); // Affiche un message de succès
                dispose(); // Ferme la fenêtre après l'ajout
            } else {
                JOptionPane.showMessageDialog(null, "♡ Veuillez remplir tous les champs ♡"); 
            }
        });

        add(panel); // Ajoute le panneau à la fenêtre
        setVisible(true); // Rend la fenêtre visible
    }

    private JTextField createStyledTextField() { 
        JTextField textField = new JTextField(15); // champ de texte largeur de 15 caractères
        textField.setFont(new Font("Arial", Font.PLAIN, 14)); //police 
        textField.setBackground(new Color(255, 250, 250)); // fond blanc 
        textField.setForeground(Color.DARK_GRAY); //couleur du texte en gris foncé
        textField.setBorder(BorderFactory.createCompoundBorder( // Ajoute une bordure composée
                BorderFactory.createLineBorder(new Color(221, 160, 221), 2, true), // Bordure violette 
                BorderFactory.createEmptyBorder(5, 8, 5, 8) // Marge intérieure 
        ));
        return textField; // Retourne le champ de texte stylisé
    }

    private void addLabelAndField(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField, int y) { 
    	// Méthode pour ajouter un libellé et un champ à un panneau
        JLabel label = new JLabel(labelText); // Crée un libellé 
        label.setFont(new Font("Arial", Font.BOLD, 15)); //  la police
        label.setForeground(new Color(186, 85, 211)); //  violet 

        gbc.gridx = 0; // Positionne  colonne 0
        gbc.gridy = y; // Positionne  à la ligne spécifiée (y)
        gbc.anchor = GridBagConstraints.WEST; // Aligne le libellé à gauche
        panel.add(label, gbc); // Ajoute le libellé au panneau

        gbc.gridx = 1; // Positionne le champ de texte à la colonne 1
        gbc.gridy = y; // Positionne le champ de texte à la même ligne que le libellé
        gbc.anchor = GridBagConstraints.EAST; // Aligne le champ de texte à droite
        panel.add(textField, gbc); // Ajoute le champ de texte au panneau
    }
}