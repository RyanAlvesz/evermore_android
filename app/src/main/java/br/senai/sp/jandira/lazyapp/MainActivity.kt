package br.senai.sp.jandira.lazyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lazyapp.ui.theme.LazyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Image(
        painter = painterResource(id = R.drawable.evermore),
        contentDescription = "Background do app",
        contentScale = ContentScale.Crop
    )
    Surface(
        color = Color(0x88000000)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "Buscar Músicas")
                },
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xffffffff),
                    unfocusedTrailingIconColor = Color(0xff401416),
                    unfocusedPlaceholderColor = Color(0xff401416),
                    unfocusedBorderColor = Color(0xff401416),
                    focusedContainerColor = Color(0xffffffff),
                    focusedTrailingIconColor = Color(0xff401416),
                    focusedPlaceholderColor = Color(0xff401416),
                    focusedBorderColor = Color(0xff401416)
                ),
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Pesquisar"
                        )
                    }
                }
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Text(
                text = "Músicas",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xffffffff),
                style = TextStyle(
                    shadow = Shadow(
                        Color(0xff401416), Offset(8f, 2f), 1f
                    )
                )
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            LazyColumn() {
                items(20) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(bottom = 12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0x33D4C4B2)
                        ),
                        border = BorderStroke(
                            2.dp,
                            Brush.horizontalGradient(listOf(Color(0x33D4C4B2), Color(0x00D4C4B2)))
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(80.dp),
                                border = BorderStroke(1.dp, Color(0xFFD4C4B2))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.evermore_profile),
                                    contentDescription = "Evermore",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .padding(start = 12.dp)
                            ) {
                                Text(
                                    text = "Willow",
                                    color = Color(0xfffffffff),
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(bottom = 8.dp)
                                )
                                Text(
                                    text = "Wait for the signal, and I'll meet you after dark\n" +
                                            "Show me the places where the others gave you scars\n" +
                                            "Now this is an open-shut case",
                                    fontSize = 12.sp,
                                    color = Color(0xfffffffff),
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LazyAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}