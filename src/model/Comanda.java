package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comanda {
    int idComanda, idUser;
    String adresaLivrare;

    public Comanda(int idUser, int idComanda, String descriere){
        this.idComanda=idComanda;
        this.idUser=idUser;
        this.adresaLivrare = descriere;
    }

//    public static Comanda createComanda(){
//        Scanner sc = new Scanner(System.in);
//        String adresa;
//
//        System.out.println("Adresa ");
//        adresa = sc.nextLine();
//
//        return new Comanda(idComanda,idUser, adresa);
//    }
    public int getIdUser() {
        return idUser;
    }
    public String getAdresaLivrare(){
        return adresaLivrare;
    }

    public int getIdComanda()
    {
        return idComanda;
    }
}
