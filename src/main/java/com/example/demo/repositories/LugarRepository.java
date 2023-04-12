package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.LugarModel;

public interface LugarRepository extends CrudRepository<LugarModel, Long>  {
    
}
