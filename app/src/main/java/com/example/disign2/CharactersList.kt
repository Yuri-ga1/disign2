package com.example.disign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.FragmentTransaction

class CharactersList : Fragment() {

    private lateinit var filterByElementBtn: LinearLayout
    private lateinit var filterByRoleBtn: LinearLayout
    private lateinit var filterByWeaponTypeBtn: LinearLayout

    private lateinit var optionsElements: LinearLayout
    private lateinit var optionsRole: LinearLayout
    private lateinit var optionsWeaponType: LinearLayout

    private lateinit var arrowElementFilter: ImageView
    private lateinit var arrowRoleFilter: ImageView
    private lateinit var arrowWeaponTypeFilter: ImageView

    private lateinit var characterProfile: CharacterProfile

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_characters_list, container, false)

        filterByElementBtn = view.findViewById(R.id.filterByElement)
        filterByRoleBtn = view.findViewById(R.id.filterByRole)
        filterByWeaponTypeBtn = view.findViewById(R.id.filterByWeaponType)

        createImages(view)


        filterByElementBtn.setOnClickListener{
            optionsElements = view.findViewById(R.id.optionsForElements)
            optionsElements.visibility = if (optionsElements.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            arrowElementFilter = view.findViewById(R.id.arrowElementFilter)
            flipImage(arrowElementFilter)
        }

        filterByRoleBtn.setOnClickListener{
            optionsRole = view.findViewById(R.id.optionsForRole)
            optionsRole.visibility = if (optionsRole.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            arrowRoleFilter = view.findViewById(R.id.arrowRoleFilter)
            flipImage(arrowRoleFilter)
        }

        filterByWeaponTypeBtn.setOnClickListener{
            optionsWeaponType = view.findViewById(R.id.optionsForWeaponType)
            optionsWeaponType.visibility = if (optionsWeaponType.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            arrowWeaponTypeFilter = view.findViewById(R.id.arrowWeaponTypeFilter)
            flipImage(arrowWeaponTypeFilter)
        }

        return view
    }

    private fun createImages(view: View) {
        val linearLayout: LinearLayout = view.findViewById(R.id.heroesList)

        for (i in 1..20) {
            val imageView = ImageView(requireContext())
            imageView.setImageResource(R.drawable.heros_info)
            imageView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            imageView.setOnClickListener {
                openCharacterProfile()
            }

            linearLayout.addView(imageView)
        }
    }

    private fun openCharacterProfile() {
        characterProfile = CharacterProfile()
        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
        ft.replace(R.id.contentZone, characterProfile)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun flipImage(imageView: ImageView) {
        val currentRotation = imageView.rotation
        val newRotation = if (currentRotation == 0f) 180f else 0f
        imageView.animate().rotation(newRotation).start()
    }
}