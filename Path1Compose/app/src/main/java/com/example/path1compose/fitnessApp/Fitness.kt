package com.example.composeessentials.fitnessApp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.path1compose.R
import com.example.path1compose.ui.theme.Path1ComposeTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun FitnessApp() {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp

    Box {
        if (screenWidthDp < 600) {
            MyFitnessAppPortrait()
        } else {
            MyFitnessAppLandscape()
        }
    }
}
@Composable
fun MyFitnessAppPortrait(){
    Path1ComposeTheme {
        Scaffold(
            bottomBar = {FitnessBottomNavigation()}
        ) {paddingValue ->
            HomeScreen(modifier = Modifier.padding(paddingValue))
        }
    }
}

@Composable
fun MyFitnessAppLandscape() {
    Path1ComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.surface
        ) {

            Row {
                FitnessRailNavigation()
                HomeScreen()
            }
        }
    }
}

@Composable
fun FitnessBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            label = { Text(text = stringResource(id = R.string.bottom_navigation_home)) },
            icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            label = { Text(text = stringResource(id = R.string.bottom_navigation_profile)) },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) }
        )
    }
}

@Composable
fun FitnessRailNavigation(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(top = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier= modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = true,
                onClick = { /*TODO*/ },
                label = { Text(text = stringResource(id = R.string.bottom_navigation_home)) },
                icon = { Icon(imageVector = Icons.Default.Spa, contentDescription = null) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                label = { Text(text = stringResource(id = R.string.bottom_navigation_profile)) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
        placeholder = { Text(text = stringResource(R.string.search)) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )

}

@Composable
fun AlignYourBodyElement(
    modifier: Modifier,
    @DrawableRes imageId: Int,
    @StringRes textId: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = textId),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)

        )

    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes imageId: Int,
    @StringRes textId: Int
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .width(255.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = modifier
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = textId),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(horizontal = 16.dp)
            )
        }
    }

}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(modifier = modifier, imageId = item.drawable, textId = item.text)
        }

    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier
            .height(168.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        items(FavoriteCollectionData) { item ->
            FavoriteCollectionCard(
                modifier = modifier.height(80.dp),
                imageId = item.drawable,
                textId = item.text
            )

        }
    }
}

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(id = title),
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleMedium
        )
        content()

    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(modifier = modifier.padding(horizontal = 16.dp))
        HomeSection(
            modifier = Modifier.padding(1.dp),
            R.string.align_your_body
        ) { AlignYourBodyRow() }
        HomeSection(
            modifier = Modifier.padding(1.dp),
            R.string.favorite_collections
        ) { FavoriteCollectionsGrid() }
        Spacer(modifier = Modifier.height(16.dp))

    }
}


@Preview
@Composable
fun Preview() {
    Path1ComposeTheme {
        MyFitnessAppLandscape()
    }

}

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val FavoriteCollectionData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down,
).map { DrawableStringPair(it.first, it.second) }