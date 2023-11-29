package com.example.inventory.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.inventory.data.ItemsRepository

// Classe ViewModel para a tela de detalhes do item.
class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // O ID do item a ser exibido nas detalhes é recuperado do SavedStateHandle.
    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    // Objeto companion que fornece valores ou funções estáticas associadas à classe.
    companion object {
        // Constante para definir um tempo limite em milissegundos.
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

// Classe de modelo de dados que representa o estado da tela de detalhes do item.
data class ItemDetailsUiState(
    val outOfStock: Boolean = true, // Indica se o item está fora de estoque.
    val itemDetails: ItemDetails = ItemDetails() // Detalhes do item.
)
