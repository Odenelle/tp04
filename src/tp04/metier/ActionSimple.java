/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Martin Omega(MGE) REMY et Clément Cassis(MGII) Dumont
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;
    
    private Jour dateAchat ; 
    
    // constructeur
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap();
    }
    
    // enrg possible si pas de cours pour ce jour
    public void enrgCours(Jour j, float v) {
        if(this.mapCours.containsKey(j) == false)
            this.mapCours.put(j, new Cours(j, v));
    }
    
    @Override
    public float valeur(Jour j) {
        if(this.mapCours.containsKey(j) == true)
            return this.mapCours.get(j).getValeur();
        else 
            return 0; // definition d'une constante possible
    }
    
    /**
     * affiche la plusvalue entre la date d'achat, et la date choisie 
     * @param ajd Journée choisie pour comparer (conseillé d'utiliser la date d'aujourd'hui) 
     * @version v1.0
     */
    public void plusValue(Jour ajd){
       double valeurAjd =  this.valeur(ajd) ; 
       double valeurDebut = this.valeur(dateAchat) ;
       double resultat ; 
       double pourcentage ; 
       
       if (valeurAjd > valeurDebut) {
           resultat = valeurAjd - valeurDebut ; 
           pourcentage = valeurAjd*100/valeurDebut-100;
           System.out.println("Vous avez gagné "+resultat+"€. Cela correspond à une augmentation de "+pourcentage+"%.");
       }
       else if (valeurAjd < valeurDebut ) {
           resultat = valeurDebut - valeurAjd ; 
           pourcentage = valeurAjd*100/valeurDebut-100;
           System.out.println("Vous avez perdu "+resultat+"€. Cela correspond à une perte de "+pourcentage+"%.");
       }
       else{
           System.out.println("Vous n'avez ni gagné ni perdu d'argent.");
       }
        
    }

    public Jour getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Jour dateAchat) {
        this.dateAchat = dateAchat;
    }
  
    
    
    // encapsulation de la définition de la classe Cours
    private class Cours {
        
        private Jour jour;

        private float valeur;

        public float getValeur() {
            return valeur;
        }
        
        public Jour getJour() {
            return jour;
        }

        public Cours(Jour jour, float valeur) {
            this.jour = jour;
            this.valeur = valeur;
        }

    }
}
