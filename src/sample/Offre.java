package sample;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Offre {
    private SimpleStringProperty titre,description,categorie;
    private SimpleIntegerProperty prix;
    private SimpleStringProperty disponible;

    public Offre() {
    }

    public Offre(String titre, String description, String categorie, int prix, String disponible) {
        this.titre = new SimpleStringProperty(titre);
        this.description = new SimpleStringProperty(description);
        this.categorie = new SimpleStringProperty(categorie);
        this.prix = new SimpleIntegerProperty(prix);
        this.disponible = new SimpleStringProperty(disponible);
    }

    public String getTitre() {
        return titre.get();
    }


    public void setTitre(String titre) {
        this.titre.set(titre);
    }

    public String getDescription() {
        return description.get();
    }



    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getCategorie() {
        return categorie.get();
    }



    public void setCategorie(String categorie) {
        this.categorie.set(categorie);
    }



    public int getPrix() {
        return prix.get();
    }

    public void setPrix(int prix) {
        this.prix.set(prix);
    }

    public String getDisponible() {
        return disponible.get();
    }



    public void setDisponibile(String disponible) {
        this.disponible.set(disponible);
    }
}
