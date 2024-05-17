package com.example.jetpackcompost_demo

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsPage() {
//    Column(
//        modifier = Modifier.fillMaxSize().background(Color.LightGray),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Settings Page")
//    }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "About Us",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        SettingsItem(text = "Feedback", icon = Icons.AutoMirrored.Filled.ArrowForward) {
            // Handle feedback click
            // Example: Launch feedback activity or send an email
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:seng4510@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Feedback")
            }
            val emailChooserIntent = Intent.createChooser(emailIntent, "Send Feedback")
            context.startActivity(emailChooserIntent)
        }
        SettingsItem(text = "Request features", icon = Icons.AutoMirrored.Filled.ArrowForward) {
            // Handle donation click
            // Example: Launch request features activity
        }
        SettingsItem(text = "Invite Friends", icon = Icons.AutoMirrored.Filled.ArrowForward) {
            // Handle invite friends
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Share with friends here")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            context.startActivity(shareIntent)
        }
        Spacer(modifier = Modifier.weight(1f)) //push the version column to the bottom of the column
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("version 0.0.1")
        }
    }
}

@Composable
fun SettingsItem(text: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}