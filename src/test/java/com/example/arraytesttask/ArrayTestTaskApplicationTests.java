package com.example.arraytesttask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.arraytesttask.exceptions.ArrayNotValidException;
import com.example.arraytesttask.service.ArrayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class ArrayTestTaskApplicationTests {

    //define default value when not have missing numbers
    @Value("${valueIfNotExist}")
    int valueIfNotExist;

    @Autowired
    private ArrayService arrayService;

    @Test
    void haveMissingInShuffledArray() {
        assertEquals(6, arrayService.getMissingNumberFromArray(new int[]{3, 4, 7, 8, 5}));
    }
    @Test
    void notHaveMissingInShuffledArray() {
        assertEquals(valueIfNotExist, arrayService.getMissingNumberFromArray(new int[]{3, 4, 7, 6, 5}));
    }
    @Test
    void haveMissingWithDoubleValues() {
        assertEquals(6, arrayService.getMissingNumberFromArray(new int[]{3, 3, 7, 5, 5}));
    }
    @Test
    void oneElementArray() {
        assertEquals(valueIfNotExist, arrayService.getMissingNumberFromArray(new int[]{3}));
    }
    @Test
    void emptyArrayException() {
        assertThrows(ArrayNotValidException.class, () -> arrayService.getMissingNumberFromArray(new int[]{}));
    }
    @Test
    void performanceTest() {
        int[] numbers = IntStream.rangeClosed(1, 10000)
                .filter(i -> i != 9999)
                .toArray();
        assertEquals(9999, arrayService.getMissingNumberFromArray(numbers));
    }

}
