package com.example.composequizapp.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composequizapp.data.DataOrException
import com.example.composequizapp.model.QuestionItem
import com.example.composequizapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val questionRepository: QuestionRepository): ViewModel() {
    private val data : MutableState<DataOrException<ArrayList<QuestionItem>,Boolean, Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = questionRepository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }

}