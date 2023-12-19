package com.sparklead.cryptosync.ui.home

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.sparklead.cryptosync.databinding.FragmentHomeBinding
import com.sparklead.cryptosync.model.Crypto
import com.sparklead.cryptosync.ui.adapter.CryptoListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), OnRefreshListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var cryptoListAdapter: CryptoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setUpAdapter()
        binding.swipeContainer.setOnRefreshListener(this)
        viewModel.getCryptoList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.homeUiState.collect {
                when (it) {
                    is HomeUiState.Empty -> {

                    }

                    is HomeUiState.Error -> {
                        showError(it.message)
                    }

                    is HomeUiState.Loading -> {}

                    is HomeUiState.Success -> {
                        showSuccess(it.cryptoList)
                    }
                }
            }
        }
    }

    private fun showSuccess(cryptoList: List<Crypto>) {
        autoRefresh()
        binding.swipeContainer.isRefreshing = false
        Toast.makeText(requireContext(), "Refresh", Toast.LENGTH_SHORT).show()
        cryptoListAdapter.differ.submitList(cryptoList)
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpAdapter() {
        cryptoListAdapter = CryptoListAdapter()
        binding.rvCryptoList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cryptoListAdapter
        }
    }

    override fun onRefresh() {
        viewModel.getCryptoList()
    }

    private fun autoRefresh() {
        val timer = object : CountDownTimer(180000, 60000) {

            override fun onTick(p0: Long) {
                when (p0) {
                    in 120000..180000 -> {
                        binding.tvUpdateStatus.text = "Updated Now"
                    }

                    in 60000..120000 -> {
                        binding.tvUpdateStatus.text = "Updated 1 min ago"
                    }

                    else -> {
                        binding.tvUpdateStatus.text = "Updated 2 min ago"
                    }
                }
            }

            override fun onFinish() {
                viewModel.getCryptoList()
            }
        }
        timer.start()
    }
}