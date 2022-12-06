public class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public void printDetails(String level) {
        switch (level) {
            case "everything":
                System.out.println(this.getTitle() + ", " + this.getPages() + " pages, " + this.getYear());
                break;
            case "name":
                System.out.println(this.getTitle());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
        /*
        if (level.equals("everything")) {

        } else if (level.equals("name")) {
            System.out.println(this.getTitle());
        }*/
    }
}
