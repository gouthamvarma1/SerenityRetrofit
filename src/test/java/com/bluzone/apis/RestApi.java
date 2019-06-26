package com.bluzone.apis;

import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestApi {
	 @GET("api/users?page=2")
	    Call<JsonNode> beaconViews();
	 
	 @GET("api/users/{id}")
	    Call<JsonNode> singleUser(@Path("id")String id);
	 
	 @POST("api/users")
		Call<JsonNode> createuser(@Body CreateUserRequest createUserRequest);
	 
	 @POST("v2/pet")
		Call<JsonNode> swaggerPost(@Body SamplePost samplepost);
}
