package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeEffacer extends CommandeDocument {

    public CommandeEffacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 3) {
            System.err.println("Format attendu : effacer;debut;fin");
            return;
        }
        try {
            int debut = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            this.document.effacer(debut, fin);
        } catch (NumberFormatException e) {
            System.err.println("Les indices doivent être des entiers valides.");
        }
        super.executer();
    }

    @Override
    public String getDescriptionCommande() {
        return "Efface le texte entre les positions spécifiées. Format: effacer;debut;fin";
    }
}
