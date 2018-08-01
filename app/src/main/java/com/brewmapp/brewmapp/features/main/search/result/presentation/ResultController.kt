package com.brewmapp.brewmapp.features.main.search.result.presentation

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import com.brewmapp.brewmapp.features.main.search.result.presentation.recycler.ResultAdapter
import kotlinx.android.synthetic.main.controller_result.view.*

class ResultController : BaseController<ResultContract.View, ResultContract.Presenter>(), ResultContract.View {

    override fun createPresenter(): ResultContract.Presenter {
        return ResultPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_result, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.setRecyclerData()
        showProgress()
    }

    override fun setAdapter(models: List<Model>) {
        hideProgress()
        view!!.recycler.adapter = ResultAdapter(models, router)
    }
}