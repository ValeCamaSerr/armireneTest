package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.models.HappyNumberModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class MathService {

    public String verificarNumeroFeliz(List<Integer> lista){
        List<HappyNumberModel> happyNumberList = new ArrayList<HappyNumberModel>();
        for (int i = 0; i < lista.size(); i++) {
            HappyNumberModel happyNumber = new HappyNumberModel();
            int number = lista.get(i);
            happyNumber.setNumber(number);
            happyNumber.setIsHappy(this.isHappy(number));
            happyNumberList.add(happyNumber);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(happyNumberList);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
     
        while(!set.contains(n)){
            set.add(n);
     
            n = getSuma(n);
     
            if(n==1)
                return true;
        }
     
        return false;
    }
     
    public int getSuma(int n){
        int sum = 0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        } 
        return sum;    
    }

    public int sumatoria(int numero){
        int suma = sumarNumeros(numero);

        return suma;
    }

    public int sumarNumeros(int num) {
        if (num != 0)
            return num + sumarNumeros(num - 1);
        else
            return num;
    }
}
