package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.proximaNovaFamily
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed class MovieCategoryLabelTextViewState

class MovieCategoryLabelWithText(val text: String) : MovieCategoryLabelTextViewState()
class MovieCategoryLabelWithResource(@StringRes val textRes: Int) :
    MovieCategoryLabelTextViewState()


data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

@Composable
fun MovieCategory(
    labelViewState: MovieCategoryLabelViewState,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.wrapContentSize()) {
        when (labelViewState.categoryText) {
            is MovieCategoryLabelWithText -> {
                Text(
                    text = labelViewState.categoryText.text,
                    fontSize = 16.sp,
                    color = colorResource(id = if (labelViewState.isSelected) R.color.black else R.color.grey_text),
                    fontFamily = proximaNovaFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp),
                    textDecoration = if (labelViewState.isSelected) TextDecoration.Underline else TextDecoration.None
                )
            }
            is MovieCategoryLabelWithResource -> {
                Text(
                    text = stringResource(id = labelViewState.categoryText.textRes),
                    fontSize = 16.sp,
                    color = colorResource(id = if (labelViewState.isSelected) R.color.black else R.color.grey_text),
                    fontFamily = proximaNovaFamily,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (labelViewState.isSelected) TextDecoration.Underline else TextDecoration.None
                )
            }
        }

    }
}

@Preview
@Composable
fun MovieCategoryPreview() {
    Row {
        MovieCategory(
            MovieCategoryLabelViewState(
                1,
                true,
                MovieCategoryLabelWithText("Movie")
            )
        )
        MovieCategory(
            MovieCategoryLabelViewState(
                1,
                false,
                MovieCategoryLabelWithText("Movie")
            )
        )
    }

}