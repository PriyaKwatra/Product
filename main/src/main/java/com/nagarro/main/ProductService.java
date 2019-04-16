package com.nagarro.main;

import com.nagarro.aggregates.api.product.CreateProductSubscriber;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ProductService {

    public static void main(String[] args) throws IOException, TimeoutException {

        CreateProductSubscriber createProductSubscriber = new CreateProductSubscriber();
        createProductSubscriber.onCreateProductMessage();
    }
}
