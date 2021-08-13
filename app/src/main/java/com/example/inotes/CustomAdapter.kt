package com.example.inotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private  val context : Context , private  val listner: Iclick) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

     val allnotes = ArrayList<Notes>()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val dbutton = view.findViewById<ImageView>(R.id.imageView)

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)


        }
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val cunote = allnotes[position]
        viewHolder.textView.text = cunote.text

    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
        val ViewHolder = CustomAdapter.ViewHolder(view);
     view.findViewById<ImageView>(R.id.imageView).setOnClickListener {
         listner.Onitemclick(allnotes[ViewHolder.adapterPosition])

     }


        return ViewHolder
    }

    // Replace the contents of a view (invoked by the layout manager)


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int
    {
        return allnotes.size
    }
    fun updatelist(newslist : List<Notes>)
    {
        allnotes.clear()
        allnotes.addAll(newslist)
        notifyDataSetChanged()
    }



}
interface Iclick
{
    fun Onitemclick(note: Notes)
}
