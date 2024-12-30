package com.example.fp_bp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.chip.Chip

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_search, container, false)

        // List of specialties
        val listOfSpecialties = listOf("#Illustrator", "#Novels", "#Manga")

        // Search functionality
        val doctorDataEditText: EditText = rootView.findViewById(R.id.editTextSearch)
        doctorDataEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                // Call the search method with the entered query
//                val searchResults = dbHelper.searchDoctors(query)
//                // Update the RecyclerView adapter with the search results
//                adapterDokter.updateData(searchResults)
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })

        // Get the chipContainer
        val chipContainer: LinearLayout = rootView.findViewById(R.id.chipContainer)

        // Dynamically add chips to the container
        listOfSpecialties.forEach { specialty ->
            val chip = Chip(requireContext()).apply {
                text = specialty
                isClickable = true
                isCheckable = true

                setBackgroundResource(R.drawable.rounded)

                // Add padding for better appearance
                setPadding(16, 8, 16, 8)

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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}