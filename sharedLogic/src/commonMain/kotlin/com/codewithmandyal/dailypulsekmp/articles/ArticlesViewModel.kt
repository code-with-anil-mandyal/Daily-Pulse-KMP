package com.codewithmandyal.dailypulsekmp.articles

import com.codewithmandyal.dailypulsekmp.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))
    val articleState: StateFlow<ArticleState> get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles(){
        scope.launch {

            delay(2000)

            _articleState.emit(ArticleState(error = "Something went wrong"))

            delay(2000)

            val fetchedArticles = fetchArticles()

            _articleState.emit(ArticleState(articles = fetchedArticles))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles


    private val mockArticles = listOf(
        Article(
            "Title 1",
           "Description 1",
            "2023-11-09",
            "https://fastly.picsum.photos/id/20/3670/2462.jpg?hmac=CmQ0ln-k5ZqkdtLvVO23LjVAEabZQx2wOaT4pyeG10I"
        ),
        Article(
            "Title 2",
            "Description 2",
            "2023-11-09",
            "https://fastly.picsum.photos/id/20/3670/2462.jpg?hmac=CmQ0ln-k5ZqkdtLvVO23LjVAEabZQx2wOaT4pyeG10I"
        ),
        Article(
            "Title 3",
            "Description 3",
            "2023-11-09",
            "https://fastly.picsum.photos/id/20/3670/2462.jpg?hmac=CmQ0ln-k5ZqkdtLvVO23LjVAEabZQx2wOaT4pyeG10I"
        )
    )
}