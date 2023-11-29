package com.example.inventory.data // Pacote (Package)


// Esta seção define o pacote ao qual este arquivo pertence
// e importa a classe Context para uso posterior.
import android.content.Context

// Aqui, declaramos uma interface chamada AppContainer.
// Essa interface define uma propriedade chamada itemsRepository,
// que deve ser implementada por qualquer classe que implemente a interface.
interface AppContainer {
    val itemsRepository: ItemsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    // Esta classe AppDataContainer implementa a interface AppContainer
    // e recebe um objeto Context no construtor.

    override val itemsRepository: ItemsRepository by lazy {
        // A propriedade itemsRepository é inicializada de forma preguiçosa (lazy),
        // ou seja, será criada apenas quando for acessada pela primeira vez.

        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
        // Aqui, é criado uma instância do OfflineItemsRepository, que depende
        // de um banco de dados InventoryDatabase, acessado a partir do contexto (Context).
    }
}
