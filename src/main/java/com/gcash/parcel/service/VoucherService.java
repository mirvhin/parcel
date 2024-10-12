package com.gcash.parcel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.gcash.parcel.model.VoucherResponse;

@Service
public class VoucherService {

  private static final Logger logger = LoggerFactory.getLogger(VoucherService.class);

  private final RestTemplate restTemplate;
  private final String voucherApiUrl;
  private final String apiKey;

  public VoucherService(RestTemplate restTemplate, @Value("${voucher.api.url}") String voucherApiUrl,  @Value("${voucher.api.apiKey}") String apiKey) {
      this.restTemplate = restTemplate;
      this.voucherApiUrl = voucherApiUrl;
      this.apiKey = apiKey;
  }


  public double getVoucherDiscount(String voucherCode) {
    String url = String.format("%s%s?key=%s", voucherApiUrl, voucherCode, apiKey);
    try {
      VoucherResponse response = restTemplate.getForObject(url, VoucherResponse.class);
      return response != null ? response.getDiscount() : 0;
    } catch (HttpStatusCodeException e) {
      logger.error("HTTP Status {} when calling voucher service: {}", e.getStatusCode(), e.getMessage());
      return 0; // Return a default value or handle it as needed
    } catch (Exception e) {
      logger.error("Unexpected error when calling voucher service: {}", e.getMessage());
      return 0; // Return a default value or handle it as needed
    }
  }
}