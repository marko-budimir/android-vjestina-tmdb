package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.proximaNovaFamily
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CrewItem(
    name: String,
    profession: String,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(
            text = name,
            fontSize = 14.sp,
            fontFamily = proximaNovaFamily,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = profession,
            fontSize = 12.sp,
            color = colorResource(id = R.color.grey_text),
            fontFamily = proximaNovaFamily,
            fontWeight = FontWeight.Normal
        )
    }

}

@Preview
@Composable
private fun CrewItemPreview() {
    CrewItem(name = "Jon Favreau", profession = "Director")
}