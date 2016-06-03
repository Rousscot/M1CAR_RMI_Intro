package rmiHello;

public class ClientIHM
        extends java.awt.Frame
{
    //
    // Etat interne.
    //

    protected Hello helloDistant = null;

    protected java.awt.TextField nomServeur = null;
    protected java.awt.TextField entree = null;
    protected java.awt.TextField reponse = null;

    /**
     ** Le constructeur avec un titre et l'URL du Hello distant.
     **
     ** @param titre Le titre de la fenêtre.
     ** @param urlHello L'URL de l'objet Hello RMI.
     **
     **/
    public ClientIHM(String titre, String urlHello)
    {
        // Appel du constructeur de java.awt.Frame.
        //
        super(titre);

        // Fixer le Layout.
        //
        setLayout (new java.awt.GridLayout(6,1));

        // Ajouter les composants graphiques.
        //
        add(new java.awt.Label("URL de l'objet Hello : "));
        nomServeur = new java.awt.TextField(40);
        add(nomServeur);
        add(new java.awt.Label("Texte à envoyer à l'objet Hello : "));
        entree = new java.awt.TextField(40);
        add(entree);
        add(new java.awt.Label("Réponse de l'objet Hello : "));
        reponse = new java.awt.TextField(40);
        add(reponse);

        // Ajouter un gérant d'événements pour la fenêtre.
        //
        addWindowListener (new GestionnaireQuitter());

        // Ajouter un gérant d'événements pour le champ nomServeur.
        //
        nomServeur.addActionListener (new GestionnaireNomServeur());

        // Ajouter un gérant d'événements pour le champ entree.
        //
        entree.addActionListener (new GestionnaireEntree());

        // Fixer l'URL de base.
        //
        nomServeur.setText(urlHello);
        connecter_serveur(urlHello);
    }

    // Le gestionnaire des événements liés à la fenêtre.
    //
    protected class GestionnaireQuitter
            extends java.awt.event.WindowAdapter
    {
        // Fermeture de la fenêtre.
        //
        public void windowClosing(java.awt.event.WindowEvent e)
        {
            System.exit (0);
        }
    }

    public void connecter_serveur (String nomServeur)
    {
        try {
            helloDistant = (Hello) java.rmi.Naming.lookup(nomServeur);
            reponse.setText (null);
        } catch(Exception ex) {
            reponse.setText ( ex.toString() );
        }
    }

    // Le gestionnaire des événements liés au champ nomServeur.
    //
    protected class GestionnaireNomServeur
            implements java.awt.event.ActionListener
    {
        // Validation du champ.
        //
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
            connecter_serveur (nomServeur.getText());
        }
    }

    // Le gestionnaire des événements liés au champ 'entree'.
    //
    protected class GestionnaireEntree
            implements java.awt.event.ActionListener
    {
        // Validation du champ.
        //
        public void actionPerformed(java.awt.event.ActionEvent e)
        {
            try {
                helloDistant.afficher( entree.getText() );
                entree.setText("");
                Message dernierMessage = helloDistant.getDernierMessage();
                reponse.setText( dernierMessage.toString() );
            } catch(Exception ex) {
                reponse.setText ( ex.toString() );
            }
        }
    }

    /**
     ** Le programme principal.
     **/
    public static void main (String[] args)
    {
        // Obtenir les paramètres ou alors les valeurs par défaut.
        //
        String nomServeur = (args.length > 0)?args[0]:"//localhost/Hello";

        // Création de l'IHM.
        //
        ClientIHM ihm = new ClientIHM("IHM sur un serveur Hello", nomServeur);

        // Affichage de l'IHM.
        //
        ihm.pack ();
        ihm.show ();
    }
}
