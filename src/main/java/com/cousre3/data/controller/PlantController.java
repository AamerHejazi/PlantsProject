package com.cousre3.data.controller;

import com.cousre3.data.DTO.PlantDTO;
import com.cousre3.data.Entity.Plant;
import com.cousre3.data.service.PlantService;
import com.cousre3.data.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public PlantDTO getPlantDTO(String name){
        return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    @PostMapping
    public void consumePlant(@RequestBody PlantDTO plantDTO){
        
    }

    private static PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    private static Plant convertPlantDTOToPlantEntity(PlantDTO plantDTO){
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDTO, plant);
        return plant;
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }
}
