package com.example.inventory.ui.home

import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item

// A classe HomeViewModel estende ViewModel e é usada para gerenciar os dados da tela inicial.
class HomeViewModel() : ViewModel() {

    // O objeto companion fornece valores ou funções estáticas associadas à classe.
    companion object {
        // Definindo um valor constante para o tempo limite em milissegundos.
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

// A classe HomeUiState é um modelo de dados que representa o estado da tela inicial.
data class HomeUiState(val itemList: List<Item> = listOf())
