package model;

import java.util.Scanner;

public class Provider {
    int idProvider;
    String nume, adresa;

    public Provider(int idProvider, String nume, String adresa)
    {
        this.idProvider=idProvider;
        this.nume = nume;
        this.adresa = adresa;
    }

    public String getAdresa(){
        return adresa;
    }
    public int getIdProvider()
    {
        return idProvider;
    }
    public String getNume(){
        return nume;
    }
    public static Provider createProvider(int id){
        Scanner sc = new Scanner(System.in);

        String nume, adresa;



        System.out.println("Nume provider: ");
        nume = sc.nextLine();
        System.out.println("Adresa provider: ");
        adresa = sc.nextLine();


        return new Provider(id, nume, adresa);
    }

}
