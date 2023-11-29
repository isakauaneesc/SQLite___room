package com.example.inventory.ui.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item
import com.example.inventory.data.ItemsRepository
import java.text.NumberFormat

// ViewModel responsável pela tela de entrada de itens.
class ItemEntryViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    // Estado da interface do usuário para a tela de entrada de itens.
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    // Atualiza o estado da interface do usuário com base nos detalhes do item.
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    // Salva o item se a validação for bem-sucedida.
    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    // Função privada para validar os detalhes do item.
    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}

// Estado da interface do usuário para a tela de entrada de itens.
data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

// Detalhes de um item, incluindo nome, preço e quantidade.
data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

// Converte os detalhes do item em um objeto do tipo Item.
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

// Formata o preço de um item como uma string monetária.
fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

// Converte um Item em um estado da interface do usuário (ItemUiState).
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

// Converte um Item em detalhes de item (ItemDetails).
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    price = price.toString(),
    quantity = quantity.toString()
)
