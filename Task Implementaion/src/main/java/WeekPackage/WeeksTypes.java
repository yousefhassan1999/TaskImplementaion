package WeekPackage;

public enum WeeksTypes {
    Test("Test"),
    Filler("Filler"),
    Recovery("Recovery"),
    Build_1("Build 1"),
    Build_2("Build 2"),
    Key("Key"),
    Taper("Taper"),
    Race("Race");

    public final String label;

    private WeeksTypes(String label) {
        this.label = label;
    }
}
