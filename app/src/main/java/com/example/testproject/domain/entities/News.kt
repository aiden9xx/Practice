package com.example.testproject.domain.entities

import com.example.testproject.data.model.Article

data class News(
    var status: String?,
    var totalResults: Int?,
    var articles: List<Article>
)