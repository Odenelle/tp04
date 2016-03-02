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
public class ActionComposee extends Action {
    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    private Jour dateAchat ; 

    
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }
    
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

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
  
    
    @Override
    public float valeur(Jour j) {
        float valeur;
        
        valeur = 0;
        for(ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }
        
        return valeur;
    }
    
    
}
