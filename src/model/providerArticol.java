package model;

public class providerArticol {
    int idProvider, idArticol;
    public providerArticol(int idProvider, int idArticol)
    {
        this.idProvider = idProvider;
        this.idArticol  =idArticol;
    }

    public int getIdProvider(){
        return idProvider;
    }
    public int getIdArticol()
    {
        return idArticol;
    }
}
