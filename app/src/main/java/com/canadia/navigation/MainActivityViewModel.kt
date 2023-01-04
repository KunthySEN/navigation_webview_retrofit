package com.canadia.navigation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canadia.navigation.data.User
import com.canadia.navigation.data.UserConnect
import kotlinx.coroutines.launch
class MainActivityViewModel : ViewModel() {
    val myResponse: MutableLiveData<User> = MutableLiveData()
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            myResponse.value = UserConnect.retrofit.getPost()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponseList.value = UserConnect.retrofit.getPosts()
        }
    }
}