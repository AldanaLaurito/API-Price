package com.aldanalaurito.apiprice.exceptions;

import com.aldanalaurito.apiprice.helper.Constants;

public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException() {
        super(Constants.PRICE_NOT_FOUND_ERROR_DTO);
    }
}