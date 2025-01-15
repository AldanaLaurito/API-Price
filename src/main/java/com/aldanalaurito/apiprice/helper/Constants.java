package com.aldanalaurito.apiprice.helper;

public class Constants {
    private Constants(){}
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String PRODUCT_PRICE_RESPONSE_DTO_EXAMPLE = "{\"PRODUCT_ID\":35455,\"BRAND_ID\":1,\"PRICE_LIST\":1,\"PRICE\":35.5, \"CURR\":\"EUR\",\"START_DATE\":\"2020-06-14T00:00:00\",\"END_DATE\":\"2020-12-31T23:59:59\"}";

    public static final String ERROR_DTO = "{\"ERROR_DETAIL\": \"No price list was found for the brand, product or date given.\"}";
}
