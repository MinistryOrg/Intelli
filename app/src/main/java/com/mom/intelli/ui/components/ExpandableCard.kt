package com.mom.intelli.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mom.intelli.ui.theme.InternetClr
import com.mom.intelli.ui.theme.TextWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    cardColor: Color,
    title: String,
    icon: Int,
    titleFontSize: TextUnit = 18.sp,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description1: String,
    description2: String?,
    descriptionFontSize: TextUnit = 15.sp,
    descriptionFontWeight: FontWeight = FontWeight.Bold,
    shape: Shape = RoundedCornerShape(13.dp),
    padding: Dp = 12.dp,
    Image1: Int,
    Image2: Int?,
    Image3: Int?,

    ) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            contentColor = if (cardColor == InternetClr){ Color(0xFF121212)}else{TextWhite}
        ),
        shape = shape,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
               Icon(
                   painter = painterResource(id = icon),
                   contentDescription = null,
                   Modifier.size(35.dp)
               )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(1.0f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandedState) {

                Image(
                    painter = painterResource(id = Image1),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .clip(RoundedCornerShape(13.dp))
                )

                Text(
                    text = description1,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight
                )


            }
        }
    }
}