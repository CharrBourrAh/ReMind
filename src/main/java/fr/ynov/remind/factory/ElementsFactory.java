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


    public void addElement(Element element) throws Exception {
        try {
            // adding elements to the TreeMap using the size of the TreeMap as the key
            allElements.put(allElements.size(), element);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * This method removes an element from the list of elements.
     * @param element
     * @throws Exception
     */
    public void removeElement(Element element) throws Exception {
        Integer keyToRemove = null;
        // Find the key associated with the element to be removed
        for (Integer key : allElements.keySet()) {
            if (allElements.get(key) == element) {
                keyToRemove = key;
                break;
            }
        }
        if (keyToRemove == null) {
            return; // If the element isn't found
        }
        try {
            // Remove the element from the TreeMap
            allElements.remove(keyToRemove);

            // Re-indexing the TreeMap
            TreeMap<Integer, Element> newMap = new TreeMap<>();
            int newIndex = 0;
            for (Element elem : allElements.values()) {
                newMap.put(newIndex++, elem);
            }
            allElements.clear();
            allElements.putAll(newMap);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * This method calculates the time in days following the given year, month and day.
     *
     * @param year
     * @param month
     * @param day
     * @return integer
     */
    private static int timeCalculation(int year, int month, int day) {
        int result = 0;
        for (int j = 0; j < year; j++) {
            if (j % 4 == 0) {
                result += 366; // leap year
            } else {
                result += 365; // normal year
            }
        }
        for (int i = month; i > 0; i--) {
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> result += 31;
                case 4, 6, 9, 11 -> result += 30;
                case 2 -> {
                    if (year % 4 == 0) {
                        result += 29; // february leap year
                    } else {
                        result += 28; // february normal year
                    }
                }
            }
        }
        return result + day;
    }

    public static int remainingTime(int year1, int month1, int day1) {
        Calendar localDate = Calendar.getInstance();
        // Get the current date
        return timeCalculation(year1, month1, day1) - timeCalculation(localDate.get(Calendar.YEAR), localDate.get(Calendar.MONTH) + 1, localDate.get(Calendar.DAY_OF_MONTH));
    }

    public static Tags stringToTag(String tag) {
        return switch (tag) {
            case "ToBeTreated" -> Tags.ToBeTreated;
            case "Priority" -> Tags.Priority;
            default -> Tags.Urgent;
        };
    }
}
