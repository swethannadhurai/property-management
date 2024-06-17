package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class calculatorController {

    //http://localhost:8080//api/v1/calculator/add
    //http://localhost:8080//api/v1/calculator/add?num111=6.7&num222=1.3
    @GetMapping("/add/{num3}")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2,@PathVariable("num3") Double num3){

        return num1 + num2;
    }



    @GetMapping("/sub/{num111}/{num2}")
    public Double subtract(@PathVariable("num111") Double num1, @PathVariable("num2") Double num2) {
        double result;
        if (num1 > num2) {
            result = num1 - num2;
        }
        else {
             result=num2-num1;
        }
        return result;

    }



    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@NotNull @RequestBody CalculatorDTO calculatorDTO){
        double result;
        result= calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        return new ResponseEntity<Double>(result,HttpStatus.CREATED);
    }

}
