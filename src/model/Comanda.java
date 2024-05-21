package model;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int idComanda;
    private int idUser;
    private List<Article> articoleComanda = new ArrayList<>();

    public Comanda(int idUser, int idComanda){
        this.idComanda=idComanda;
        this.idUser=idUser;
    }

    public void addArticleToComanda(Article article)
    {
        articoleComanda.add(article);
    }
    public int getIdComanda()
    {
        return idComanda;
    }
}
