package com.brainpulse.namecraft

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.brainpulse.namecraft.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
     //view-model instance
    private lateinit var viewModel: StylishNameViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[StylishNameViewModel::class.java]
        setContentView(binding.root)

        binding.generateBtn.setOnClickListener {
            generateNames()
        }



       // viewModel.generateStylishNames("Aman", 50)

        viewModel.stylishNames.observe(this, ::addNamesList)
    }

    private fun generateNames() {
        val inputName = binding.nameEt.text.toString()
        val variations = binding.variationsEt.text.toString().toIntOrNull() ?: 10
        if(inputName.isNotEmpty() && variations > 0) {
            viewModel.generateStylishNames(inputName, variations)
        } else {
            android.widget.Toast.makeText(this, "Please enter a valid name and variations", android.widget.Toast.LENGTH_SHORT).show()
        }
    }


    private fun addNamesList(strings: List<String>) {
        binding.namesLl.removeAllViews()
        //Create A TextView for each name in the list and add it to the LinearLayout
        for (name in strings) {
            val textView = TextView(this)
            textView.textSize = 24f
            textView.setTextColor(getColor(androidx.appcompat.R.color.primary_dark_material_dark))
            textView.text = name
            //Add Copy to Clipboard functionality
            textView.setOnClickListener {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                val clip = android.content.ClipData.newPlainText("Copied Text", name)
                clipboard.setPrimaryClip(clip)
                android.widget.Toast.makeText(this, "Copied to Clipboard", android.widget.Toast.LENGTH_SHORT).show()
            }

            //Add Tint to Copy to Clipboard Icon
            val drawable = androidx.appcompat.content.res.AppCompatResources.getDrawable(this, androidx.appcompat.R.drawable.abc_ic_menu_copy_mtrl_am_alpha)
            drawable?.setTint(getColor(androidx.appcompat.R.color.primary_dark_material_dark))

            //padding for textview
            textView.setPadding(5,5,5,5)

            //Add Icon to Copy to Clipboard
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
            binding.namesLl.addView(textView)
        }
    }

}