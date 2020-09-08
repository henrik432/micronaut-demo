package com.example

data class ViewerResponse(
        val data: Data
)

data class Data(
        val viewer: Viewer
)

data class Viewer(
        val login: String
)
