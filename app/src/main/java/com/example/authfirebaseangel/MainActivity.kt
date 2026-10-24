package com.example.authfirebaseangel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    // Instancia de FirebaseAuth
    private lateinit var auth: FirebaseAuth

    // Elementos de la interfaz
    private lateinit var tvState: TextView
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inicialización de FirebaseAuth
        auth = Firebase.auth

        // Referenciar vistas
        tvState = findViewById(R.id.tvState)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)
        btnLogout = findViewById(R.id.btnLogout)

        // Configurar Listeners de los botones
        btnRegister.setOnClickListener { registerUser() }
        btnLogin.setOnClickListener { loginUser() }
        btnLogout.setOnClickListener { logoutUser() }
    }

    override fun onStart() {
        super.onStart()
        // Gestión de estado: comprobar si el usuario ya ha iniciado sesión
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    // 2. Registro de usuarios
    private fun registerUser() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (!validateFields(email, password)) return

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this, "Error en el registro: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    updateUI(null)
                }
            }
    }

    // 3. Login de usuarios
    private fun loginUser() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (!validateFields(email, password)) return

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(this, "Error al iniciar sesión: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    updateUI(null)
                }
            }
    }

    // 4. Cierre de sesión
    private fun logoutUser() {
        auth.signOut()
        Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
        updateUI(null)
    }

    // 5. Validación básica de campos
    private fun validateFields(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            etEmail.error = "El correo es obligatorio"
            etEmail.requestFocus()
            return false
        }
        if (password.isEmpty()) {
            etPassword.error = "La contraseña es obligatoria"
            etPassword.requestFocus()
            return false
        }
        if (password.length < 6) {
            etPassword.error = "La contraseña debe tener al menos 6 caracteres"
            etPassword.requestFocus()
            return false
        }
        return true
    }

    // Gestión del estado del usuario en la interfaz
    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            tvState.text = "Estado: Conectado como ${user.email}"
            btnLogout.isEnabled = true
            btnLogin.isEnabled = false
            btnRegister.isEnabled = false
        } else {
            tvState.text = "Estado: No autenticado"
            btnLogout.isEnabled = false
            btnLogin.isEnabled = true
            btnRegister.isEnabled = true
        }
    }
}