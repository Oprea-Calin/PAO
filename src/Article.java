import java.text.ParseException;
import java.util.Scanner;

public class Article {
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
        this.setArticlePrice(Integer.valueOf(in.nextLine()));

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



}
