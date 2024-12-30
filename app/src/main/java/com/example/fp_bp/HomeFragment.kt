package com.example.fp_bp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.chip.Chip
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // List of specialties
        val listOfSpecialties = listOf("All", "Following", "Illustrator", "Novels", "Manga")


        // Get the chipContainer
        val chipContainer: LinearLayout = rootView.findViewById(R.id.chipContainer)

        // Dynamically add chips to the container
        listOfSpecialties.forEach { specialty ->
            val chip = Chip(requireContext()).apply {
                text = specialty
                isClickable = true
                isCheckable = true

                // Add margin to the chip
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                layoutParams.setMargins(8, 5, 8, 0) // Left, Top, Right, Bottom
                this.layoutParams = layoutParams
            }
            chipContainer.addView(chip)
        }

        return rootView
    }
}
