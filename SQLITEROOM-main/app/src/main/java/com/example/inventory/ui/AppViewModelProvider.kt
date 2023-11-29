package com.example.inventory.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.inventory.InventoryApplication
import com.example.inventory.ui.home.HomeViewModel
import com.example.inventory.ui.item.ItemDetailsViewModel
import com.example.inventory.ui.item.ItemEditViewModel
import com.example.inventory.ui.item.ItemEntryViewModel

// Definição de um objeto que atua como provedor de fábrica de ViewModel.
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Inicializador para criar uma instância do ItemEditViewModel.
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle()
            )
        }

        // Inicializador para criar uma instância do ItemEntryViewModel.
        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

        // Inicializador para criar uma instância do ItemDetailsViewModel.
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle()
            )
        }

        // Inicializador para criar uma instância do HomeViewModel.
        initializer {
            HomeViewModel()
        }
    }
}

// Extensão para recuperar uma instância da classe InventoryApplication a partir dos extras de criação.
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
