package com.example.composequizapp.di

import com.example.composequizapp.model.Question
import com.example.composequizapp.network.QuestionApi
import com.example.composequizapp.repository.QuestionRepository
import com.example.composequizapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideQuestionApi() : QuestionApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
    @Singleton
    @Provides
    fun provideQuestionRepository(questionApi: QuestionApi) : QuestionRepository{
        return QuestionRepository(questionApi)
    }
}