package com.frederikvr.waffleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil

class WaffleAdapter (private val mWaffles: List<WaffleItem>) : RecyclerView.Adapter<WaffleAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val waffleNameTextView = itemView.findViewById<TextView>(R.id.waffle_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val waffleView = inflater.inflate(R.layout.list_item_waffle, parent, false)
        // Return a new holder instance
        return ViewHolder(waffleView)
    }


    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: WaffleAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val waffle: WaffleItem = mWaffles.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.waffleNameTextView
        textView.setText(waffle.name)
        /*
        val button = viewHolder.messageButton
        button.text = if (contact.isOnline) "Message" else "Offline"
        button.isEnabled = contact.isOnline*/
    }


    override fun getItemCount(): Int {
        return mWaffles.size
    }


}

class WaffleItemCallBack : DiffUtil.ItemCallback<WaffleItem>() {
    override fun areItemsTheSame(oldItem: WaffleItem, newItem: WaffleItem): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: WaffleItem, newItem: WaffleItem): Boolean {
        TODO("Not yet implemented")
    }

}
