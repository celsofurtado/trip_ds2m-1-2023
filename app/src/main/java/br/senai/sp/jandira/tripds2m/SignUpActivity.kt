package br.senai.sp.jandira.tripds2m

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripds2m.components.FooterShape
import br.senai.sp.jandira.tripds2m.components.HeaderShape
import br.senai.sp.jandira.tripds2m.ui.theme.TripDS2MTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripDS2MTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SignUpForm()
                }
            }
        }
    }
}

@Composable
fun SignUpForm() {

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        imageUri = it
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            HeaderShape()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign up",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.magenta)
            )
            Text(
                text = "Create a new account",
                fontSize = 14.sp,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box() {
                Card(
                    modifier = Modifier.size(
                        90.dp,
                        90.dp
                    ),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Magenta,
                                Color.White
                            )
                        )
                    )
                ) {

                    var bmp = BitmapFactory.decodeResource(
                        LocalContext.current.resources,
                        R.drawable.user
                    )

                    imageUri?.let {
                        bmp = if (Build.VERSION.SDK_INT < 28) {
                            MediaStore.Images.Media.getBitmap(
                                LocalContext.current.contentResolver,
                                it
                            )
                        } else {
                            val source = ImageDecoder.createSource(
                                LocalContext.current.contentResolver,
                                imageUri!!
                            )
                            ImageDecoder.decodeBitmap(source)
                        }
                    }


                        Image(
                            bitmap = bmp!!.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )

                }

                IconButton(
                    onClick = { launcher.launch("image/*") },
                    modifier = Modifier
                        .align(alignment = Alignment.BottomEnd)
                        .offset(
                            x = 20.dp,
                            y = 10.dp
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.photo_24),
                        contentDescription = null,
                        tint = Color.Magenta
                    )
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Username") },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.magenta),
                        focusedBorderColor = colorResource(id = R.color.magenta)
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Phone") },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.magenta),
                        focusedBorderColor = colorResource(id = R.color.magenta)
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "E-mail") },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.magenta),
                        focusedBorderColor = colorResource(id = R.color.magenta)
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "Password") },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.magenta),
                        focusedBorderColor = colorResource(id = R.color.magenta)
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {}
                    )
                    Text(text = "Over 18")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.magenta))
                ) {
                    Text(
                        text = "CREATE ACCOUNT",
                        modifier = Modifier.padding(4.dp),
                        color = Color.White
                    )
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            FooterShape()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview2() {
    TripDS2MTheme {
        SignUpForm()
    }
}