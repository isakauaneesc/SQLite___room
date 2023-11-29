package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Declaração da classe Item, que representa uma entidade no banco de dados Room.
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,         // Chave primária que é gerada automaticamente (autoGenerate) e tem valor padrão 0.
    val name: String,        // Nome do item.
    val price: Double,       // Preço do item.
    val quantity: Int        // Quantidade disponível do item.
)
