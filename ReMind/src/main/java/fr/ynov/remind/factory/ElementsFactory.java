package main.java.fr.ynov.remind.factory;

import main.java.fr.ynov.remind.domain.Element;

import java.util.List;

public class ElementsFactory {
    public List<Element> getAllElements() {
        return allElements;
    }

    public void setAllElements(List<Element> allElements) {
        this.allElements = allElements;
    }

    private List<Element> allElements;


    public void addElement(Element element) {
        allElements.add(element);
    }

    public void removeElement(Element element) {
        allElements.remove(element);
    }

    public void updateElement(int id) {

    }
}
