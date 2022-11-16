package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.theme.Typography
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview

@Immutable
data class CrewItemViewState(
    val name: String,
    val job: String,
)

@Composable
fun CrewItem(
    crewItemViewState: CrewItemViewState,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(
            text = crewItemViewState.name,
            style = Typography.h6
        )
        Spacer(modifier = Modifier)
        Text(
            text = crewItemViewState.job,
            color = colorResource(id = R.color.grey_text),
            style = Typography.body2
        )
    }

}

@Preview
@Composable
private fun CrewItemPreview() {
    val mockCrewman = MoviesMock.getCrewman()
    CrewItem(
        crewItemViewState = CrewItemViewState(name = mockCrewman.name, job = mockCrewman.job)
    )
}