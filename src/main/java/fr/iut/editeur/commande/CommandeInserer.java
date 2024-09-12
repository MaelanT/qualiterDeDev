package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeInserer extends CommandeDocument {
    public CommandeInserer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public String getDescriptionCommande() {
        return null;
    }

    @Override
    public void executer() {
        // Appel de la méthode clear dans Document
        this.document.inserer();

        // Exécution de la commande
        super.executer();

    }
}
