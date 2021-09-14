package com.cousre3.data.controller;

import com.cousre3.data.Entity.Delivery;
import com.cousre3.data.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    public Delivery getDelivery(@PathVariable("deliveryId") Long id){
        System.out.println(id);
        return deliveryService.getDelivery(id);
    }

}

