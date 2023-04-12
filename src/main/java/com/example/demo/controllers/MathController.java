package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.demo.models.SumModelResponse;
import com.example.demo.services.MathService;

@RestController
@RequestMapping("/math")
public class MathController {
    @Autowired
    MathService mathService;

    @PostMapping("/happy")
    public String isHappy(@RequestBody String valores){
        String[] lst = valores.split(",");
        ArrayList<Integer> vals = new ArrayList<>();
        for (int i = 0; i < lst.length; i++) {
            try {
                vals.add(Integer.parseInt(lst[i]));
            } catch (Exception e) {
                return "No es posible calcular si es feliz o no";
            }
        }
        return mathService.verificarNumeroFeliz(vals);
    }

    @PostMapping(path = "/sum")
    public SumModelResponse sumatoria(@RequestBody String numero){
        SumModelResponse response = new SumModelResponse();
        response.setResult(mathService.sumatoria(Integer.parseInt(numero)));
        return response;
    }
}
