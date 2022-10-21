package com.example.bebetteratcookingin30days

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bebetteratcookingin30days.data.DataSource
import com.example.bebetteratcookingin30days.model.DayAdvice
import com.example.bebetteratcookingin30days.ui.theme.BeBetterAtCookingIn30DaysTheme

@Composable
fun DailyAdviceItem(advice: DayAdvice, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        ) {
            DailyAdviceItemHeader(
                title = advice.title,
                onClick = { expanded = !expanded },
                expanded = expanded
            )

            if (expanded) {
                DailyAdviceItemDescription(
                    image = advice.image,
                    description = advice.description,
                    expanded = expanded
                )
            }
        }

    }
}

@Composable
fun DailyAdviceItemHeader(
    @StringRes title: Int,
    onClick: () -> Unit,
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(title),
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.h6
        )

        IconButton(onClick = onClick) {
            Icon(
                imageVector = if (!expanded) Icons.Filled.ExpandMore else Icons.Filled.ExpandLess,
                contentDescription = stringResource(R.string.expand_description)
            )
        }
    }
}

@Composable
fun DailyAdviceItemDescription(
    @DrawableRes image: Int,
    @StringRes description: Int,
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
//        var visible by remember { mutableStateOf(true) }
//        AnimatedVisibility(
//            visible = visible,
////            enter = slideInVertically
//        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(),

                )
//        }

        Text(
            text = stringResource(description),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DailyAdviceList(modifier: Modifier = Modifier) {
    val data = DataSource.advices

    BeBetterAtCookingIn30DaysTheme {
        LazyColumn(modifier = modifier) {
            items(data) {
                DailyAdviceItem(advice = it)
            }
        }

    }
}
