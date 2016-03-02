/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.exec;

import tp04.metier.Action;
import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Jour;
import tp04.metier.Portefeuille;

public class Run {

    public static void main(String[] args) {
        ActionSimple bnp, axa, testPlusValue;
        ActionComposee bqAss;
        Jour j1, j2, j3;

        // init des objets metiers Jour
        j1 = new Jour(2014, 1);
        j2 = new Jour(2014, 2);
        j3 = new Jour(2014, 3) ; 
        // creation d'actions simples et composée
        bnp = new ActionSimple("BNP");
        axa = new ActionSimple("AXA");
        bqAss = new ActionComposee("Banque-Assurance");
        testPlusValue = new ActionSimple("test"); 
        // enrg de la composition de l'action composée
        bqAss.enrgComposition(axa, 0.3f);
        bqAss.enrgComposition(bnp, 0.7f);
        // enrg. de 3 cours pour chaque action 
        testPlusValue.enrgCours(j1, 150);
        testPlusValue.enrgCours(j3, 300);
        testPlusValue.enrgCours(j2, 50);
        testPlusValue.setDateAchat(j1);
        
        axa.enrgCours(j1, 200);
        axa.enrgCours(j2, 250);
        bnp.enrgCours(j1, 100);
        bnp.enrgCours(j2, 200);
        // affichage des cours - comme 1 action simple et 1 action
        System.out.println("Action simple *bnp* à j1 : " + bnp.valeur(j1));
        System.out.println("Action *Banque-Assurance* à j2 : " + bqAss.valeur(j2));

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(axa, 10);
        System.out.println("Portefeuille : " + p);
        p.acheter(bnp, 20);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 5);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 15);
        System.out.println("Portefeuille : " + p);
        System.out.println("Portefeuille à j1 : " + p.valeur(j1));
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(bnp, 50);
        System.out.println("Portefeuille : " + p);
        
        testPlusValue.plusValue(j3);
        testPlusValue.plusValue(j2);
 
    }

}
