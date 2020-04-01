package sample;


import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;


public  class OffresData {

    public ArrayList<Offre> offres =new ArrayList<Offre>();


    public void loadData(){
        offres.add(new Offre("Restaurant de Luxe  3ème personne gratuite!",
             "Restaurant de Luxe situé au Marsa près de la mer",
             "Restaurants",0,"oui"));
        offres.add(new Offre("Restaurant de Luxe  Diner 2 personnes à prix étonnante!",
                "Restaurant de Luxe situé à Sidi Bousaid près de la mer",
                "Restaurants",49,"oui"));
        offres.add(new Offre("Zara Rayon à 50Dt!",
                "Boutique ZARA Tunis-city Azur City",
                "Prêt-à-porter",50,"oui"));
        offres.add(new Offre("Celio Pantalon à partir de 69DT!",
                "Boutique Celio Tunis-city Azur City",
                "Prêt-à-porter",69,"non"));
        offres.add(new Offre("Samsung Galaxy A3 2018!",
                "Orange Bardo",
                "Electronique",740,"non"));
        offres.add(new Offre("MacBook Pro 2018 à prix raisonable!",
                "Fnac Marsa",
                "Electronique",11400,"oui"));
    }

    public ArrayList<Offre> getOffres() {
        return offres;
    }

    public void setOffres(ArrayList<Offre> offres) {
        this.offres = offres;
    }
}
