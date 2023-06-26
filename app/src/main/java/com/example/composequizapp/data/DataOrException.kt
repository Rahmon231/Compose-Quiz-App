package com.example.composequizapp.data

import java.lang.Exception

data class DataOrException<T, Boolean, E : Exception>(
    var data : T? = null,
    var loading : Boolean? = null,
    var exception : E? = null
)