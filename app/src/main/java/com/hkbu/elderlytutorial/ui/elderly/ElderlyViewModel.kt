package com.hkbu.elderlytutorial.ui.elderly

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ElderlyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ElderlyUiState())
    val uiState: StateFlow<ElderlyUiState> = _uiState.asStateFlow()

    fun setWhatsappVideoId(whatsappVideoId: String) {
        _uiState.update { currentState ->
            currentState.copy(whatsappVideoId = whatsappVideoId)
//        _uiState.value = _uiState.value.copy(whatsappVideoId = whatsappVideoId)
        }
    }

}