package com.example.disign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var textCharacters: TextView
    private lateinit var textWeapons: TextView

    //fragments
    private lateinit var characters: CharactersList
    private lateinit var weapons: WeaponsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        characters = CharactersList()
        weapons = WeaponsList()
        setNewFragment(characters)

        textCharacters = findViewById(R.id.characters)
        textWeapons = findViewById(R.id.weapons)

        textCharacters.setOnClickListener{
            textCharacters.setTextColor(ContextCompat.getColor(this, R.color.purple))
            textWeapons.setTextColor(ContextCompat.getColor(this, R.color.white))
            setNewFragment(characters)
        }

        textWeapons.setOnClickListener{
            textWeapons.setTextColor(ContextCompat.getColor(this, R.color.purple))
            textCharacters.setTextColor(ContextCompat.getColor(this, R.color.white))
            setNewFragment(weapons)
        }
    }

    private fun setNewFragment(fragment: Fragment) {
        val ft: FragmentTransaction = getSupportFragmentManager().beginTransaction()
        ft.replace(R.id.contentZone, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}