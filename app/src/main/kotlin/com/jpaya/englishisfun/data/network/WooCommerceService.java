package com.jpaya.englishisfun.data.network;

import com.jpaya.englishisfun.data.network.model.ProductNetworkItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WooCommerceService {
    @GET("products")
    Call<List<ProductNetworkItem>> listProducts();
}
