package papersplease;

public class Officer {
    private Bulletin bulletin;

    public void receiveBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }
}
