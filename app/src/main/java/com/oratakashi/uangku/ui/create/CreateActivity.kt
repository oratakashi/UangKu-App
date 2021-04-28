package com.oratakashi.uangku.ui.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oratakashi.uangku.R
import com.oratakashi.uangku.databinding.ActivityCreateBinding
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.tools.toast
import com.oratakashi.viewbinding.core.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CreateActivity : AppCompatActivity(), CreateContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding){
            presenter.setView(this@CreateActivity)
            btnSubmit.onClick {
                if(
                    etDiterimaDari.text.toString().isNotEmpty() &&
                    etKeterangan.text.toString().isNotEmpty() &&
                    etJumlah.text.toString().isNotEmpty()
                ){
                    presenter.insertData(
                        etDiterimaDari.text.toString(),
                        etKeterangan.text.toString(),
                        etJumlah.text.toString()
                    )
                }else{
                    toast("Mohon lengkapi data!")
                }
            }
        }
    }

    override fun onResult(result: Boolean) {
        if(result){
            toast("Data Berhasil di tambah!")
            finish()
        }
    }

    override fun onError(error: Throwable?) {
        toast("${error?.message}")
    }

    @Inject
    lateinit var presenter: CreatePresenter
    private val binding : ActivityCreateBinding by viewBinding()
}