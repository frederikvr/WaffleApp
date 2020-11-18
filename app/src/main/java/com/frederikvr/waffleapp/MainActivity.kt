package com.frederikvr.waffleapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val totalTextView = findViewById<View>(R.id.dynamicTotal) as TextView
        val rvWaffles1 = findViewById<View>(R.id.waffle_list) as RecyclerView
        val resetButton = findViewById<Button>(R.id.resetbutton) as Button
        val printButton = findViewById<Button>(R.id.printButton) as Button

        val productList = ProductBuilder.getProducts()
        val adapter = BuildAdapter(productList, totalTextView)

        rvWaffles1.adapter = adapter
        rvWaffles1.layoutManager = LinearLayoutManager(this)

        resetButton.setOnClickListener { it ->
            // Reset the recylerview by building a fresh adapter and setting  it
            rvWaffles1.adapter = BuildAdapter(ProductBuilder.getProducts(), totalTextView)

            totalTextView.setText(0.0.toString())
        }

        printButton.setOnClickListener {
            // Add print logic
        }
    }

    private fun BuildAdapter(productList: List<Product>, totalTextView : TextView): WaffleAdapter {
        val adapter = WaffleAdapter(productList)

        adapter.plusButtonClickListener1 { it ->
            PlusUpdateTotalAndAmount(totalTextView, it, 1)
        }

        adapter.minusButtonClickListener1 { it ->
            MinusUpdateTotalAndAmount(totalTextView, it, 1)
        }

        adapter.plusButtonClickListener2 { it ->
            PlusUpdateTotalAndAmount(totalTextView, it, 2)
        }

        adapter.minusButtonClickListener2 { it ->
            MinusUpdateTotalAndAmount(totalTextView, it, 2)
        }

        return adapter;
    }

    private fun PlusUpdateTotalAndAmount(total: TextView, it: Product, i: Int) {
        if (i == 1) {
            // Update total amount textview
            var currentTotalAmount = total.text.toString().toDouble()
            currentTotalAmount += it.price

            total.setText(currentTotalAmount.toString())

            // Update product object
            var currentProductAmount = it.amount

            currentProductAmount++

            it.amount = currentProductAmount
        } else if (i == 2) {
            // Update total amount textview
            var currentTotalAmount = total.text.toString().toDouble()
            currentTotalAmount += it.price

            total.setText(currentTotalAmount.toString())

            // Update product object
            var currentProductAmount = it.amount2

            currentProductAmount++

            it.amount2 = currentProductAmount
        }

    }


    fun MinusUpdateTotalAndAmount(total: TextView, it: Product, i: Int) {
        if (i == 1) {
            if (it.amount > 0) {
                // Update text view
                var currentTotalAmount = total.text.toString().toDouble()
                currentTotalAmount -= it.price

                total.setText(currentTotalAmount.toString())

                // Update Product object
                var currentProductAmount = it.amount

                currentProductAmount--

                it.amount = currentProductAmount
            }
        } else if (i == 2) {
            if (it.amount2 > 0) {
                // Update text view
                var currentTotalAmount = total.text.toString().toDouble()
                currentTotalAmount -= it.price

                total.setText(currentTotalAmount.toString())

                // Update Product object
                var currentProductAmount = it.amount2

                currentProductAmount--

                it.amount2 = currentProductAmount
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }
}
