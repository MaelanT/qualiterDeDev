package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if (parameters.length < 4) {
            System.err.println("Format attendu : remplacer;debut;fin;texte");
            return;
        }
        try {
            int debut = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);
            String remplacement = parameters[3];
            this.document.remplacer(debut, fin, remplacement);
        } catch (NumberFormatException e) {
            System.err.println("Les indices doivent être des entiers valides.");
        }
        super.executer();
    }

    @Override
    public String getDescriptionCommande() {
        return "Remplace le texte entre les positions spécifiées par le texte de remplacement. Format: remplacer;debut;fin;texte";
    }
}
