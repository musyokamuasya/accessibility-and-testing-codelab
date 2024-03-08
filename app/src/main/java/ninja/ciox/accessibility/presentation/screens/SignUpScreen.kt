package ninja.ciox.accessibility.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ninja.ciox.accessibility.presentation.design_system.AccessibilityCodelabTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, onLoginButtonClicked: () -> Unit = {}) {
    var nameText by rememberSaveable { mutableStateOf("") }
    var emailText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .testTag("column")
    ) {
        Text(
            text = "Welcome, Please Sign up",
            modifier = modifier
                .padding(top = 32.dp, bottom = 16.dp, start = 8.dp)
                .testTag("Sign me up")
                .semantics { contentDescription = "Welcome text message" },
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        OutlinedTextField(
            value = nameText,
            onValueChange = { updatedText -> nameText = updatedText },
            placeholder = {
                Text(
                    text = "Name"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person2,
                    contentDescription = "enter user name",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = modifier
                .semantics {
                    contentDescription = "User name field"
                }
                .padding(vertical = 8.dp)
                .fillMaxWidth(),

            )

        OutlinedTextField(
            value = emailText,
            onValueChange = { updatedText -> emailText = updatedText },
            placeholder = {
                Text(
                    text = "Email Address"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "enter email address",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = passwordText,
            onValueChange = { updatedText -> passwordText = updatedText },
            placeholder = {
                Text(
                    text = "Enter Password"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "enter your password",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .semantics {
                    contentDescription = ""
                }
        )

        OutlinedTextField(
            value = passwordText,
            onValueChange = { updatedText -> passwordText = updatedText },
            placeholder = {
                Text(
                    text = "Confirm Password"
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password lock icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = onLoginButtonClicked,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(text = "Sign up")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignUpScreen() {
    AccessibilityCodelabTheme {
        SignUpScreen()
    }
}