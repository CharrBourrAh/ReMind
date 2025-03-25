package main.java.fr.ynov.remind.factory;

import main.java.fr.ynov.remind.domain.Element;

import java.util.TreeMap;

public class ElementsFactory {
    public TreeMap<Integer, Element> getAllElements() {
        return allElements;
    }

    private final TreeMap<Integer, Element> allElements = new TreeMap<Integer, Element>();


    public void addElement(int size, Element element) {
        allElements.put(allElements.size(), element);
    }

    public void removeElement(Element element) {
        allElements.values().remove(element);
    }

    public void updateElement(Integer id, Element element) {
        allElements.replace(id, element);
    }
}
