package com.hamidreza.mvisample.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamidreza.mvisample.data.model.User
import com.hamidreza.mvisample.repository.UserRepository
import com.hamidreza.mvisample.utils.ResultState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class UserViewModel @ViewModelInject constructor(val userRepo:UserRepository) : ViewModel() {

    private val _dataState : MutableLiveData<ResultState<List<User>>> = MutableLiveData()
    val dataState:LiveData<ResultState<List<User>>> get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent){
        when(mainStateEvent){
            is MainStateEvent.getUsersEvent -> {
                userRepo.getUsers().onEach {
                    _dataState.value = it
                }.launchIn(viewModelScope)

            }
        }
    }

}

sealed class MainStateEvent{
    object getUsersEvent : MainStateEvent()
}