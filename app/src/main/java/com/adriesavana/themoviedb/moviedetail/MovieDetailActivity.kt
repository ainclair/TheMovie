package com.adriesavana.themoviedb.moviedetail

import android.os.Bundle
import com.adriesavana.kit.extension.disposedBy
import com.adriesavana.movie.model.MovieDetail
import com.adriesavana.themoviedb.R
import com.adriesavana.themoviedb.common.base.BaseActivity

class MovieDetailActivity : BaseActivity<MovieDetailViewModelType>() {

    companion object {
        const val TAG = "MovieDetailActivity"
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieDetail = intent.extras.get(EXTRA_MOVIE) as? MovieDetail
        viewModel.inputs.onViewLoaded(movieDetail)
    }

    override fun bindViewModel() {
        super.bindViewModel()

        viewModel.outputs.errorMessage.subscribe{}.disposedBy(compositeDisposable)
    }
}
