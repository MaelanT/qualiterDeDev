package fr.iut.editeur.document;

/**
 * La classe Document représente un texte modifiable avec plusieurs opérations disponibles pour la manipulation de ce texte.
 * Elle permet d'ajouter du texte, de remplacer des portions du texte, et de changer la casse de certaines parties.
 * D'autres fonctionnalités incluent l'effacement de portions de texte et la réinitialisation complète du document.
 */
public class Document {

    // Attribut représentant le texte du document
    private String texteDocument;

    /**
     * Constructeur de la classe Document.
     * Initialise le texte du document avec une chaîne vide.
     */
    public Document() {
        this.texteDocument = "";
    }

    /**
     * Retourne le texte actuel du document.
     *
     * @return le texte du document sous forme de chaîne de caractères.
     */
    public String getTexte() {
        return texteDocument;
    }

    /**
     * Définit le texte du document avec le contenu fourni.
     *
     * @param texte Le nouveau texte à assigner au document.
     */
    public void setTexte(String texte) {
        this.texteDocument = texte;
    }

    /**
     * Ajoute du texte à la fin du document.
     *
     * @param texte Le texte à ajouter au document actuel.
     */
    public void ajouter(String texte) {
        this.texteDocument += texte;
    }

    /**
     * Remplace une portion du texte entre les indices spécifiés par une nouvelle chaîne.
     *
     * @param debut        L'indice de début de la portion à remplacer (inclusif).
     * @param fin          L'indice de fin de la portion à remplacer (inclusif).
     * @param remplacement Le texte de remplacement pour la portion spécifiée.
     */
    public void remplacer(int debut, int fin, String remplacement) {
        String partieGauche = texteDocument.substring(0, debut);
        String partieDroite = texteDocument.substring(fin + 1);
        texteDocument = partieGauche + remplacement + partieDroite;
    }

    /**
     * Convertit une portion du texte en majuscules entre les indices spécifiés.
     *
     * @param debut L'indice de début de la portion à mettre en majuscules (inclusif).
     * @param fin   L'indice de fin de la portion à mettre en majuscules (inclusif).
     */
    public void majuscules(int debut, int fin) {
        if (debut < 0 || fin >= texteDocument.length() || debut > fin) {
            System.err.println("Indices invalides");
            return;
        }

        String portion = texteDocument.substring(debut, fin + 1);
        String portionMajuscules = portion.toUpperCase();
        remplacer(debut, fin, portionMajuscules);
    }

    /**
     * Convertit une portion du texte en minuscules entre les indices spécifiés.
     *
     * @param debut L'indice de début de la portion à mettre en minuscules (inclusif).
     * @param fin   L'indice de fin de la portion à mettre en minuscules (inclusif).
     */
    public void minuscule(int debut, int fin) {
        if (debut < 0 || fin >= texteDocument.length() || debut > fin) {
            System.err.println("Indices invalides");
            return;
        }

        String portion = texteDocument.substring(debut, fin + 1);
        String portionMinuscules = portion.toLowerCase();
        remplacer(debut, fin, portionMinuscules);
    }

    /**
     * Efface une portion du texte entre les indices spécifiés.
     *
     * @param debut L'indice de début de la portion à effacer (inclusif).
     * @param fin   L'indice de fin de la portion à effacer (inclusif).
     */
    public void effacer(int debut, int fin) {
        if (debut < 0 || fin >= texteDocument.length() || debut > fin) {
            System.err.println("Indices invalides");
            return;
        }
        remplacer(debut, fin, "");
    }

    /**
     * Réinitialise le document en supprimant tout le texte.
     */
    public void clear() {
        this.texteDocument = "";
    }

    /**
     * Insère une chaîne spéciale "*inserer*" à la fin du texte actuel.
     */
    public void inserer() {
        this.texteDocument += "*inserer*";
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du texte actuel du document.
     *
     * @return Le texte du document.
     */
    @Override
    public String toString() {
        return this.texteDocument;
    }
}
