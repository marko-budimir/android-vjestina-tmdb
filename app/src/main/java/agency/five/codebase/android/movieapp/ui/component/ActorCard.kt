package agency.five.codebase.android.movieapp.ui.component


import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.proximaNovaFamily
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


data class ActorCardViewState(
    val imageUrl: String,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 20.dp,
        modifier = modifier
            .padding(10.dp)
            .size(125.dp, 209.dp),
        shape = RoundedCornerShape(10.dp)
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
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 10.dp, end = 28.dp, top = 5.dp, bottom = 5.dp),
                fontFamily = proximaNovaFamily,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = actorCardViewState.character,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                color = colorResource(id = R.color.actor_card_character_name),
                fontFamily = proximaNovaFamily,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview
@Composable
private fun ActorCardPreview() {
    ActorCard(
        actorCardViewState = ActorCardViewState(
            "https://d34urnl45u363e.cloudfront.net/store/mediaobject/54905/image/large-0ff8de2ac61eeada073b984e50efd977.jpg",
            "Robert Downey Jr.",
            "Tony Stark/Iron Man"
        )
    )
}