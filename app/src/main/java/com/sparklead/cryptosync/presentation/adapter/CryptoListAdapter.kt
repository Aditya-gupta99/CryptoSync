package com.sparklead.cryptosync.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.cryptosync.databinding.ItemCryptoListBinding
import com.sparklead.cryptosync.domain.model.Crypto
import com.sparklead.cryptosync.common.GlideLoader
import java.math.RoundingMode
import java.text.DecimalFormat

class CryptoListAdapter : RecyclerView.Adapter<CryptoListAdapter.CryptoViewHolder>() {

    inner class CryptoViewHolder(val binding : ItemCryptoListBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Crypto>() {

        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem.exchange == newItem.exchange
        }

        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        return CryptoViewHolder(ItemCryptoListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        with(holder){
            with(differ.currentList[position]){
                binding.tvCryptoName.text = this.fullName
                val df = DecimalFormat("#.######")
                df.roundingMode = RoundingMode.DOWN
                binding.tvExchange.text = df.format(this.exchange)
                GlideLoader(holder.itemView.context).loadAnimePicture(this.icon,binding.ivCryptoIcon)
            }
        }
    }
}