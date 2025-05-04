
import javax.swing.*; //  l'interface graphique
import java.awt.*; //  gestion des layouts et des couleurs

public class ModifyContactFrame extends JFrame { 
    private JTextField nomField, prenomField, emailField, telephoneField; // Champs de texte pour modifier les informations du contact
    private JButton saveButton; // Bouton 
    private ContactManager contactManager; 
    private String oldEmail; // Stocke l'email original du contact pour l'identifier lors de la mise à jour

    // Constructeur
    public ModifyContactFrame(ContactManager contactManager, String nom, String prenom, String email, String telephone) { 
        this.oldEmail = email; // Stocke l'email original pour identifier le contact à modifier
        this.contactManager = new ContactManager(); 

        setTitle("💫 Modifier Contact 💫"); 
        setSize(400, 320); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        
        Color backgroundColor = new Color(255, 240, 245); //  rose 
        Color buttonColor = new Color(221, 160, 221); //  violet 

        getContentPane().setBackground(backgroundColor); //  rose clair à la fenêtre
        setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints(); //  pour configurer la disposition des composants
        gbc.insets = new Insets(10, 10, 10, 10); // marges

        Font labelFont = new Font("Arial", Font.BOLD, 14); //police 
        Font fieldFont = new Font("Arial", Font.PLAIN, 14); 

        // Nom
        gbc.gridx = 0; // Positionne à la colonne 0
        gbc.gridy = 0; // Positionne la ligne 0
        add(new JLabel("Nom :"), gbc); // Ajoute un libellé pour le champ nom

        gbc.gridx = 1; // Positionne le champ de texte à la colonne 1
        nomField = new JTextField(nom, 15); // Crée un champ de texte pré-rempli avec le nom actuel
        nomField.setFont(fieldFont); // Applique la police définie au champ
        add(nomField, gbc); // Ajoute le champ de texte à la fenêtre

        // Prénom
        gbc.gridx = 0; // Positionne  à la colonne 0
        gbc.gridy = 1; // Positionne à la ligne 1
        add(new JLabel("Prénom :"), gbc); 

        gbc.gridx = 1; // Positionne le champ de texte à la colonne 1
        prenomField = new JTextField(prenom, 15); // Crée un champ de texte pré-rempli avec le prénom actuel
        prenomField.setFont(fieldFont); 
        add(prenomField, gbc); 

        // Email
        gbc.gridx = 0;  
        gbc.gridy = 2; 
        add(new JLabel("Email :"), gbc); // Ajoute un libellé pour le champ email

        gbc.gridx = 1; // Positionne  à la colonne 1
        emailField = new JTextField(email, 15); 
        emailField.setFont(fieldFont); 
        add(emailField, gbc); 

        // Téléphone
        gbc.gridx = 0; // Positionne le libellé à la colonne 0
        gbc.gridy = 3; 
        add(new JLabel("Téléphone :"), gbc); // Ajoute un libellé pour le champ téléphone

        gbc.gridx = 1; 
        telephoneField = new JTextField(telephone, 15); 
        telephoneField.setFont(fieldFont); 
        add(telephoneField, gbc); 

        // Bouton Enregistrer
        gbc.gridx = 0; //
        gbc.gridy = 4; 
        gbc.gridwidth = 2; // Le bouton occupe 2 colonnes
        gbc.anchor = GridBagConstraints.CENTER; 
        saveButton = new JButton("💾 Enregistrer les modifications"); 
        saveButton.setBackground(buttonColor); // violet
        saveButton.setFont(labelFont); 
        saveButton.addActionListener(e -> saveModifiedContact()); // Attache un écouteur d'événements pour gérer le clic
        add(saveButton, gbc); // Ajoute le bouton à la fenêtre

        setVisible(true); // Rend la fenêtre visible à l'écran
    }

    // Enregistre les modifications dans la base de données
    private void saveModifiedContact() { 
        String newNom = nomField.getText().trim(); // Récupère le nouveau nom et supprime les espaces inutiles
        String newPrenom = prenomField.getText().trim(); 
        String newEmail = emailField.getText().trim(); 
        String newTelephone = telephoneField.getText().trim(); 

        if (newNom.isEmpty() || newPrenom.isEmpty() || newEmail.isEmpty() || newTelephone.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires !"); 
            return; // Sort de la méthode si un champ est vide
        }

        Contact updatedContact = new Contact(newNom, newPrenom, newEmail, newTelephone); // Crée un nouvel objet Contact avec les nouvelles données
        boolean success = contactManager.updateContact(oldEmail, updatedContact); // Appelle ContactManager pour mettre à jour le contact

        if (success) { // Si la mise à jour réussit
            JOptionPane.showMessageDialog(this, "Contact modifié avec succès !"); 
            dispose(); // Ferme la fenêtre
        } else { 
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification du contact !"); 
        }
    }
}