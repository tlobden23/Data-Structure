public class ArrayCache {
    // attribute
    private CacheEntry[] entries;
    private int numEntries;
    private int numHits;
    private int numMisses;

    // default constructor
    public ArrayCache(){
        this.entries = new CacheEntry[10];
        this.numEntries = 0;
        this.numHits = 0;
        this.numMisses = 0;
    }

    // overloaded constructor with size as parameter
    public ArrayCache(int szCacheEntries){
        this.entries = new CacheEntry[szCacheEntries];
        this.numEntries = 0;
        this.numHits = 0;
        this.numMisses = 0;
    }

    // getters
    public String get(String name) {
        // variable to hold the found ip address
        CacheEntry found;
        // iterate through the entries array up to numEntries
        for (int i = 0; i < this.numEntries; i++) {
            // check if the name at the index is the same as the one we are searching for
            if (entries[i].getName().equals(name)) {
                // hold the object at index i
                found = this.entries[i];
                // shift everything before index i
                shiftEntries(i);
                // move the found at the front of the array
                this.entries[0] = found;
                // add one to numHits
                this.numHits++;
                // return the ip address of the found value
                return found.getValue();
            }
        }
        // if not found in the array
        // add one to numMisses
        this.numMisses++;
        // return null
        return null;
    }

    public int getHits() {
        return this.numHits;
    }

    public int getMisses() {
        return this.numMisses;
    }

    public int getLength() {
        return this.entries.length;
    }

    // setters
    public void put(String name, String value) {
        // if entries is less than capacity of array add to array
        if (this.getLength() != numEntries) {
            // if array isn't empty then shift values before replacing index 0
            if (!isEmpty()) {
                // shift all values to the right
                shiftEntries(this.numEntries);
            }
            // replace the first index 0
            entries[0] = new CacheEntry(name, value);
            // add one to numEntries
            numEntries++;
        } else {
            // shift everything to the right and lose the last element (capacity-1)
            shiftEntries(this.getLength()-1);
            // replace the first index 0
            entries[0] = new CacheEntry(name, value);
        }
    }

    public void clear(){
        this.numEntries = 0;
        this.numHits = 0;
        this.numMisses = 0;
    }

    public boolean isEmpty(){
        return false;
    }

    public String toString(){
        // string builder to output everything together
        StringBuilder sb = new StringBuilder();

        // add to sb
        sb.append(String.format(" Entries: %d\n", this.numEntries));
        sb.append(String.format("    Hits: %d\n", this.numHits));
        sb.append(String.format("  Misses: %d\n", this.numMisses));

        // iterate through each value in array (entries)
        for (int i = 0; i < this.numEntries; i++) {
            // add to sb
            sb.append(String.format("Name: %s Value: %s\n", this.entries[i].getName(), this.entries[i].getValue()));
        }

        // convert from StringBuilder to String
        return sb.toString();
    }

    private void shiftEntries(int endIdx) {
        // start from the back of the array and then replace at index = index - 1 to shift right
        for (int i = endIdx; i > 0; i--) {
            // replace at index with the value left of the index
            entries[i] = entries[i - 1];
        }
        // clear the first spot
        entries[0] = null;
    }
}
