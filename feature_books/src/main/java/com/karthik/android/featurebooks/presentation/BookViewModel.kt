package com.karthik.android.featurebooks.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karthik.android.common.data.model.BookList
import com.karthik.android.common.domain.interactor.BookInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val bookInteractor: BookInteractor): ViewModel() {

    private val _books : MutableLiveData<BookList> = MutableLiveData()

    val books :MutableLiveData<BookList> get() = _books

    init {
        fetchBooks()
    }

    fun fetchBooks(){
        viewModelScope.launch {
            _books.value = bookInteractor.executeRemote()

        }

    }
}