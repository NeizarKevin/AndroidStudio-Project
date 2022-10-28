package com.dicoding.pmplidapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListTeamsAdapter(private val listTeams: ArrayList<Teams>) : RecyclerView.Adapter<ListTeamsAdapter.ListViewHolder> () {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvProfile: TextView = itemView.findViewById(R.id.tv_item_profile)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_teams, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val team = listTeams[position]

        Glide.with(holder.itemView.context)
            .load(team.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = team.name
        holder.tvProfile.text = team.profile

        val intent = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveProfileTeams = Intent(intent, ProfileTeams::class.java)
            moveProfileTeams.putExtra(ProfileTeams.EXTRA_NAME, team.name)
            moveProfileTeams.putExtra(ProfileTeams.EXTRA_PHOTO, team.photo)
            moveProfileTeams.putExtra(ProfileTeams.EXTRA_SOSMED, team.sosmed)
            moveProfileTeams.putExtra(ProfileTeams.EXTRA_PROFILE, team.profile)
            intent.startActivity(moveProfileTeams)
        }
    }

    override fun getItemCount(): Int {
        return listTeams.size
    }
}