package com.example.calculatorapplication_johnrafaelabuelo


import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popupresult.*

class MainActivity : AppCompatActivity() {

    //creating arrays for the spinners options
    val dropdownlist1 = arrayOf("Tortilla", "Pita", "Buns")
    val dropdownlist2 = arrayOf("Beef", "Chicken", "Cheese")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popupbtn.setOnClickListener{

            val view = View.inflate(this@MainActivity, R.layout.popup, null)

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

        //creating adapters value for the view purposes
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist1)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist2)

        //creating a variable name b1 for button

        var b1 = findViewById(R.id.button) as Button


        //setting the adapters for the view purpose
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)


//setting the 1st spinner
        elements1.adapter = adapter
        elements1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (elements1.selectedItemPosition == 0) {
                    textView.setText(" " + elements1.selectedItem)
                    imageView2.setImageResource(R.drawable.tortilla)

                }
                if (elements1.selectedItemPosition == 1) {
                    textView.setText(" " + elements1.selectedItem)
                    imageView2.setImageResource(R.drawable.pita)

                }
                if (elements1.selectedItemPosition == 2) {
                    textView.setText(" " + elements1.selectedItem)
                    imageView2.setImageResource(R.drawable.buns)

                }
            }
        }

        //setting the 2nd spinner
        elements2.adapter = adapter2
        elements2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (elements2.selectedItemPosition == 0) {
                    textView2.setText(" " + elements2.selectedItem)
                    imageView3.setImageResource(R.drawable.beef)

                }
                if (elements2.selectedItemPosition == 1) {
                    textView2.setText(" " + elements2.selectedItem)
                    imageView3.setImageResource(R.drawable.chicken)

                }
                if (elements2.selectedItemPosition == 2) {
                    textView2.setText(" " + elements2.selectedItem)
                    imageView3.setImageResource(R.drawable.cheese)

                }
            }
        }

        //Once the user clicks the button, following text should be displayed based on the selected //items position in relevant array
        b1.setOnClickListener {
            if (elements1.selectedItemPosition == 0 && elements2.selectedItemPosition == 0) {



                val view2 = View.inflate(this@MainActivity, R.layout.popupresult, null)

                val builder2 = AlertDialog.Builder(this@MainActivity)
                builder2.setView(view2)

                val dialog2 = builder2.create()
                dialog2.show()
                dialog2.window?.setBackgroundDrawableResource(android.R.color.transparent)
            }
            if (elements1.selectedItemPosition == 0 && elements2.selectedItemPosition == 1) {
                textView3.setText("The result is: ")
            }

            if (elements1.selectedItemPosition == 1 && elements2.selectedItemPosition == 0) {
                textView3.setText("The result is: ")
            }

            if (elements1.selectedItemPosition == 1 && elements2.selectedItemPosition == 1) {
                textView3.setText("The result is: ")
            }

        }
    }
}