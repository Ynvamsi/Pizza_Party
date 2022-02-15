package com.zybooks.pizzaparty

import android.annotation.SuppressLint
import android.util.Log
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

const val TAG = "MainActivity"
//const val SLICES_PER_PIZZA = 8
/**
 * MainActivity class which has onCreate and calculateClick methods
 *
 * @author Naga Vamsi
 *
 * @param numAttendStr is the number of people attending
 * @param hungerLevel gives the level of hungry selected through the radio buttons
 * @property calculateClick helps in calculating the number of pizzas needed for the input number numAttendStr
 *
 */
class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup


    /**
     * onCreate is responsible to create the activity and start it.
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate was called")
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * calculateClick gives the number of pizzas needed.
     *
     * @param numAttendStr gives the string value of number of people attended the party
     * @return the value of pizzas needed
     * @receiver PizzaCalculator receives the function call to calculate the count
     */
    @SuppressLint("StringFormatInvalid")
    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toIntOrNull() ?: 0

        // Get hunger level selection
        val hungerLevel = when (howHungryRadioGroup.getCheckedRadioButtonId()) {
            R.id.light_radio_button -> PizzaCalculator.HungerLevel.LIGHT
            R.id.medium_radio_button -> PizzaCalculator.HungerLevel.MEDIUM
            else -> PizzaCalculator.HungerLevel.RAVENOUS
        }

        // Get the number of pizzas needed
        val calc = PizzaCalculator(numAttend, hungerLevel)
        val totalPizzas = calc.totalPizzas

        // Place totalPizzas into the string resource and display
        val totalText = getString(R.string.total_pizzas, totalPizzas)
        numPizzasTextView.setText(totalText)
    }
}
