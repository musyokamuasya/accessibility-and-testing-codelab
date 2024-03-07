package ninja.ciox.accessibility.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var fullName by mutableStateOf("")
        private set
    var username by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var phoneNumber by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    fun updateFullName(text: String) {
        fullName = text
    }

    fun updateUsername(text: String) {
        username = text
    }

    fun updateEmail(text: String) {
        email = text
    }

    fun updatePassword(text: String) {
        password = text
    }

    fun updatePhoneNumber(text: String) {
        phoneNumber = text
    }
}