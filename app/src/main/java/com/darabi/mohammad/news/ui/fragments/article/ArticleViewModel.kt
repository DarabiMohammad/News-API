package com.darabi.mohammad.news.ui.fragments.article

import com.darabi.mohammad.news.repository.AbstractRepository
import com.darabi.mohammad.news.ui.base.BaseViewModel
import com.darabi.mohammad.news.utils.PAGING_SIZE
import com.darabi.mohammad.news.utils.enums.Language
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val repository: AbstractRepository
) : BaseViewModel() {

    internal var pageNumber = 0
        private set

    private val simpleSearchWord: String = "bitcoin"

    // todo : hard coded function. in a real implementation, searchWord and language must be passed to this function from ui layer.
    fun getArticles() = loadingLiveData {
        repository.getArticles(simpleSearchWord, Language.English.code, PAGING_SIZE, ++pageNumber)
    }
}