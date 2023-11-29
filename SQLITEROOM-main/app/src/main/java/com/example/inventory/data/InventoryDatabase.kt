package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Declaração da classe InventoryDatabase, que representa um banco de dados Room.
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // Declaração da função abstrata itemDao, que retorna um objeto ItemDao.
    abstract fun itemDao(): ItemDao

    // Declaração de um objeto companion que contém a lógica de criação do banco de dados.
    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

        // Função estática getDatabase que cria uma instância do banco de dados.
        fun getDatabase(context: Context): InventoryDatabase {

            // Usando a expressão para retornar uma instância existente (se houver)
            // ou criar uma nova instância do banco de dados usando Room.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build().also { Instance = it }
            }
        }
    }
}
