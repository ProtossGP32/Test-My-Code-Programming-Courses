
public class Song {

    private String artist;
    private String name;
    private int durationInSeconds;

    public Song(String artist, String name, int durationInSeconds) {
        this.artist = artist;
        this.name = name;
        this.durationInSeconds = durationInSeconds;
    }

    public boolean equals(Object compared) {
        // If the variables are located in the same position, they are equal
        if (this == compared) {
            return true;
        }

        // If the compared object is not of type Song, the objects aren't equal
        if (!(compared instanceof Song)) {
            return false;
        }

        // Convert the object into a Song object
        Song comparedSong = (Song) compared;

        // If the values of the object variables are equal, the objects are equal
        if (this.artist.equals(comparedSong.artist) &&
                this.name.equals(comparedSong.name) &&
                this.durationInSeconds == comparedSong.durationInSeconds) {
            return true;
        }

        // Otherwise, the objects are not equal
        return false;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.durationInSeconds + " s)";
    }


}
