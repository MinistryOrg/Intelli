package com.mom.intelli.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mom.intelli.ui.IntelliViewModel
import com.mom.intelli.ui.theme.PlaceHolderTxtCLr
import com.mom.intelli.ui.theme.SearchBckgClr
import com.mom.intelli.ui.theme.SearchIconClr

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchInternetWidget(
    paddingValues: Dp,
    intelliViewModel: IntelliViewModel
) {
    var searchText by remember { mutableStateOf("") }
    TextField(
        value = searchText,
        onValueChange = {searchText = it},
        modifier = Modifier
            .padding(vertical = paddingValues)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp)),
        placeholder = { Text(text = "Search the internet...", color = PlaceHolderTxtCLr, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start)},
        textStyle = TextStyle(fontWeight = FontWeight.Bold, textAlign = TextAlign.Start),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search_icon",
                tint = SearchIconClr,
            modifier = Modifier
                .size(35.dp).clickable {
                    intelliViewModel.openNewsLink(searchText,"search")
                }
        ) },
        keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Search),
        singleLine = false ,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = SearchBckgClr,
            unfocusedContainerColor = SearchBckgClr,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = SearchIconClr,
            focusedIndicatorColor = SearchBckgClr,
            unfocusedIndicatorColor = SearchBckgClr,
            selectionColors = TextSelectionColors(SearchIconClr, SearchIconClr)

        )
    )

}