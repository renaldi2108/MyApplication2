package com.example.ren.myapplication.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ren on 1/5/2018.
 */

public class ModelPopular {
    private int page, total_results, total_pages;
    private List<Results> results;

    public ModelPopular() {
    }

    public ModelPopular(int page, int total_results, int total_pages, List<Results> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results {
        private String poster_path, overview, release_date, original_title, original_language, title, backdrop_path;
        private int id, vote_count;
        private Double vote_average, popularity;
        private List<Integer> genre_ids;
        private boolean adult, video;

        public Results(String poster_path, boolean adult, String overview, String release_date, List<Integer> genre_ids,
                       int id, String original_title, String original_language, String title, String backdrop_path,
                       Double popularity, int vote_count, boolean video, Double vote_average) {
            this.poster_path = poster_path;
            this.overview = overview;
            this.release_date = release_date;
            this.original_title = original_title;
            this.original_language = original_language;
            this.title = title;
            this.backdrop_path = backdrop_path;
            this.id = id;
            this.popularity = popularity;
            this.vote_count = vote_count;
            this.vote_average = vote_average;
            this.adult = adult;
            this.video = video;
            this.genre_ids = genre_ids;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Double getPopularity() {
            return popularity;
        }

        public void setPopularity(Double popularity) {
            this.popularity = popularity;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public Double getVote_average() {
            return vote_average;
        }

        public void setVote_average(Double vote_average) {
            this.vote_average = vote_average;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
