package com.example.smart_campus.di

//import com.example.smart_campus.data.remote.MyApi
//import com.example.smart_campus.data.repository.MyRepositoryImpl
//import com.example.smart_campus.domain.repository.MyRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @Provides
//    @Singleton
//    fun provideMyApi(): MyApi{//이걸로 Myapi라는 클래스 만드는 법이다다
//       return Retrofit.Builder().
//        baseUrl("https://test.com").
//        build().
//        create(MyApi::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideMyRepository(api:MyApi):MyRepository{//MyApi 인스턴스가 필요해!! 그건 위에서 찾기 가능
//        return MyRepositoryImpl(api)
//    }
//}