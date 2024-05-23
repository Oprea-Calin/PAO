package model;

public class ComandaArticle {
    int idComanda, idArticol;

    public ComandaArticle(int idComanda, int idArticol)
    {
        this.idArticol=idArticol;
        this.idComanda=idComanda;
    }

    public int getIdComanda()
    {
        return idComanda;
    }
    public int getIdArticol()
    {
        return idArticol;
    }
}
