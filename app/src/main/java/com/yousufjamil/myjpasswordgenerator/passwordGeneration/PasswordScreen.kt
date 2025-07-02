package com.yousufjamil.myjpasswordgenerator.passwordGeneration

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yousufjamil.myjpasswordgenerator.data.DataSource.length
import com.yousufjamil.myjpasswordgenerator.data.DataSource.navController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasswordScreen() {
    val context = LocalContext.current

    val password = GeneratePassword(length = length)

    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF202a31))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(Color(0xFF607d94))
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = password,
                color = Color.White,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clickable {
                        val clip = ClipData.newPlainText("Copied Password", password)
                        clipboard.setPrimaryClip(clip)

                        Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show()
                    }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Regenerate",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                        navController.navigate("password")
                    },
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}