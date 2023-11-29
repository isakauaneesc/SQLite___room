package com.example.inventory

import android.app.Application
import com.example.inventory.data.AppContainer
import com.example.inventory.data.AppDataContainer

// Classe da aplicação, que estende a classe Application do Android.
class InventoryApplication : Application() {

    // Declarando uma propriedade lateinit chamada 'container' do tipo AppContainer.
    // Essa propriedade será inicializada posteriormente no método 'onCreate'.
    lateinit var container: AppContainer

    // Sobrescrevendo o método 'onCreate' da classe Application.
    override fun onCreate() {
        super.onCreate()

        // Quando a aplicação é criada, instanciamos um objeto 'AppDataContainer'.
        container = AppDataContainer(this)
    }
}
