package com.example.disign2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

class WeaponsList : Fragment() {

    private lateinit var filterByElementBtn: LinearLayout
    private lateinit var filterByRarityBtn: LinearLayout
    private lateinit var filterByChainBtn: LinearLayout
    private lateinit var filterByWeaponTypeBtn: LinearLayout

    private lateinit var optionsElements: LinearLayout
    private lateinit var optionsRarity: LinearLayout
    private lateinit var optionsChain: LinearLayout
    private lateinit var optionsWeaponType: LinearLayout

    private lateinit var arrowElementFilter: ImageView
    private lateinit var arrowRarityFilter: ImageView
    private lateinit var arrowChainFilter: ImageView
    private lateinit var arrowWeaponTypeFilter: ImageView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weapons_list, container, false)

        filterByElementBtn = view.findViewById(R.id.filterByElement)
        filterByRarityBtn = view.findViewById(R.id.filterByRarity)
        filterByChainBtn = view.findViewById(R.id.filterByChain)
        filterByWeaponTypeBtn = view.findViewById(R.id.filterByWeaponType)

        createImages(view)


        filterByElementBtn.setOnClickListener{
            optionsElements = view.findViewById(R.id.optionsForElements)
            optionsElements.visibility = if (optionsElements.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            arrowElementFilter = view.findViewById(R.id.arrowElementFilter)
            flipImage(arrowElementFilter)
        }

        filterByRarityBtn.setOnClickListener{
            optionsRarity = view.findViewById(R.id.optionsForRarity)
            optionsRarity.visibility = if (optionsRarity.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            arrowRarityFilter = view.findViewById(R.id.arrowRarityFilter)
            flipImage(arrowRarityFilter)
        }

        filterByChainBtn.setOnClickListener{
            optionsChain = view.findViewById(R.id.optionsForChain)
            optionsChain.visibility = if (optionsChain.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            arrowChainFilter = view.findViewById(R.id.arrowChainFilter)
            flipImage(arrowChainFilter)
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
        val linearLayout: LinearLayout = view.findViewById(R.id.weaponsList)

        //horizontal Layout
        for (i in 1..20) {
            val rowLayout = LinearLayout(requireContext())
            rowLayout.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            rowLayout.orientation = LinearLayout.HORIZONTAL

            // add images in Layout
            for (j in 1..2) {
                val imageView = ImageView(requireContext())
                imageView.setImageResource(R.drawable.weapon_info)

                val layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1.0f
                )
                imageView.layoutParams = layoutParams


                rowLayout.addView(imageView)
            }
            rowLayout.setPadding(0, 0, 0, 15)

            linearLayout.addView(rowLayout)
        }
    }

    private fun flipImage(imageView: ImageView) {
        val currentRotation = imageView.rotation
        val newRotation = if (currentRotation == 0f) 180f else 0f
        imageView.animate().rotation(newRotation).start()
    }
}