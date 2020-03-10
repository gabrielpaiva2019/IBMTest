package com.paivadeveloper.ibmtest.ui.transaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.Statement
import com.paivadeveloper.ibmtest.util.DateUtil
import kotlinx.android.synthetic.main.item_statement.view.*
import java.text.NumberFormat


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
        var statement = listStatements[position]
        val valueFormatted = NumberFormat.getCurrencyInstance().format(statement.value)
        val dateFormatted = DateUtil().getFormattedDate(statement.date)

        holder.textViewTransactionValue.text = valueFormatted
        holder.textViewTransactionDate.text = dateFormatted
        holder.textViewTransactionDescription.text = statement.desc
        holder.textViewTransactionType.text = statement.title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTransactionType = itemView.textViewTransactionType
        var textViewTransactionDescription = itemView.textViewTransactionDescription
        var textViewTransactionValue = itemView.textViewTransactionValue
        var textViewTransactionDate = itemView.textViewTransactionDate
    }
}