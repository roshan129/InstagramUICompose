package com.plcoding.instagramui

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.instagramui.ui.theme.Purple500


@Composable
fun ProfileScreen() {

    Column(modifier = Modifier.fillMaxWidth()) {

        TopBar()
        ProfileSection()
        ProfileDescription(
            modifier = Modifier.padding(12.dp),
            profileName = "Roshan Adke",
            profileDescription = "Android developer with 3 years of experience in creating and maintaining high-quality mobile applications. " +
                    "Proficient in Java, Kotlin, and Android SDK. Strong understanding of Android architecture, " +
                    "design patterns, and best practices.",
            url = "https://github.com/roshan129",
            followedBy = mutableListOf("codinginflow", "codingwithmitch"),
            othersCount = 13
        )
        ButtonSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp)
        )


    }

}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "_ro_swag",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        RoundImage(
            image = painterResource(id = R.drawable.roshan), modifier = Modifier
                .weight(3f)
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
        )
        StatSection(
            modifier = Modifier
                .weight(7f)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier
) {

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape),
    )
}

@Composable
fun StatSection(
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ) {

        ProfileStat("369", "Posts")
        ProfileStat("100K", "Followers")
        ProfileStat("72", "Following")

    }

}

@Composable
fun ProfileStat(
    statNumber: String,
    statDescription: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = statNumber, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = statDescription)
    }
}

@Composable
fun ProfileDescription(
    modifier: Modifier,
    profileName: String,
    profileDescription: String,
    url: String,
    followedBy: List<String>,
    othersCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = modifier
    ) {

        Text(
            text = profileName,
            fontWeight = FontWeight.Bold,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = profileDescription,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = url,
            color = Purple500,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )
        Text(
            text = buildAnnotatedString {
                val bold = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("Followed By ")
                followedBy.forEachIndexed { index, name ->
                    pushStyle(bold)
                    append(name)
                    pop()
                    if (index < followedBy.size - 1) {
                        append(", ")
                    }
                }
                append(" and ")
                pushStyle(bold)
                append("$othersCount others")
            },
            lineHeight = lineHeight,
            letterSpacing = letterSpacing
        )

    }
}

@Composable
fun ButtonSection(
    modifier: Modifier,
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        ActionButton(text = "Following", icon = Icons.Default.KeyboardArrowDown)
        ActionButton(text = "Message", icon = Icons.Default.KeyboardArrowDown)
        ActionButton(text = "Email", icon = Icons.Default.KeyboardArrowDown)
        ActionButton(text = null, icon = Icons.Default.KeyboardArrowDown)


    }

}

@Composable
fun ActionButton(
    text: String?,
    icon: ImageVector
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(
                    5.dp
                )
            )
            .padding(top = 4.dp, bottom = 4.dp, start = 10.dp, end = 10.dp)
    ) {
        text?.let {
            Text(
                text = text,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black
        )

    }

}


















