package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

// A classe OfflineItemsRepository implementa a interface ItemsRepository
// para fornecer acesso offline aos dados dos itens.
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    // Sobrescrevendo a função para obter um fluxo (Flow) de todos os itens do repositório.
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    // Sobrescrevendo a função para obter um fluxo (Flow) de um único item com base no ID.
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    // Sobrescrevendo a função para inserir um item no repositório de itens.
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    // Sobrescrevendo a função para excluir um item do repositório de itens.
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    // Sobrescrevendo a função para atualizar um item no repositório de itens.
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
