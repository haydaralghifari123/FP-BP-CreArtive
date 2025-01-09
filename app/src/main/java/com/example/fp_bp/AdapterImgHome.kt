package com.example.fp_bp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fp_bp.client.RetrofitClient
import com.example.fp_bp.response.images.ImagesResponse
import com.squareup.picasso.Picasso

class AdapterImgHome(private val listImages: ArrayList<ImagesResponse>) : RecyclerView.Adapter<AdapterImgHome.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgHome: ImageView = v.findViewById(R.id.imageView)

        fun bind(response: ImagesResponse) {
            val images = response.image_url
            Toast.makeText(itemView.context, images, Toast.LENGTH_SHORT).show()

            // library picasso
            val img = RetrofitClient.url + images
            Picasso.get().load(img).into(imgHome)
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
