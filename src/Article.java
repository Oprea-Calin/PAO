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
}
