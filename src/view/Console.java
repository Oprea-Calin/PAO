package view;

import Service.Audit;
import persistence.ArticleRepository;
import persistence.UserRepository;

public abstract class Console {
    protected Audit audit = Audit.getInstance();

    protected UserRepository userRepository;
    protected ArticleRepository articleRepository;

    public abstract void startMenu();
}
