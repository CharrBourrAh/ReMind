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
    public static int remainingTime(int year, int month, int day) {
        int result = year * 365;
        for (int i= month; i>0; i--) {
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> result += 31;
                case 4, 6, 9, 11 -> result += 30;
                case 2 -> result += 28;
            }
        }
        return result+day;
    }
}
