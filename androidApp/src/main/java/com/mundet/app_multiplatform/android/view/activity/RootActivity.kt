package com.mundet.app_multiplatform.android.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mundet.app_multiplatform.android.R
import com.mundet.app_multiplatform.ui.presenter.Presenter
import com.mundet.app_multiplatform.ui.presenter.View as PresenterView

abstract class RootActivity<out V : PresenterView> : AppCompatActivity(), PresenterView {

    abstract val presenter: Presenter<V>

    abstract val layoutId: Int

    private val progress: View by lazy { findViewById(R.id.layout_progress) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
        initializeUi()
        registerListener()

        presenter.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    abstract fun registerListener()

    abstract fun initializeUi()

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

}