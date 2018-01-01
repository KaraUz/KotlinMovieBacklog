package com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment

import android.app.Application
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.uz.karolis.kotlinmoviebacklog.R

import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.fragment_backloggedmovie.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class BackloggedMovieRecyclerViewAdapter(
        private val mViewModel: BackloggedMovieViewModel,
        private val mListener: BackloggedMovieFragment.OnBackloggedMovieFragmentClickListener?)
    : RecyclerView.Adapter<BackloggedMovieRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Movie
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onBackloggedMovieFragmentClick(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_backloggedmovie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mViewModel.backloggedMovies.value?.get(position)
        holder.mIdView.text = item?.title
        holder.mContentView.text = item?.type

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mViewModel.backloggedMovies.value?.size ?: 0

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        //val mMovieCard: CardView
        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
