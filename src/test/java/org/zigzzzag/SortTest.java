package org.zigzzzag;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    @Test
    public void sortOldTest() {
        List<String> names = Arrays.asList("Max", "Dima", "Sanya", "Timofei");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Assert.assertEquals(Arrays.asList("Timofei", "Sanya", "Max", "Dima"), names);
    }

    @Test
    public void sortJava8Test() {
        List<String> names = Arrays.asList("Max", "Dima", "Sanya", "Timofei");
        Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

        Assert.assertEquals(Arrays.asList("Timofei", "Sanya", "Max", "Dima"), names);
    }
}
