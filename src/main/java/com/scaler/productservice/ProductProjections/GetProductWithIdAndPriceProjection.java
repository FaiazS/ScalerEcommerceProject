package com.scaler.productservice.ProductProjections;

import org.springframework.data.web.ProjectedPayload;


public interface GetProductWithIdAndPriceProjection {

    Long getId();

    Double getPrice();

}
