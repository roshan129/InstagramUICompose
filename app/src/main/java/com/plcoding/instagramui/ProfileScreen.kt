package com.plcoding.instagramui

import android.media.Image
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.instagramui.ui.theme.Purple500


@Composable
fun ProfileScreen() {

    val context = LocalContext.current

    val selectedTabIndex = remember {
        mutableStateOf(0)
    }

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
        Spacer(modifier = Modifier.height(8.dp))
        StoryHightLightSection(
            mutableListOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    text = "Youtube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
        )
        TabsViewSection(
            mutableListOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Grid"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "Igtv"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            ),
            modifier = Modifier.fillMaxWidth()
        ) { selectedIndex ->
            selectedTabIndex.value = selectedIndex
        }
        when (selectedTabIndex.value) {
            0 -> {
                PostSection(
                    posts = mutableListOf(
                        painterResource(id = R.drawable.kmm),
                        painterResource(id = R.drawable.intermediate_dev),
                        painterResource(id = R.drawable.master_logical_thinking),
                        painterResource(id = R.drawable.bad_habits),
                        painterResource(id = R.drawable.multiple_languages),
                        painterResource(id = R.drawable.learn_coding_fast),
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .scale(1.01f)
                )
            }
        }
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
            text = "_ro_swag_",
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
            .clickable {
                Log.d("TAG", "ActionButton: Clicked ")
            },
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

@Composable
fun StoryHightLightSection(
    highlights: List<ImageWithText>,
    modifier: Modifier
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(highlights) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)
            ) {
                RoundImage(image = it.image, modifier = Modifier.size(70.dp))
                Text(text = it.text, fontSize = 14.sp)

            }

        }
    }
}

@Composable
fun TabsViewSection(
    images: List<ImageWithText>,
    modifier: Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit
) {

    val selectedTabIndex = remember {
        mutableStateOf(0)
    }
    TabRow(
        selectedTabIndex = selectedTabIndex.value,
        modifier = modifier,
        backgroundColor = Color.Transparent
    ) {

        images.forEachIndexed { index, imageWithText ->
            Tab(
                selected = selectedTabIndex.value == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                onClick = {
                    selectedTabIndex.value = index
                    onTabSelected.invoke(index)
                }) {
                Icon(
                    painter = imageWithText.image,
                    contentDescription = imageWithText.text,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(20.dp),
                    tint = if (selectedTabIndex.value == index) Color.Black else Color.Gray
                )
            }
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier
) {

    LazyVerticalGrid(modifier = modifier, cells = GridCells.Fixed(3), content = {

        items(posts) {

            Image(
                painter = it,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RectangleShape
                    ),

                )

        }


    })


}


















