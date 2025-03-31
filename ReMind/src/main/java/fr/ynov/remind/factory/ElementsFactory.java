package main.java.fr.ynov.remind.factory;

import main.java.fr.ynov.remind.domain.Element;
import main.java.fr.ynov.remind.domain.Tags;

import java.util.Calendar;
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

    public void updateElement(Element element) {
        for (Integer key : allElements.keySet()) {
            if (allElements.get(key) == element) {
                allElements.replace(key, element);
                return;
            }
        }
    }

    private static int timeCalculation(int year, int month, int day) {
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

    public static int remainingTime(int year1, int month1, int day1) {
        Calendar localDate = Calendar.getInstance();
        return timeCalculation(year1, month1, day1) - timeCalculation(localDate.get(Calendar.YEAR), localDate.get(Calendar.MONTH)+1, localDate.get(Calendar.DAY_OF_MONTH));
    }

    public static Tags stringToTag(String tag) {
        return switch (tag) {
            case "ToBeTreated" -> Tags.ToBeTreated;
            case "Priority" -> Tags.Priority;
            default -> Tags.Urgent;
        };
    }
}
