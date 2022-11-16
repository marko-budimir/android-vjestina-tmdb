package agency.five.codebase.android.movieapp.ui.theme

import agency.five.codebase.android.movieapp.R
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val proximaNovaFamily = FontFamily(
    Font(R.font.proxima_nova_regular, FontWeight.Normal),
    Font(R.font.proxima_nova_bold, FontWeight.Bold),
    Font(R.font.proxima_nova_extrabold, FontWeight.ExtraBold)
)

val Typography = Typography(
    h2 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    body1 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = proximaNovaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

