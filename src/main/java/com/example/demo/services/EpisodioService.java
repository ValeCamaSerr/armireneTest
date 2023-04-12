package com.example.demo.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.EpisodioModel;
import com.example.demo.models.EpisodioResponseModel;
import com.example.demo.models.LugarModel;
import com.example.demo.models.LugarResponseModel;
import com.example.demo.models.PersonajeModel;
import com.example.demo.models.PersonajeResponseModel;
import com.example.demo.models.ResponseModel;
import com.example.demo.repositories.EpisodioRepository;
import com.example.demo.repositories.LugarRepository;
import com.example.demo.repositories.PersonajeRepository;

@Service
public class EpisodioService {
    @Autowired
    EpisodioRepository episodioRepository;
    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    LugarRepository lugarRepository;
    ResponseModel rta = new ResponseModel();
    PersonajeModel pM = new PersonajeModel();
    LugarModel lM = new LugarModel();
    final String URL = "https://rickandmortyapi.com/api/";

    public ResponseModel obtenerEpisodio(Long numEpisodio){
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<EpisodioResponseModel> response = restTemplate.getForEntity(URL+"episode/"+numEpisodio, EpisodioResponseModel.class);
        EpisodioResponseModel result = response.getBody();
        rta.setEpisode(result.getEpisode());
        rta.setEpisodeName(result.getName());
        EpisodioModel episodioModel = new EpisodioModel();
        episodioModel.setId(result.getId());
        episodioModel.setNombre(result.getName());

        EpisodioModel existingEpisodio = episodioRepository.findById(episodioModel.getId()).orElse(null);
        if(existingEpisodio == null){
            this.guardarEpisodio(episodioModel);
        }
        else{
            System.out.println("Episodio agregado con anterioridad");
        }
        List<String> listaPersonajes = result.getCharacters();
        List<PersonajeResponseModel> resultPersonajes = new ArrayList<PersonajeResponseModel>();
        for ( String lP : listaPersonajes) {
            PersonajeResponseModel personajeResponse = this.buscarPersonaje(result,lP);
            resultPersonajes.add(personajeResponse);
        }
        rta.setCharacter(resultPersonajes);
        return rta;
    }

    public PersonajeResponseModel buscarPersonaje(EpisodioResponseModel episodioResponse,String url){
        RestTemplate restTemplate= new RestTemplate();
        PersonajeResponseModel result = null;
        if(url != null && url != ""){
            ResponseEntity<PersonajeResponseModel> response = restTemplate.getForEntity(url, PersonajeResponseModel.class);
            result = response.getBody();
            pM.setId(result.getId());
            pM.setNombre(result.getName());
            pM.setEspecie(result.getSpecies());
            pM.setGenero(result.getGender());
            pM.setImagen(result.getImage());
            // EpisodioPersonajeModel epM = new EpisodioPersonajeModel();
            // epM.setIdEpisodio(episodioResponse.getId());
            // epM.setIdPersonaje(pM.getId());
            // episodioPersonajeRepository.save(epM);
            PersonajeModel existingPersonaje = personajeRepository.findById(pM.getId()).orElse(null);
            if(existingPersonaje == null){
                personajeRepository.save(pM);
            }
            else{
                System.out.println("Personaje agregado con anterioridad");
            }
            Long idLugar = buscarLugar(result.getLocation().getUrl());
            if(idLugar != null){
                pM.setIdLugar(idLugar);
            }
                
        }        
        return result;
    }    

    public Long buscarLugar(String url){
        RestTemplate restTemplate= new RestTemplate();
        LugarResponseModel result = null;
        if(url != null && url != "" ){
            ResponseEntity<LugarResponseModel> response = restTemplate.getForEntity(url, LugarResponseModel.class);
            result = response.getBody();
            lM.setId(result.getId());
            lM.setNombre(result.getName());
            lM.setDimension(result.getDimension());
            lM.setTipo(result.getType());
            LugarModel existingLugar = lugarRepository.findById(lM.getId()).orElse(null);
            if(existingLugar == null){
                lugarRepository.save(lM);
            }
            else{
                System.out.println("Lugar agregado con anterioridad");
            }    

            return result.getId();
        }
       
        return null;
    }   

    public EpisodioModel guardarEpisodio(EpisodioModel episodio){
        return episodioRepository.save(episodio);
    }
}
