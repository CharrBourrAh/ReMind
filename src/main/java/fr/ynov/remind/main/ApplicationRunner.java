package main.java.fr.ynov.remind.main;

import main.java.fr.ynov.remind.factory.ElementsFactory;
import main.java.fr.ynov.remind.factory.JsonHandler;
import main.java.fr.ynov.remind.gui.MainPage;

public class ApplicationRunner {
    public static void main(String[] args) {
        ElementsFactory elementsFactory = new ElementsFactory();
        JsonHandler.loadDataFromJSon(elementsFactory);
        new MainPage().mainPage(elementsFactory);
    }
}
