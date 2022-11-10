package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.Typography
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview

sealed class MovieCategoryLabelTextViewState {
    data class Text(val text: String) : MovieCategoryLabelTextViewState()
    data class TextRes(@StringRes val textRes: Int) : MovieCategoryLabelTextViewState()
}


data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

@Composable
fun MovieCategory(
    labelViewState: MovieCategoryLabelViewState,
    onItemClick: (MovieCategoryLabelViewState) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        when (labelViewState.categoryText) {
            is MovieCategoryLabelTextViewState.Text -> {
                Text(
                    text = labelViewState.categoryText.text,
                    style = Typography.h5,
                    color = colorResource(id = if (labelViewState.isSelected) R.color.black else R.color.grey_text),
                    textDecoration = if (labelViewState.isSelected) TextDecoration.Underline else TextDecoration.None,
                    modifier = Modifier
                        .clickable { onItemClick(labelViewState) }

                )
            }
            is MovieCategoryLabelTextViewState.TextRes -> {
                Text(
                    text = stringResource(id = labelViewState.categoryText.textRes),
                    style = Typography.h5,
                    color = colorResource(id = if (labelViewState.isSelected) R.color.black else R.color.grey_text),
                    textDecoration = if (labelViewState.isSelected) TextDecoration.Underline else TextDecoration.None,
                    modifier = Modifier
                        .clickable { onItemClick(labelViewState) }

                )
            }
        }

    }
}

@Preview
@Composable
fun MovieCategoryPreview() {
    var isSelectedFirst by remember { mutableStateOf(true) }
    var isSelectedSecond by remember { mutableStateOf(false) }
    Row {
        MovieCategory(
            MovieCategoryLabelViewState(
                1,
                isSelectedFirst,
                MovieCategoryLabelTextViewState.Text("Movie")
            ),
            onItemClick = {
                isSelectedFirst = true
                isSelectedSecond = false
            }
        )
        MovieCategory(
            MovieCategoryLabelViewState(
                1,
                isSelectedSecond,
                MovieCategoryLabelTextViewState.Text("Movie")
            ),
            onItemClick = {
                isSelectedFirst = false
                isSelectedSecond = true
            }
        )
    }

}