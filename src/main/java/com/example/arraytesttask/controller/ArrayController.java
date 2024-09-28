package com.example.arraytesttask.controller;

import com.example.arraytesttask.dto.ArrayWrapper;
import com.example.arraytesttask.service.ArrayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/array")
@RequiredArgsConstructor
public class ArrayController {

    private final ArrayService arrayService;

    //method returns missing number or default value if there are no missing numbers in array.
    //default value defined in app properties
    //let's suppose that array contains positive numbers only
    //request example: /array/get-missing-number?numbers=1&numbers=3&numbers=4&numbers=5
    @GetMapping(value = "/get-missing-number")
    public int getMissingNumberFromArray(@ModelAttribute("wrapper") ArrayWrapper wrapper){
        int[] numbers = wrapper.getNumbers();
        return arrayService.getMissingNumberFromArray(numbers);
    }
}
