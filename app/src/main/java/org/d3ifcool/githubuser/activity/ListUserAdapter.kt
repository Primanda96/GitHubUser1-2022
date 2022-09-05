package org.d3ifcool.githubuser.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.githubuser.User
import org.d3ifcool.githubuser.databinding.ItemRowUserBinding

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,username,avatar, company, location, repository, follower, following ) = listUser[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemUsername.text = username
        if (avatar != null) {
            holder.binding.imgItemPhoto.setImageResource(avatar)
        }
        holder.binding.tvItemCompany.text = company
        holder.binding.tvItemLocation.text = location
        holder.binding.tvItemRepository.text = repository
        holder.binding.tvItemFollower.text = follower
        holder.binding.tvItemFollowing.text = following
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUser.size

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }
}