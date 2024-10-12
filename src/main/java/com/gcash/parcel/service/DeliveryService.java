package com.gcash.parcel.service;

import org.springframework.stereotype.Service;

import com.gcash.parcel.model.Parcel;

@Service
public class DeliveryService {
    private final VoucherService voucherService;

    public DeliveryService(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    public double calculateCost(Parcel parcel) {
        double weight = parcel.getWeight();
        double volume = parcel.getHeight() * parcel.getWidth() * parcel.getLength();

        if (weight > 50) {
            throw new IllegalArgumentException("Weight exceeds 50kg, delivery rejected.");
        } else if (weight > 10) {
            return 20 * weight;
        } else if (volume < 1500) {
            return 0.03 * volume;
        } else if (volume < 2500) {
            return 0.04 * volume;
        } else {
            return 0.05 * volume;
        }
    }

    public double applyVoucherDiscount(double cost, String voucherCode) {
        // Integrate with external voucher service to get discount details
        double discount = voucherService.getVoucherDiscount(voucherCode);
        return cost - discount;
    }
}