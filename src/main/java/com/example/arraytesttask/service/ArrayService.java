package com.example.arraytesttask.service;

import com.example.arraytesttask.exceptions.ArrayNotValidException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ArrayService {

    //define default value when not have missing numbers
    @Value("${valueIfNotExist}")
    int valueIfNotExistMissing;

    //i choose sort with iterate method because i assumed that array can contains more than one missing number
    //in other conditions i'd prefer to use method with sum difference to find missing number
    public int getMissingNumberFromArray(int[] numbers){
        if(numbers == null || numbers.length == 0)
            throw new ArrayNotValidException("Array of numbers can not be empty");
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i-1] != 1) {
                return numbers[i-1]+1;
            }
        }
        return valueIfNotExistMissing;
    }
}
