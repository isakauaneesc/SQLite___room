package com.example.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.inventory.data.ItemsRepository

// Classe ViewModel para a tela de edição de item.
class ItemEditViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    // Propriedade que mantém o estado da interface do usuário para a tela de edição de item.
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    // O ID do item a ser editado é recuperado do SavedStateHandle.
    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    // Função privada para validar a entrada de dados do item.
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            // Verifica se os campos de nome, preço e quantidade não estão em branco.
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}
