package com.example.inventory.ui.navigation

// Define uma interface para representar destinos de navegação
interface NavigationDestination {

    // Armazena a rota de navegação para este destino.
    val route: String

    // Armazena a referência de recurso de string para o título deste destino.
    val titleRes: Int
}

