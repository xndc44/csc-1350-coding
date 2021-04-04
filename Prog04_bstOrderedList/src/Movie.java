
public class Movie implements Comparable<Movie>{
	private String movieTitle;  
	private int releaseYear;  
	private String rating; 
	private int movieReview;

	public Movie (String Title, int Year, String Rating, int Review) {
		movieTitle = Title;
        releaseYear = Year;
        this.rating = Rating;
        movieReview = Review;	
	}//movie

	public String getTitle() {
		
		return this.movieTitle;
	}//title

	public int getYear() {
		
		return this.releaseYear;
	}//year
	
	public String getRating() {
		
		return this.rating;
	}//getRating
	
	public int getReview() {
		
		return this.movieReview;
	}//getReview
	@Override
	 public int compareTo(Movie other) {
        int makeComparison = this.movieTitle .compareTo(other.movieTitle );

        if (makeComparison != 0) {
            return makeComparison;
        }//if
        else {
            if (this.releaseYear != other.releaseYear) {
                return this.releaseYear - other.releaseYear;
            }//if 
            else {
                return 0;
            }//else
        }//else
    }//compareTo
	
	public String toString() {
		
		return String.format("Title: %s, Year: %s, Rating: %s Review: %s;", this.movieTitle, this.releaseYear, this.rating, this.movieReview);
	}//toString
}//class
