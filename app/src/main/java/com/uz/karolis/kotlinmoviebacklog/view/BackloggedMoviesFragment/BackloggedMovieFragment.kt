package com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
import android.databinding.adapters.TextViewBindingAdapter.setText
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * A fragment representing a list of Items.
 * <p />
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
class BackloggedMovieFragment : Fragment() {
    private lateinit var backloggedMovieViewModel:BackloggedMovieViewModel
    private var mListener: OnBackloggedMovieFragmentClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_backloggedmovie_list, container, false)
        backloggedMovieViewModel = ViewModelProviders.of(this).get(BackloggedMovieViewModel::class.java)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = BackloggedMovieRecyclerViewAdapter(backloggedMovieViewModel, mListener)

            // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
            backloggedMovieViewModel.backloggedMovies.observe(this, Observer<List<Movie>> {
                _ -> view.adapter.notifyDataSetChanged()
            })
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
