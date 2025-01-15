package com.aldanalaurito.apiprice.service;

import com.aldanalaurito.apiprice.controller.dto.ProductPriceResponseDTO;

import java.time.LocalDateTime;

public interface PriceService {
    ProductPriceResponseDTO obtainProductPriceByDateAndBrand(int brandId, long productId, LocalDateTime dateApplication);
}
