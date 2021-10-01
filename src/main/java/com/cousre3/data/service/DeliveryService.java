package com.cousre3.data.service;

import com.cousre3.data.DTO.RecipientAndPriceDTO;
import com.cousre3.data.Entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPriceDTO getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Delivery getDelivery(Long id) {
        return deliveryRepository.find(id);
    }
}
