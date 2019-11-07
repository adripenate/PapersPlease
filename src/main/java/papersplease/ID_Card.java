package papersplease;

public class ID_Card {
    private final String district;
    private final String name;
    private final String dateOfBirth;
    private final int height;
    private final int weight;

    public ID_Card(String district, String name, String dateOfBirth, int height, int weight) {
        this.district = district;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
    }
}
