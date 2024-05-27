package model;

import model.User.Admin;
import model.User.User;

import java.text.ParseException;
import java.util.Scanner;

public class Article implements Comparable<Article>{
    private final int articleId;
    private int price;
    private String name, description;


    public Article(int articleId, String name, String description, int price)
    {
        this.articleId = articleId;
        this.description = description;
        this.price=price;
        this.name=name;
    }

    public Article(int articleId, Scanner in) throws ParseException{
        this.articleId=articleId;
        this.read(in);
    }
    public void read(Scanner in) throws ParseException{
        System.out.println("Nume articol:");
        this.setArticleName(in.nextLine());
        System.out.println("Descriere articol:");
        this.setDescription(in.nextLine());
        System.out.println("Pret articol:");
        this.setArticlePrice(in.nextInt());

    }

    public static Article createArticle(){
        Scanner sc = new Scanner(System.in);

        String titlu, descriere;
        int id, pret;

        System.out.println("ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Titlu articol: ");
        titlu = sc.nextLine();
        System.out.println("Descriere articol: ");
        descriere = sc.nextLine();
        System.out.println("Pret");
        pret = sc.nextInt();

        return new Article(id, titlu,descriere,pret);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArticleId() {
        return articleId;
    }

    public int getPrice(){return price;}


    public void setArticleName(String name)
    {
        this.name=name;
    }
    public void setArticleDescription(String description)
    {
        this.description=description;
    }
    public void setArticlePrice(int price)
    {
        this.price=price;
    }

    @Override
    public int compareTo(Article article) {

        int articlePrice=((Article)article).getPrice();
        /* For Ascending order*/
        return this.price-articlePrice;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }

    @Override
    public String toString() {
        return "[ Article name =" + name + ", description=" + description + ", price=" + price + "]";
    }

}
