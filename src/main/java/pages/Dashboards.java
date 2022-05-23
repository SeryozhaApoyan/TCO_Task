package pages;

public enum Dashboards {
    BLDO("Bldo"),
    PARTNER("Partner"),
    ;

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    Dashboards(String displayName) {
        this.displayName = displayName;
    }
}
