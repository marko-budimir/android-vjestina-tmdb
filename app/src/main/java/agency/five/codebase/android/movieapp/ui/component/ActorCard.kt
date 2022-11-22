package agency.five.codebase.android.movieapp.ui.component


import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.theme.Typography
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage


data class ActorCardViewState(
    val id: Int,
    val imageUrl: String?,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = dimensionResource(id = R.dimen.actor_card_elevation),
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
            AsyncImage(
                model = actorCardViewState.imageUrl,
                placeholder = painterResource(id = R.drawable.ic_broken_image),
                contentDescription = actorCardViewState.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight(0.65f)
            )
            Text(
                text = actorCardViewState.name,
                style = Typography.h6,
                modifier = Modifier.padding(all = MaterialTheme.spacing.small)
            )
            Text(
                text = actorCardViewState.character,
                style = Typography.subtitle2,
                modifier = Modifier.padding(
                    start = MaterialTheme.spacing.small,
                    end = MaterialTheme.spacing.small
                ),
                color = colorResource(id = R.color.grey_text)
            )
        }
    }
}

@Preview
@Composable
private fun ActorCardPreview() {
    val movieActorCardViewState = MoviesMock.getActor().let { actor ->
        ActorCardViewState(
            id = actor.id,
            imageUrl = actor.imageUrl.orEmpty(),
            name = actor.name,
            character = actor.character
        )
    }
    ActorCard(
        actorCardViewState = movieActorCardViewState,
        modifier = Modifier
            .padding(MaterialTheme.spacing.small)
            .size(
                dimensionResource(id = R.dimen.actor_card_width),
                dimensionResource(id = R.dimen.actor_card_height)
            )
    )
}
