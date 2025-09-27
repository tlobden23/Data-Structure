public class CacheEntry {

    // attribute
    private String name;
    private String value;

    // constructor
    public CacheEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // getters
    public String getName() {
        return this.name;
    }
    public String getValue() {
        return this.value;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // toString method
    @Override
    public String toString(){
        return String.format("Name: %s Value: %s", this.getName(), this.getValue());
    }
}
