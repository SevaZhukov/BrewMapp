package com.brewmapp.brewmapp.features.main.profile

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.SearchAdapter
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import kotlinx.android.synthetic.main.controller_search.view.*

class SearchController : MvpController<SearchContract.View, SearchContract.Presenter>(), SearchContract.View {
    companion object {
        val fieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_search, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        view.searchButton.setOnClickListener { presenter.search() }
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.setRecyclerData()
    }

    override fun createPresenter(): SearchContract.Presenter {
        return SearchPresenter()
    }

    override fun initAdapter(searches: ArrayList<Search>) {
        view!!.recycler.adapter = SearchAdapter(searches, activity)
    }

}