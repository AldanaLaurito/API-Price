package com.aldanalaurito.apiprice.service;

import com.aldanalaurito.apiprice.controller.dto.ProductPriceResponseDTO;
import com.aldanalaurito.apiprice.exceptions.PriceNotFoundException;
import com.aldanalaurito.apiprice.persistance.entities.PriceEntity;
import com.aldanalaurito.apiprice.persistance.repository.PricesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PricesRepository pricesRepository;

    public ProductPriceResponseDTO obtainProductPriceByDateAndBrand(int brandId, long productId, LocalDateTime dateApplication){

        Optional<PriceEntity> priceEntityOptional = pricesRepository.findFirstByProductIdAndBrandIdAndDatetime(productId, brandId, dateApplication);

        PriceEntity priceEntity = priceEntityOptional.orElseThrow(PriceNotFoundException::new);
        return new ObjectMapper().convertValue(priceEntity, ProductPriceResponseDTO.class);
    }
}
