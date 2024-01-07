package com.durao.jnr.feg_request

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.durao.jnr.feg_request.ui.theme.FegRequestTheme
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
//    private lateinit var autenticar: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FegRequestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    FirebaseApp.initializeApp(this)
//                    val mydb = Mydb(this)
//                    val autenticar = FirebaseAuth.getInstance()
                    var username by remember{ mutableStateOf("") }
                    var password by remember{ mutableStateOf("") }
                    var isPasswordVisible by remember { mutableStateOf(false) }
                    //val isFormValid by derivedStateOf { username.isNotBlank() && password.length > 5? }

                    Column(Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = R.drawable.logotipo),
                            contentDescription ="FET",
                            modifier = Modifier
                                .weight(1f)
                                .size(300.dp)
                        )
                        Card(
                            Modifier
                                .weight(2f)
                                .padding(8.dp),
                            shape = RoundedCornerShape(32.dp)
                        ) {
                            Column(
                                Modifier
                                    .fillMaxSize()
                                    .padding(32.dp)
                            ) {
                                Text(text = "BEM VINDO!")
                                Column(Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {

                                    OutlinedTextField(
                                        modifier = Modifier.fillMaxWidth(),
                                        value = username,
                                        onValueChange = {username = it},
                                        label ={ Text(text = "Username")},
                                        singleLine = true,
                                        trailingIcon = {
                                            IconButton(onClick = { username = ""}) {
                                                Icon(imageVector = Icons.Filled.Clear , contentDescription = "Limpar caixa de Texto")
                                            }
                                        }

                                    )

                                    Spacer(modifier = Modifier.height(32.dp))
                                    OutlinedTextField(
                                        modifier = Modifier.fillMaxWidth(),
                                        value = password,
                                        onValueChange = {password = it},
                                        label ={ Text(text = "Password")},
                                        singleLine = true,
                                        trailingIcon = {
                                            IconButton(onClick = { isPasswordVisible = !isPasswordVisible}) {
                                                Icon(imageVector =if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                                    contentDescription = "Ver senha")
                                            }
                                        },
                                        visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                    )
                                    Spacer(modifier = Modifier.height(32.dp))
                                    Button({
//                                        onClick = {   var intent = Intent(applicationContext, Dashboard::class.java)
                                            // val validar = mydb.loginUser(username, password)
//                                            startActivity(intent)
//                                            if (validar) {
//                                            // Login bem-sucedido, faça algo aqui, como navegar para outra atividade
////                                            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
//
//
//                                        } else {
//                                            // Credenciais inválidas, trate conforme necessário
////                                            Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
//                                        }
                                        },
                                        modifier =  Modifier.fillMaxWidth(),
                                        shape = RoundedCornerShape(16.dp)
                                    ) {
                                        Text(text = "Log In")
                                    }
                                    Spacer(modifier = Modifier.height(32.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween){
                                        TextButton(onClick = {
//                                            var intent = Intent(applicationContext, Cadastro::class.java)
//                                            startActivity(intent)

                                        }) {
                                            Text(text = "Sign Up")

                                        }
                                        TextButton(onClick = { }) {
                                            Text(text = "Forgot Password?",
                                                color = Color.Gray)

                                        }

                                    }
                                }
                            }

                        }

                    }


//                    Login()
//                    val dbHelper = Mydb(this)
//
//                    // Garanta que o banco de dados e a tabela sejam criados
//
//                    // Garanta que o banco de dados e a tabela sejam criados
//                    val db: SQLiteDatabase = dbHelper.getWritableDatabase()
//
//                    // Agora você pode usar o método insertData para inserir dados
//
//                    // Agora você pode usar o método insertData para inserir dados
//                    val newRowId: Long = dbHelper.insertData("NomeExemplo")
//
//                    if (newRowId != -1L) {
//                        // Inserção bem-sucedida, faça algo aqui, se necessário
//                        Toast.makeText(
//                            this,
//                            "Inserção bem-sucedida, ID: $newRowId",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    } else {
//                        // Ocorreu um erro durante a inserção, trate de acordo
//                        Toast.makeText(this, "Erro durante a inserção", Toast.LENGTH_SHORT).show()
//                    }
//                    fun irParaSegundaAtividade(view: View?) {
//                        val intent = Intent(this, Cadastro::class.java)
//                        ContextCompat.startActivity(intent)
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FegRequestTheme {
        Greeting("Android")
    }
}