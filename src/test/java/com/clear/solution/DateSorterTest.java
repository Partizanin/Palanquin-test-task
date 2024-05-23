package com.clear.solution;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateSorterTest {

    private final DateSorter dateSorter = new DateSorter();

    @Test
    void sortDates() {
        var expectedDates = List.of(
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(20032, 5, 3),
                LocalDate.of(2004, 7, 1)
        );
        var  unsortedDates = List.of(
                LocalDate.of(2004, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2007, 1, 1),
                LocalDate.of(20032, 5, 3)
        );

        var actualDates = dateSorter.sortDates(unsortedDates);

        assertEquals(expectedDates, actualDates);
    }

    @Test
    void sortDatesWithEmptyNullInputValues() {
        assertThrows(IllegalArgumentException.class, () -> dateSorter.sortDates(List.of()));
        assertThrows(IllegalArgumentException.class, () -> dateSorter.sortDates(null));
    }
}