package com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uz.karolis.kotlinmoviebacklog.R
import com.uz.karolis.kotlinmoviebacklog.di.MovieBacklogApplication

import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 * <p />
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
class BackloggedMovieFragment : Fragment() {
    @Inject lateinit var backloggedMovieViewModel:BackloggedMovieViewModel
    private var mListener: OnBackloggedMovieFragmentClickListener? = null

    init {
        initializeDagger()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_backloggedmovie_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = BackloggedMovieRecyclerViewAdapter(backloggedMovieViewModel, mListener)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackloggedMovieFragmentClickListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    private fun initializeDagger() = MovieBacklogApplication.appComponent.inject(this)

    interface OnBackloggedMovieFragmentClickListener {
        fun onBackloggedMovieFragmentClick(movie: Movie)
    }

    companion object {
        //Fragment Initialization
        fun newInstance(): BackloggedMovieFragment {
            return BackloggedMovieFragment()
        }
    }
}
