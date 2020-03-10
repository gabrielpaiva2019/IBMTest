package com.paivadeveloper.ibmtest.ui.transaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.Statement

class TransactionAdapter(private var listStatements: MutableList<Statement.StatementItem>) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_statement, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return listStatements.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }



}