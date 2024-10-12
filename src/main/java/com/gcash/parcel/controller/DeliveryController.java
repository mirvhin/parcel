package com.gcash.parcel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcash.parcel.model.Parcel;
import com.gcash.parcel.service.DeliveryService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/calculate")
    public double calculateDeliveryCost(@RequestBody Parcel parcel) {
        double cost = deliveryService.calculateCost(parcel);
        if (parcel.getVoucherCode() != null && !parcel.getVoucherCode().isEmpty()) {
            cost = deliveryService.applyVoucherDiscount(cost, parcel.getVoucherCode());
        }
        return cost;
    }
}