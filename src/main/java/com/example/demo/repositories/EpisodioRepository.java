package com.example.demo.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.EpisodioModel;

@Repository
public interface EpisodioRepository extends CrudRepository<EpisodioModel, Long>  {
    
}
