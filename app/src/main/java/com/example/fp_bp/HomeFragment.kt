package com.example.fp_bp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.material.chip.Chip
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bp.client.RetrofitClient
import com.example.fp_bp.response.images.ImagesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    // declare array list of images
    private val listImages = ArrayList<ImagesResponse>()

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

        // add data to recycler view
        val rvHome: RecyclerView = rootView.findViewById(R.id.recyclerViewHome)
        rvHome.layoutManager = GridLayoutManager(activity, 2)

        // response dari REST API
        RetrofitClient.instance.getImages().enqueue(object : Callback<List<ImagesResponse>> {
            override fun onResponse(
                call: Call<List<ImagesResponse>>,
                response: Response<List<ImagesResponse>>
            ) {
                listImages.clear()
                response.body()?.let {
                    listImages.addAll(it)
                }
                // set adapter
                val adapterImgHome = AdapterImgHome(listImages)
                rvHome.adapter = adapterImgHome
            }

            override fun onFailure(call: Call<List<ImagesResponse>>, t: Throwable) {
                // Handle the error
                t.printStackTrace()
            }
        })

        return rootView
    }
}

// BLM BERHASIL MUNCUL FOTO2NYA