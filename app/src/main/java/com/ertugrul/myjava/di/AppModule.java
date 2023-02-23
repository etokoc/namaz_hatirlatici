package com.ertugrul.myjava.di;

import com.ertugrul.myjava.data.api.ApiService;
import com.ertugrul.myjava.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public static Retrofit providesRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Constants.BASE_URL);
        builder.client(new OkHttpClient());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava3CallAdapterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    public static ApiService providesService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
