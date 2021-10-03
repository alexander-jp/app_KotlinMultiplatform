package com.mundet.app_multiplatform.android.view.activity

import com.mundet.app_multiplatform.android.R
import com.mundet.app_multiplatform.data.local.SQLDelightLocal
import com.mundet.app_multiplatform.data.remote.KtorRemote
import com.mundet.app_multiplatform.data.repository.CommonPoiRepository
import com.mundet.app_multiplatform.domain.model.Poi
import com.mundet.app_multiplatform.ui.executor.Executor
import com.mundet.app_multiplatform.ui.presenter.PoiListPresenter
import com.mundet.app_multiplatform.ui.presenter.PoiListView
import com.mundet.app_multiplatform.ui.presenter.Presenter

class PoiListActivity : RootActivity<PoiListView>(), PoiListView {

    override val presenter by lazy {
        PoiListPresenter(
            repository = CommonPoiRepository(local = SQLDelightLocal(), remote = KtorRemote()),
            executor = Executor(),
            view = this
        )
    }
    override val layoutId: Int = R.layout.activity_poi_list

    override fun registerListener() {
        TODO("Not yet implemented")
    }

    override fun initializeUi() {
        //Nothing to do
    }

    override fun showPoiList(poiList: List<Poi>) {
        TODO("Not yet implemented")
    }
}