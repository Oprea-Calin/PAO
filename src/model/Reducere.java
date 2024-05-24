package model;

public class Reducere {

    int reducereId, articleId, reducere;

    public Reducere(int reducereId, int articleId, int reducere)
    {
        this.reducereId=reducereId;
        this.articleId=articleId;
        this.reducere=reducere;
    }

    public int getReducereId(){
        return reducereId;
    }
    public int getArticleId(){
        return articleId;
    }
    public int getReducere(){
        return reducere;
    }

}
