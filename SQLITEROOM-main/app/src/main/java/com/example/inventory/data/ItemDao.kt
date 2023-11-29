package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Declaração da interface ItemDao,
// que define as operações de acesso a
// dados para a entidade Item.
@Dao
interface ItemDao {

    // Função para inserir um item no banco de dados.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    // Função para atualizar um item no banco de dados.
    @Update
    suspend fun update(item: Item)

    // Função para excluir um item do banco de dados.
    @Delete
    suspend fun delete(item: Item)

    // Função para obter um item específico do banco de dados com base em seu ID.
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    // Função para obter todos os itens do banco de dados e ordená-los pelo nome em ordem ascendente.
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}
