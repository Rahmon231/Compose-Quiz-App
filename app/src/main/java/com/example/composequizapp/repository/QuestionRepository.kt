package com.example.composequizapp.repository

import android.util.Log
import com.example.composequizapp.data.DataOrException
import com.example.composequizapp.model.QuestionItem
import com.example.composequizapp.network.QuestionApi
import java.lang.Exception
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val questionApi: QuestionApi) {
    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>,
            Boolean,
            Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionItem>, Boolean, Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = questionApi.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false
        }catch (e: Exception){
            dataOrException.exception = e
            Log.d("Exc", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")

        }
        return dataOrException
    }
}