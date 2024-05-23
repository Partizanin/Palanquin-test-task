package com.clear.solution;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (unsortedDates == null || unsortedDates.isEmpty()) {
            throw new IllegalArgumentException("Unsorted dates cannot be empty or null");
        }

        ArrayList<LocalDate> datesWithR = unsortedDates.stream().filter(this::containRInMonthName).sorted().collect(Collectors.toCollection(ArrayList::new));
        List<LocalDate> restOfDates = unsortedDates.stream().filter(it -> !containRInMonthName(it)).sorted(Comparator.reverseOrder()).toList();
        datesWithR.addAll(restOfDates);

        return datesWithR;
    }

    private boolean containRInMonthName(LocalDate it) {
        String name = it.getMonth().name();
        System.out.println(it + " " + name);
        return name.toLowerCase().contains("r");
    }
}