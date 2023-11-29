package com.example.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.inventory.ui.theme.InventoryTheme

// Classe principal da atividade (Activity) da aplicação.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Define o tema principal da interface do usuário com o uso de 'InventoryTheme'.
            InventoryTheme {
                // Define a estrutura visual da atividade.
                Surface(
                    modifier = Modifier.fillMaxSize(), // Preenche toda a tela com o conteúdo.
                    color = MaterialTheme.colorScheme.background // Define a cor de fundo com base no tema Material.
                ) {
                    // Chama o composable 'InventoryApp', que representa a interface principal da aplicação.
                    InventoryApp()
                }
            }
        }
    }
}
