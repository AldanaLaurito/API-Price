package com.aldanalaurito.apiprice;

import com.aldanalaurito.apiprice.controller.dto.ProductPriceResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EndToEndTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void endpoint_obtainProductPriceByDateAndBrand_ok_testCase1() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "35455")
                                .queryParam("datetime", "2020-06-14T10:00:00"))
                .andExpect(status().isOk()).andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getContentAsString().isEmpty());
        ProductPriceResponseDTO responseDto = new ObjectMapper().readValue(response.getContentAsString(), ProductPriceResponseDTO.class);
        Assertions.assertEquals(1, responseDto.getPriceList());
    }

    @Test
    void endpoint_obtainProductPriceByDateAndBrand_ok_testCase2() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "35455")
                                .queryParam("datetime", "2020-06-14T16:00:00"))
                .andExpect(status().isOk()).andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getContentAsString().isEmpty());
        ProductPriceResponseDTO responseDto = new ObjectMapper().readValue(response.getContentAsString(), ProductPriceResponseDTO.class);
        Assertions.assertEquals(2, responseDto.getPriceList());
    }

    @Test
    void endpoint_obtainProductPriceByDateAndBrand_ok_testCase3() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "35455")
                                .queryParam("datetime", "2020-06-14T21:00:00"))
                .andExpect(status().isOk()).andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getContentAsString().isEmpty());
        ProductPriceResponseDTO responseDto = new ObjectMapper().readValue(response.getContentAsString(), ProductPriceResponseDTO.class);
        Assertions.assertEquals(1, responseDto.getPriceList());
    }

    @Test
    void endpoint_obtainProductPriceByDateAndBrand_ok_testCase4() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "35455")
                                .queryParam("datetime", "2020-06-15T10:00:00"))
                .andExpect(status().isOk()).andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getContentAsString().isEmpty());
        ProductPriceResponseDTO responseDto = new ObjectMapper().readValue(response.getContentAsString(), ProductPriceResponseDTO.class);
        Assertions.assertEquals(3, responseDto.getPriceList());
    }

    @Test
    void endpoint_obtainProductPriceByDateAndBrand_ok_testCase5() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        get("/api/v1/prices/obtainPrice")
                                .queryParam("brand", "1")
                                .queryParam("product", "35455")
                                .queryParam("datetime", "2020-06-16T21:00:00"))
                .andExpect(status().isOk()).andReturn().getResponse();
        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.getContentAsString().isEmpty());
        ProductPriceResponseDTO responseDto = new ObjectMapper().readValue(response.getContentAsString(), ProductPriceResponseDTO.class);
        Assertions.assertEquals(4, responseDto.getPriceList());
    }
}