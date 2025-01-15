package com.aldanalaurito.apiprice.controller.advice;

import com.aldanalaurito.apiprice.controller.PricesController;
import com.aldanalaurito.apiprice.exceptions.PriceNotFoundException;
import com.aldanalaurito.apiprice.service.PriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PricesControllerAdviceTest {

    @Mock
    PriceService priceService;

    @InjectMocks
    PricesController pricesController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(pricesController).setControllerAdvice(new PricesControllerAdvice()).build();
    }

    @Test
    void endpoints_returns_custom_exception_price_not_found() throws Exception {
        when(priceService.obtainProductPriceByDateAndBrand(anyInt(), anyLong(), any())).thenThrow(new PriceNotFoundException());

        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "123545")
                                .queryParam("datetime", "2020-06-15T10:00:00"))
                .andExpect(status().is4xxClientError()).andReturn().getResponse();

        Assertions.assertTrue(response.getContentAsString().contains("No price list"));
    }

    @Test
    void endpoints_returns_generic_runtime_exception() throws Exception {
        when(priceService.obtainProductPriceByDateAndBrand(anyInt(), anyLong(), any())).thenThrow(new RuntimeException("Test RunTime"));

        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "123545")
                                .queryParam("datetime", "2020-06-15T10:00:00"))
                .andExpect(status().is5xxServerError()).andReturn().getResponse();

        Assertions.assertTrue(response.getContentAsString().contains("Test RunTime"));
    }
}