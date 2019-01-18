package enums;

public enum PointLocationEnum {
    ON("Point lies on the sides of the quadrilateral."),
    END("Point is the top of the quadrilateral."),
    OUTSIDE("Point is outside the quadrilateral."),
    INSIDE("Point is inside the quadrilateral."),
    ABOVE("Default"),
    BELOW("Default");

    private String description;

    PointLocationEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
