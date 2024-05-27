package view;

import Service.Audit;
import persistence.*;

public abstract class Console {
    protected Audit audit = Audit.getInstance();

    protected UserRepository userRepository;
    protected ArticleRepository articleRepository;
    protected ComandaRepository comandaRepository;
    protected ComandaArticleRepository comandaArticleRepository;
    protected ReducereRepository reducereRepository;
    protected ProviderRepository providerRepository;

    protected providerArticleRepository providerArticleRepository;


    public abstract void startMenu();
}
