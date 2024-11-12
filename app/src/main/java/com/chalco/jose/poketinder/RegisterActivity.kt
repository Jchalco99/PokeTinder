package com.chalco.jose.poketinder

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.chalco.jose.poketinder.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesRepository = SharedPreferencesRepository().apply {
            setSharedPreference(this@RegisterActivity)
        }

        binding.btnBackClose.setOnClickListener {
            finish()
        }

        binding.btnRegister.setOnClickListener {
            registerUser()
        }

        binding.btnyatengounacuenta.setOnClickListener {
            finish()
        }
    }

    private fun registerUser() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString()
        val confirmPassword = binding.edtPassword2.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = "Ingrese un correo valido"
            return
        }

        if (password.length < 8) {
            binding.edtPassword.error = "La contraseña debe tener 8 caracteres"
            return
        }

        if (password != confirmPassword) {
            binding.edtPassword2.error = "Las contraseñas no son iguales"
            return
        }


        sharedPreferencesRepository.saveUserEmail(email)
        sharedPreferencesRepository.saveUserPassword(password)

        Toast.makeText(this, "Registrado exitosamente", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}