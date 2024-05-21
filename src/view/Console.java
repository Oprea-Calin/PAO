package view;

import Service.Audit;
import persistence.UserRepository;

public abstract class Console {
    protected Audit audit = Audit.getInstance();

    protected UserRepository userRepository;

    public abstract void startMenu();
}
