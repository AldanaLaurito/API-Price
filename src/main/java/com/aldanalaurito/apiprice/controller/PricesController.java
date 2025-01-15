package com.aldanalaurito.apiprice.controller;

import com.aldanalaurito.apiprice.controller.dto.ErrorDTO;
import com.aldanalaurito.apiprice.controller.dto.ProductPriceResponseDTO;
import com.aldanalaurito.apiprice.helper.Constants;
import com.aldanalaurito.apiprice.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(path = "/api/v1/prices")
public class PricesController {

    @Autowired
    private final PriceService priceService;

    public PricesController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(tags = "Prices", summary = "Obtain current product price", description = "Obtain price to apply at a certain date and time for a product of a brand")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Price", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductPriceResponseDTO.class), examples = @ExampleObject(name = "Price to apply", value = Constants.PRODUCT_PRICE_RESPONSE_DTO_EXAMPLE))}),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDTO.class), examples = @ExampleObject(name = "CONFLICT", value = Constants.PRICE_NOT_FOUND_ERROR_DTO))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)})
    @GetMapping("/obtainPrice")
    @ResponseStatus(HttpStatus.OK)
    public ProductPriceResponseDTO obtainProductPriceByDateAndBrand(@RequestParam("brand") int brandId,
                                                                    @RequestParam("product") long productId,
                                                                    @RequestParam("datetime") String datetime){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
        LocalDateTime formattedDate = LocalDateTime.parse(datetime, formatter);

        return priceService.obtainProductPriceByDateAndBrand(brandId, productId, formattedDate);
    }
}
