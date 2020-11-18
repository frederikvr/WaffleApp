package com.frederikvr.waffleapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class WaffleAdapter(
    public var mProducts: List<Product>,
) : RecyclerView.Adapter<WaffleAdapter.ViewHolder>() {

    private var plusListener1: ((item: Product) -> Unit)? = null
    private var plusListener2: ((item: Product) -> Unit)? = null
    private var minusListener1: ((item: Product) -> Unit)? = null
    private var minusListener2: ((item: Product) -> Unit)? = null

    fun plusButtonClickListener1(listener: (item: Product) -> Unit) {
        this.plusListener1 = listener
    }

    fun plusButtonClickListener2(listener: (item: Product) -> Unit) {
        this.plusListener2 = listener
    }

    fun minusButtonClickListener1(listener: (item: Product) -> Unit) {
        this.minusListener1 = listener
    }

    fun minusButtonClickListener2(listener: (item: Product) -> Unit) {
        this.minusListener2 = listener
    }

    // Haal de views op die je dynamisch wilt instellen
    public class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val productNameAddButton1 = itemView.findViewById<Button>(R.id.add_button1)
        val productNameAddButton2 = itemView.findViewById<Button>(R.id.add_button2)
        val productRemoveButton1 = itemView.findViewById<Button>(R.id.delete_button1)
        val productRemoveButton2 = itemView.findViewById<Button>(R.id.delete_button2)
        val amount1 = itemView.findViewById<TextView>(R.id.amount1)
        val amount2 = itemView.findViewById<TextView>(R.id.amount2)

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
        // Get the waffle which is currently being set in the recyclerview
        val product: Product = mProducts.get(position)

        // Every product item holds two products.

        /*    ***SET FIRST ITEM *** */

        // Get name of waffle object and set to text view
        val nameAddButton = viewHolder.productNameAddButton1
        val removeButton = viewHolder.productRemoveButton1

        nameAddButton.setText(product.label)

        // Get color to set buttons to
        var color = 0
        when (product.group2) {
            "aard" -> color = Color.BLUE
            "blader" -> color = Color.RED
            "frisdrank" -> color = Color.LTGRAY
            // ... add other cases

            // Default response
            else -> {
                color = Color.DKGRAY
            }
        }

        // Set color to buttons
        nameAddButton.setBackgroundColor(color)
        removeButton.setBackgroundColor(color)

        // Get amount text view
        val amountTextField1 = viewHolder.amount1

        // Handle plus button
        viewHolder.productNameAddButton1.setOnClickListener() { _ ->
            PlusOne(product, amountTextField1, 1)
        }

        // Handle minus button
        viewHolder.productRemoveButton1.setOnClickListener() { _ ->
            MinusOne(product, amountTextField1, 1)
        }

        /*    ***SET SECOND ITEM *** */
        // Get name of waffle object and set to text view
        val nameAddButton2 = viewHolder.productNameAddButton2
        val removeButton2 = viewHolder.productRemoveButton2

        nameAddButton2.setText(product.label2)

        // Get color to set buttons to
        var color2 = 0
        when (product.group) {
            "aard" -> color2 = Color.BLUE
            "blader" -> color2 = Color.RED
            "frisdrank" -> color2 = Color.CYAN
            // ... add other cases

            // Default response
            else -> {
                color2 = Color.DKGRAY
            }
        }

        // Set color to buttons
        nameAddButton2.setBackgroundColor(color2)
        removeButton2.setBackgroundColor(color2)

        // Get amount text view
        val amountTextField2 = viewHolder.amount2

        // Handle plus button
        viewHolder.productNameAddButton2.setOnClickListener() { _ ->
            PlusOne(product, amountTextField2, 2)
        }

        // Handle minus button
        viewHolder.productRemoveButton2.setOnClickListener() { _ ->
            MinusOne(product, amountTextField2, 2)
        }
    }

    private fun PlusOne(product: Product, amountTextField: TextView, i: Int) {
        var currentAmountProduct = -1

        // Get current amount
        if (i == 1)
            currentAmountProduct = product.amount
        else if (i == 2)
            currentAmountProduct = product.amount2

        // Add 1
        currentAmountProduct++

        // Update the amount text view
        amountTextField.setText(currentAmountProduct.toString())

        // Set the total amount and update Product
        if (i == 1)
            plusListener1?.invoke(product)
        else if (i == 2)
            plusListener2?.invoke(product)
    }

    private fun MinusOne(product: Product, amountTextField: TextView, i: Int) {
        var currentAmountProduct = -1
        // Get current amount
        if (i == 1)
            currentAmountProduct = product.amount
        else if (i == 2)
            currentAmountProduct = product.amount2

        // Don't handle when already 0
        if (currentAmountProduct != 0) {

            // Minus 1
            currentAmountProduct--

            // Update the textview
            amountTextField.setText(currentAmountProduct.toString())

            // Set the total amount in MainActivty
            if (i == 1)
                minusListener1?.invoke(product)
            else if (i == 2)
                minusListener2?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return mProducts.size
    }
}

class WaffleItemCallBack : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        TODO("Not yet implemented")
    }

}
