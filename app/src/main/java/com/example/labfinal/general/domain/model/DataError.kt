package com.example.labfinal.general.domain.model

import com.example.labfinal.general.domain.network.util.Error

enum class DataError: Error {
    NO_INTERNET,
    GENERIC_ERROR
}