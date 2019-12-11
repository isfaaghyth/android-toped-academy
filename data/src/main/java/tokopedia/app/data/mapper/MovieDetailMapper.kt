package tokopedia.app.data.mapper

import tokopedia.app.data.entity.Movie
import tokopedia.app.data.entity.MovieDetail
import tokopedia.app.data.entity.TVShow

object MovieDetailMapper {

    fun mapFromMovie(movie: Movie): MovieDetail {
        return MovieDetail(
            movie.id,
            movie.movieId,
            movie.title,
            movie.posterUrl(),
            movie.overview,
            movie.bannerUrl(),
            movie.voteCount,
            movie.voteAverage,
            movie.releaseDate
        )
    }

}