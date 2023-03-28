package br.senai.sp.jandira.tripds2m.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tripds2m.R

@Preview
@Composable
fun HeaderShape() {
    Card(
        modifier = Modifier.size(
            120.dp,
            40.dp
        ),
        shape = RoundedCornerShape(bottomStart = 16.dp),
        backgroundColor = colorResource(id = R.color.magenta)
    ) {

    }
}

@Preview
@Composable
fun FooterShape() {
    Card(modifier = Modifier
        .width(120.dp)
        .height(40.dp),
        shape = RoundedCornerShape(topEnd = 16.dp),
        backgroundColor = colorResource(id = R.color.magenta)
    ) {

    }
}