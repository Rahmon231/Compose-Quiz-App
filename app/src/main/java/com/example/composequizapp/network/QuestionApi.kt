package com.example.composequizapp.network

import com.example.composequizapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions() : Question
}