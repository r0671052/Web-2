package domain.db;

import java.util.ArrayList;
import domain.model.Painting;
import domain.db.DbException;

public class PaintingDB {
    private ArrayList<Painting> paintings;

    public PaintingDB() {
        paintings = new ArrayList<>();
        Painting p1 = new Painting("Edvard Munch","De Schreeuw",270000000,"EdMuDeSc",5);
        Painting p2 = new Painting("Pablo Picasso","De Oude Gitarist",10000000,"PaPiDeOuGi",3);
        Painting p3 = new Painting("Johannes Vermeer", "Meisje met de parel", 164000000,"JoVeMePa",3);

        paintings.add(p1);
        paintings.add(p2);
        paintings.add(p3);

    }

    public ArrayList<Painting> getPaintings() {
        return paintings;
    }

    public Painting getPainting(String code) {
        for (Painting p : getPaintings())
            if (p.getCode().equals(code))
                return p;
        return null;
    }

    public int getTotaalAantalPaintings(){
        return paintings.size();
    }

    public void delete(String code) {
        int index = 0;
        for(int i = 0; i<paintings.size();i++){
            if(paintings.get(i).getCode().equals(code)) index = i;
        }
        if(index <0 || index > paintings.size())throw new DbException("Ongeldige db");
        paintings.remove(index);
    }

    public void addPainting(Painting painting) {
        if(painting == null) throw new DbException("Schilderij kan niet null zijn");
        if(paintings.size()!= 0){
            if(paintings.contains(painting)) throw new DbException("Schilderij zit al in de lijst");
        }
        paintings.add(painting);

    }

    public Painting findPainting(String code){
        for(Painting p: paintings){
            if(p.getCode().equals(code)) return p;
        }
        return null;
    }

    public int mostExpensivePainting(){
       int duurste = 0;
        for(Painting p: paintings){
            if(p.getPrice()>duurste) duurste = p.getPrice();
        }
        return duurste;
    }

    public String nameMostExpensivePainting(){
        String uit = "";
        int duurste = 0;
        for(Painting p:paintings){
            if(p.getPrice()>duurste){
                duurste = p.getPrice();
                uit = p.getName();
            }
        }
        return uit;
    }

    public double averagePricePaintings(){
        double price = 0;
        for(Painting p :paintings){
            price += p.getPrice();
        }
        return price/paintings.size();
    }

    public double averageAge(){
        double leeftijd =0;
        for(Painting p: paintings){
            leeftijd +=p.getLeeftijd();
        }
        return Math.round(leeftijd/paintings.size());
    }

}