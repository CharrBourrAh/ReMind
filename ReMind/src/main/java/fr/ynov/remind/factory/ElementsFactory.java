package main.java.fr.ynov.remind.factory;

import main.java.fr.ynov.remind.domain.Element;

import java.util.TreeMap;

public class ElementsFactory {
    public TreeMap<Integer, Element> getAllElements() {
        return allElements;
    }

    private final TreeMap<Integer, Element> allElements = new TreeMap<Integer, Element>();



    public void addElement(Element element) {
        allElements.add(element);
    }

    public void removeElement(Element element) {
        allElements.remove(element);
    }

    public void updateElement(int id) {

    }
}
