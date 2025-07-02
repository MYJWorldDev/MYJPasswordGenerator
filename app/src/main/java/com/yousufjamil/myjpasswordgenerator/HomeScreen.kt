package com.yousufjamil.myjpasswordgenerator

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousufjamil.myjpasswordgenerator.data.DataSource
import com.yousufjamil.myjpasswordgenerator.data.DataSource.navController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {
    var length by remember { mutableStateOf("8") }
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF202a31))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(Color(0xFF607d94))
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MYJ Password Generator",
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(10.dp))

            TextField(
                value = length,
                onValueChange = { length = it },
                label = { Text("Length") },
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp)),
                trailingIcon = {
                    Image(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = "Next",
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                try {
                                    DataSource.length = length.trim().toInt()

                                    navController.navigate("password")
                                } catch (_: Exception) {
                                    Toast.makeText(context, "Invalid length", Toast.LENGTH_SHORT).show()
                                }
                            }
                    )
                }
            )
        }
    }
}