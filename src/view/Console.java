package view;

import Service.Audit;
import persistence.ArticleRepository;
import persistence.ComandaArticleRepository;
import persistence.ComandaRepository;
import persistence.UserRepository;

public abstract class Console {
    protected Audit audit = Audit.getInstance();

    protected UserRepository userRepository;
    protected ArticleRepository articleRepository;
    protected ComandaRepository comandaRepository;
    protected ComandaArticleRepository comandaArticleRepository;

    public abstract void startMenu();
}
