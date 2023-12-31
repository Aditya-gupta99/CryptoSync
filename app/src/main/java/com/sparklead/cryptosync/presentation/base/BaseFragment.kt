package com.sparklead.cryptosync.presentation.base

import android.app.Dialog
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sparklead.cryptosync.R

open class BaseFragment : Fragment() {

    private lateinit var loadingDialog : Dialog

    fun showLoadingDialog(){

        loadingDialog = Dialog(requireContext())

        loadingDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.dialog_loading)
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
        }
    }

    fun hideLoading(){
        loadingDialog.let { if (it.isShowing)it.cancel() }
    }

    fun showErrorSnackBar(message: String, errorMessage: Boolean,onClick: () ->Unit){
        val snackBar = Snackbar.make(requireActivity().findViewById(android.R.id.content),message, Snackbar.LENGTH_INDEFINITE)

        val snackBarView = snackBar.view

        snackBar.setAction("Retry") {
            onClick()
        }

        if(errorMessage){
            snackBarView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorSnackBarError))
        }
        else
        {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(requireContext(), R.color.colorSnackBarSuccess))
        }
        snackBar.show()
    }

}