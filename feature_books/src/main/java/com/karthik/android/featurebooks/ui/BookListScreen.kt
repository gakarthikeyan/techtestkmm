package com.karthik.android.featurebooks.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.karthik.android.common.data.model.Book
import com.karthik.android.featurebooks.presentation.BookViewModel
/**
 * KMM POC
 *
 * BookListScreen hold UI components
 * to display books list
 *
 */
@Composable
fun BookListScreen(viewModel: BookViewModel = hiltViewModel()){
    var showProgress by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        showProgress = true
    }
    LoadingSpinner(isShowProgress = showProgress)

    viewModel.books.observeAsState().value?.let { books ->
        showProgress = false
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(books.books) { book ->
                BookItem(book)

            }
        }
    }


}

/**
 * Composable fun to setup custom UI
 *
 * to display individual book item
 *
 */
@Composable
fun BookItem(book: Book) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable {
//            onBookClick(book)
                                                                   },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(book.image),
            contentDescription = book.title,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = book.title, style = MaterialTheme.typography.titleMedium)
            Text(text = book.authors, style = MaterialTheme.typography.bodySmall)
        }
    }
}

/**
 * Compose function to display loading icon
 * which will indicate network/background call
 */
@Composable
fun LoadingSpinner(isShowProgress: Boolean) {
    if(isShowProgress){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                color = Color.Blue,
                strokeWidth = 4.dp
            )
        }
    }

}