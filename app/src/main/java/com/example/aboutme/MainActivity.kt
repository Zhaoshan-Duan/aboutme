package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Joshua Duan")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

//        findViewById<Button>(R.id.done_button).setOnClickListener{
//            addNickname(it)
//        }
    }

        // view here is the button
        private fun addNickname(view: View) {
//            val editText = findViewById<EditText>(R.id.nickname_edit)
//            val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//            nicknameTextView.text = editText.text
//            editText.visibility = View.GONE
//            view.visibility = View.GONE
//            nicknameTextView.visibility = View.VISIBLE


            binding.apply {
                myName?.nickname = nicknameEdit.text.toString()
               invalidateAll()
                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
            }

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }