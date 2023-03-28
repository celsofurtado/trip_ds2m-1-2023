package br.senai.sp.jandira.tripds2m

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripds2m.components.FooterShape
import br.senai.sp.jandira.tripds2m.components.HeaderShape
import br.senai.sp.jandira.tripds2m.ui.theme.TripDS2MTheme
import java.util.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TripDS2MTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {

    val context = LocalContext.current

    // Column principal
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Inicio da Row da forma
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
           HeaderShape()
        } // fim da row da forma

        // Inicio da column login
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(207, 1, 240)
            )
            Text(
                text = stringResource(id = R.string.please),
                fontSize = 14.sp,
                color = Color(160, 156, 156)
            )
        } // fim da column login

        // Inicio da column formulário
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.email))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.email_24),
                        contentDescription = stringResource(
                            id = R.string.email_description
                        ),
                        tint = Color(207, 1, 240)
                    )
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.lock_24),
                        contentDescription = stringResource(
                            id = R.string.email_description
                        ),
                        tint = Color(207, 1, 240)
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(207, 6, 246)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row() {
                    Text(
                        text = stringResource(id = R.string.signin).uppercase(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(
                        id = R.drawable.arrow_forward_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        } // fim da column formulário

        // Inicio da row don't have an account
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(id = R.string.dont_have),
                fontSize = 14.sp,
                color = Color(160, 156, 156)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.signup),
                modifier = Modifier.clickable {
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                },
                fontSize = 14.sp,
                color = Color(247, 6, 246)
            )
        } // fim da rown don't have an account

        // Inicio da Row da forma
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            FooterShape()
        } // fim da row da forma

    } // Fim da column principal
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TripDS2MTheme {
        LoginScreen()
    }
}