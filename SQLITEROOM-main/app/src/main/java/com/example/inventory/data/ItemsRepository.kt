package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

// Declaração da interface ItemsRepository, que define as operações relacionadas aos itens.
interface ItemsRepository {

    // Função que retorna um fluxo (Flow) de uma lista de itens.
    fun getAllItemsStream(): Flow<List<Item>>

    // Função que retorna um fluxo (Flow) de um único item com base no seu ID.
    fun getItemStream(id: Int): Flow<Item?>

    // Função assíncrona para inserir um item no repositório.
    suspend fun insertItem(item: Item)

    // Função assíncrona para excluir um item do repositório.
    suspend fun deleteItem(item: Item)

    // Função assíncrona para atualizar um item no repositório.
    suspend fun updateItem(item: Item)
}
