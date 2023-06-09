//package
package modele.entite.unite;

/**
 * La classe Cavalerie représente les cavaleries du jeu "Wargame"
 * 
 * La classe Cavalerie hérite de la classe {@link Unite}
 * Elle utlise le constructeur de sa classe mère
 * Elle possede une methode d'affichage pour terminal
 */
public class Cavalerie extends Unite{

    /**
     * Constructeur de la classe
     * Attribue pour un archer ses points de vie, son attaque, sa defense,sa vision, son cout, ses deplacement
     */
    public Cavalerie() {
        super(40,35,7,1);
        setPointDeVieMax(40);
        setDeplacementMax(7);
        setDeplacementActuel(7);
        setCout(12);
    }
    
    /**
     * Affichage d'un archer pour terminal
     */
    public String toString(){
        return "Cavalerie";
    }
}
