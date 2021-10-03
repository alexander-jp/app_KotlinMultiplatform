package com.mundet.app_multiplatform.ui.presenter

import com.mundet.app_multiplatform.data.repository.PoiRepository
import com.mundet.app_multiplatform.domain.model.Poi
import com.mundet.app_multiplatform.ui.executor.Executor
import kotlinx.coroutines.launch

class PoiListPresenter(
    private val repository : PoiRepository,
    executor: Executor,
    view: PoiListView
) : Presenter<PoiListView>(executor, view) {

    override fun attach() {
        scope.launch {
            view.showProgress()

            execute { repository.getPoiList() }
                .fold(
                    error = { println(it)},
                    success = { view.showPoiList(it) }
                )

            view.hideProgress()
        }
    }

    fun onPoiTap(poi : Poi) {
        println(poi)
    }

}

interface PoiListView : View {
    fun showPoiList(poiList : List<Poi>)
}