package com.cousre3.data.controller;

import com.cousre3.data.Entity.Delivery;
import com.cousre3.data.service.DeliveryService;
import com.cousre3.data.DTO.RecipientAndPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        System.out.println("Here");
        return deliveryService.save(delivery);
    }

    @GetMapping("/{deliveryId}")
    public Delivery getDelivery(@PathVariable("deliveryId") Long id) {
        System.out.println(id);
        return deliveryService.getDelivery(id);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPriceDTO getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}



