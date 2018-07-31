package com.brewmapp.brewmapp.features.main.product.data

import com.brewmapp.brewmapp.features.main.product.data.model.Product
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Result
import retrofit2.http.*
import rx.Observable

interface ProductApi {
    @FormUrlEncoded
    @Headers("api-version: 1.05")
    @POST("beer/beer")
    fun getProduct(@Field("Beer[id]") id: String) : Observable<Product>


}