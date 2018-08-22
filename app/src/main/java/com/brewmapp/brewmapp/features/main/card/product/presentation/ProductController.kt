package com.brewmapp.brewmapp.features.main.profile

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel.Model
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.ParamAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.controller_product.view.*

class ProductController() : BaseController<ProductContract.View, ProductContract.Presenter>(), ProductContract.View {

    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_product, container, false)
        view.paramRecycler.layoutManager = LinearLayoutManager(activity!!)
        return view
    }

    override fun createPresenter(): ProductContract.Presenter {
        return ProductPresenter()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        //showProgress()
        presenter.getProduct(id)
    }

    override fun setParams(paramsList: MutableList<Param>) {
        view!!.paramRecycler.adapter = ParamAdapter(paramsList)
    }

    override fun setProduct(model: Model) {
        view!!.text.text = model.text.get1()
        view!!.likes.text = model.like
        view!!.dislikes.text = model.disLike
        view!!.strength.text = model.relations.beerStrength.name
        Glide.with(activity!!)
                .load(model.getThumb)
                .into(view!!.image)
    }
}