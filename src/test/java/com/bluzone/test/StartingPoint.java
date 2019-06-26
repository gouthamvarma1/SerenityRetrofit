package com.bluzone.test;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bluzone.apis.RestApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" }, features = "src/test/resources/feature", glue = {
        "com/bluzone/definitions", "com/bluzone/steps" }, tags = { "@sanity" })

@Configuration
@ComponentScan(basePackages = { "com.bluzone" })
public class StartingPoint {

    @Bean
    public RestApi disposableEmailAPI() {
        //Retrofit retrofit = createRetrofit("https://reqres.in/");
    	Retrofit retrofit = createRetrofit("https://petstore.swagger.io/");
        return retrofit.create(RestApi.class);
    }

    private Retrofit createRetrofit(String url) {
        //Logging in console
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Actual http call
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        JacksonConverterFactory factory = JacksonConverterFactory.create(new ObjectMapper());
        return new Retrofit.Builder().client(okHttpClient).addConverterFactory(factory).baseUrl(url).build();
    }

}
