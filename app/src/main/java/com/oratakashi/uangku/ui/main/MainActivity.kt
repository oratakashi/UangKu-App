package com.oratakashi.uangku.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.oratakashi.uangku.R
import com.oratakashi.uangku.data.model.UangMasuk
import com.oratakashi.uangku.databinding.ActivityMainBinding
import com.oratakashi.uangku.ui.create.CreateActivity
import com.oratakashi.viewbinding.core.tools.onClick
import com.oratakashi.viewbinding.core.tools.startActivity
import com.oratakashi.viewbinding.core.tools.toast
import com.oratakashi.viewbinding.core.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Abdul Hafiidh Septiandaru
 * 28 April 2021
 * github : https://github.com/oratakashi
 **/

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter : MainAdapter by lazy {
        MainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding){
            fab.onClick { startActivity(CreateActivity::class.java) }
            rvMain.also {
                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this@MainActivity)
                it.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            }
            presenter.setView(this@MainActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getData()
    }

    override fun onResult(result: List<UangMasuk>) {
        adapter.submitData(result)
    }

    override fun onError(error: Throwable?) {
        toast("${error?.message}")
    }

    @Inject
    lateinit var presenter: MainPresenter
    private val binding : ActivityMainBinding by viewBinding()
}