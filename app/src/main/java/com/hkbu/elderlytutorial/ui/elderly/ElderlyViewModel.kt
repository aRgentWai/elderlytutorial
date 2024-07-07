package com.hkbu.elderlytutorial.ui.elderly

import androidx.annotation.RawRes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ElderlyViewModel : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(ElderlyUiState())
    val uiStateFlow: StateFlow<ElderlyUiState> = _uiStateFlow.asStateFlow()

    fun setWhatsappVideoId(@RawRes whatsappVideoId: Int) {
        _uiStateFlow.update { currentState ->
            currentState.copy(whatsappVideoId = whatsappVideoId)
//        _uiState.value = _uiState.value.copy(whatsappVideoId = whatsappVideoId)
        }
    }

}