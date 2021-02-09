package com.example.library_test

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.textclassifier.TextLanguage
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    private val selectedLanguages: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.etLanguageTest)
        bindLanguages()
    }

    private fun bindLanguages() {
        val languageList: ArrayList<String> = arrayListOf()
        languageList.add("Türkçe")
        languageList.add("İngilizce")
        languageList.add("Almanca")
        languageList.add("Osmanlıca")
        languageList.add("Rusça")
        languageList.add("Romence")

        languageList.sort()

        val adapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, languageList)
        (tilLanguageTest.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        etLanguageTest.setOnItemClickListener { adapterView, view, i, l ->
            if (selectedLanguages.indexOf(etLanguageTest.text.toString()) == -1) {
                addChip(etLanguageTest.text.toString())
                selectedLanguages.add(etLanguageTest.text.toString())
                etLanguageTest.text.clear()
            }
        }

    }

    private fun addChip(language: String) {
        val chip = Chip(this)
        chip.text = language
        chip.setOnClickListener {
            val tempChip = findViewById<Chip>(it.id)
            selectedLanguages.remove(tempChip.text)
            cgLanguageTest.removeView(it)
        }
        cgLanguageTest.addView(chip)
    }


}


