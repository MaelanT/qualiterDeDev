package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeMinuscule extends CommandeDocument {

    @Override
    public String getDescriptionCommande() {
        return null;
    }

    public CommandeMinuscule(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        // Vérification du nombre de paramètres
        if (parameters.length < 3) {
            System.err.println("Format attendu : minuscule;debut;fin");
            return;
        }

        try {
            // Extraction et conversion des paramètres
            int debut = Integer.parseInt(parameters[1]);
            int fin = Integer.parseInt(parameters[2]);

            // Appel de la méthode majuscules dans Document
            this.document.minuscule(debut, fin);

            // Exécution de la commande
            super.executer();
        } catch (NumberFormatException e) {
            System.err.println("Les indices début et fin doivent être des entiers.");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Les indices sont hors des limites du document.");
        }
    }
}