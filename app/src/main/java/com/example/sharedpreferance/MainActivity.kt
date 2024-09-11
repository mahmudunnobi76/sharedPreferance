package com.example.sharedpreferance

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreference = getSharedPreferences("NoteApp",Context.MODE_PRIVATE)

        binding.saveBtn.setOnClickListener {
            val note = binding.noteEt.text.toString()
            val editor = sharedPreference.edit()
            editor.putString("note",note)
            editor.apply()

            Toast.makeText(this,"Note Added successfully",Toast.LENGTH_LONG).show()
            binding.noteEt.text.clear()
        }
        binding.displaNoteBtn.setOnClickListener {
            val note = sharedPreference.getString("note","")
            binding.noteTv.text = note
        }

    }
}