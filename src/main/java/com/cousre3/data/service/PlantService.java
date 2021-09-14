package com.cousre3.data.service;

import com.cousre3.data.Entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
