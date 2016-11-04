package com.pryadko.app;

import com.pryadko.process.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner {
    private final Loader loader;

    @Autowired
    public App(Loader loader) {
        this.loader = loader;
    }

    @Override
    public void run(String... strings) throws Exception {
        if (strings.length == 0) {
            return;
        }
        System.out.println(loader.loadBoard(strings[0]));
    }
}
