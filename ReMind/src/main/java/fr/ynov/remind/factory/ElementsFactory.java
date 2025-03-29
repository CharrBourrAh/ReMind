package main.java.fr.ynov.remind.factory;

import main.java.fr.ynov.remind.domain.Element;

import java.util.TreeMap;

public class ElementsFactory {
    public TreeMap<Integer, Element> getAllElements() {
        return allElements;
    }

    private final TreeMap<Integer, Element> allElements = new TreeMap<Integer, Element>();


    public void addElement(Element element) {
        allElements.put(allElements.size(), element);
    }

public void removeElement(Element element) {
    Integer keyToRemove = null;
    for (Integer key : allElements.keySet()) {
        if (allElements.get(key) == element) {
            keyToRemove = key;
            break;
        }
    }
    if (keyToRemove == null) {
        return;
    }
    allElements.remove(keyToRemove);
    TreeMap<Integer, Element> newMap = new TreeMap<>();
    int newIndex = 0;
    for (Element elem : allElements.values()) {
        newMap.put(newIndex++, elem);
    }
    allElements.clear();
    allElements.putAll(newMap);
}

    public void updateElement(Integer id, Element element) {
        allElements.replace(id, element);
    }

    public static Tags toTags(String string) {
        return switch (string) {
            case "Urgent" -> Tags.Urgent;
            case "Priority" -> Tags.Priority;
            case "ToBeTreated" -> Tags.ToBeTreated;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
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
