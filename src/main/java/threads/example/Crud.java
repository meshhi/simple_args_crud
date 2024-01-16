package threads.example;

enum Crud {
    CREATE("-c"),
    READ("-r"),
    UPDATE("-u"),
    DELETE("-d");
    
    public final String label;

    private Crud(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
