package com.example.fp_bp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bp.response.images.ImagesResponse
import com.squareup.picasso.Picasso
import com.example.fp_bp.R

class AdapterImgHome(private val listImages: ArrayList<ImagesResponse>) : RecyclerView.Adapter<AdapterImgHome.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgHome: ImageView = v.findViewById(R.id.imageView)

        fun bind(response: ImagesResponse) {
            val images = response.image_url

            // library picasso
            val url = "http://192.168.56.1/rest_api_fp/index.php/picture/${response.image_url}"
            Picasso.get().load(url).into(imgHome)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_home, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int {
        return listImages.size
    }
}
