package com.example.fp_bp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // List of specialties
        val listOfSpecialties = listOf("Umum", "THT", "Kulit", "Gigi", "Penyakit Dalam", "Kandungan", "Saraf")

        // Get the chipContainer
        val chipContainer: LinearLayout = rootView.findViewById(R.id.chipContainer)

        // Dynamically add chips to the container
        listOfSpecialties.forEach { specialty ->
            val chip = Chip(requireContext()).apply {
                text = specialty
                isClickable = true
                isCheckable = true
            }
            chipContainer.addView(chip)
        }

        return rootView
    }
}
