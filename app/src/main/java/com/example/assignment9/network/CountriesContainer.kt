package com.example.assignment9.network

data class CountriesContainer (
    val error: Boolean,
    val msg: String,
    val data: List<Countries>
)