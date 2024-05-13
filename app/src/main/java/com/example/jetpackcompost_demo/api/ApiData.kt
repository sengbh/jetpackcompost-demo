package com.example.jetpackcompost_demo.api

import kotlinx.serialization.Serializable


@Serializable
data class ApiData(
    var count    : Int?               = null,
    var next     : String?            = null,
    var previous : String?            = null,
    var results  : ArrayList<Results> = arrayListOf()
){

}
