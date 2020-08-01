package com.twu.biblioteca.movie;

import com.twu.biblioteca.book.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    public static List<Movie> availableMovies = new ArrayList<>(Arrays.asList(
            new Movie("Green Book","Peter Farrelly",Year.of(2018)),
            new Movie("The Shawshank Redemption","Frank Darabont",Year.of(1994)),
            new Movie("The Godfather","Francis Ford Coppola",Year.of(1972)),
            new Movie("The Godfather: Part II","Francis Ford Coppola",Year.of(1974))
    ));

    public MovieRepository(List<Movie> availableMovies) {
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }
    public void addMovie(Movie movie) {
        availableMovies.add(movie);
    }

    public boolean checkOutMovie(String title){
        Movie MovieWouldLikeToCheckOut = availableMovies.stream().filter(movie -> movie.getTitle().equals(title))
                .findFirst().orElse(null);
        if(MovieWouldLikeToCheckOut != null){
            availableMovies.remove(MovieWouldLikeToCheckOut);
            return true;
        }else{
            return false;
        }
    }
}