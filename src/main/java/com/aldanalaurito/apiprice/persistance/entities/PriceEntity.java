package com.aldanalaurito.apiprice.persistance.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRICE_LIST")
    @JsonProperty("price_list")
    Integer priceList;

    @NotNull
    @Column(name = "BRAND_ID")
    @JsonProperty("brand")
    Integer brandId;

    @NotNull
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
    @Column(name = "START_DATE")
    @JsonProperty("start_date")
    LocalDateTime startDate;

    @NotNull
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
    @Column(name = "END_DATE")
    @JsonProperty("end_date")
    LocalDateTime endDate;

    @NotNull
    @Column(name = "PRODUCT_ID")
    @JsonProperty("product")
    Long productId;

    @NotNull
    @Column(name = "PRIORITY")
    @JsonProperty("priority")
    Integer priority;

    @NotNull
    @Column(name = "PRICE")
    @JsonProperty("price")
    BigDecimal price;

    @NotEmpty
    @Column(name = "CURR")
    @JsonProperty("currency")
    String curr;
}
