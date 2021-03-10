package com.example.godori.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.godori.R

class GroupCreation1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_creation1)

        //xml 요소
        val next: Button = findViewById(R.id.gr_btn_creation1_next1)
        val back: ImageButton = findViewById(R.id.gr_btn_creation_back1)
        val name: EditText = findViewById(R.id.gr_et_name)
        val num: TextView = findViewById(R.id.gr_tv_name_num)

        // editText 글자수 세기 (num 변경 & 다음 버튼 색 변경)
        var textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                var userinput = name.text.toString()
                num.text = userinput.length.toString() + "/15"
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                num.text = "0/15"
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var userinput = name.text.toString()
                num.text = userinput.length.toString() + "/15"
            }
        }
        name.addTextChangedListener(textWatcher)
    }
}