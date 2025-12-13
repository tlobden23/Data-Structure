/* *****************************************
 *  @Author : Ali Azhari   
 *  @Created On : Sun November 30 2025
 *  @File : Relationship.java
 *  @Description: 
 *******************************************/

public class Relationship {
    
    public int u;
    public int v;
    
    public Relationship(int u, int v) {
        this.u = u;
        this.v = v;
    }
    
    public boolean equals(Object o) {
        return u == ((Relationship)o).u && v == ((Relationship)o).v;
    }
    
    public String toString() {
        return "(" + u + " -> " + v + ")";
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    public int compareTo(Relationship e) {
       // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");

       // Be careful here: It's a directed graph

    }
    
    public boolean contains(int v) {
        return u == v || this.v == v;
    }
    
    public boolean contains(Relationship e) {
        return contains(e.u) && contains(e.v);
    }
    
    public boolean isSelfLoop() {
        return u == v;
    }
    
    public boolean isAdjacent(Relationship e) {
        return u == e.u || u == e.v || v == e.u || v == e.v;
    }
    
    public boolean isAdjacent(int vertex) {
        return u == vertex || v == vertex;
    }
    
    public int other(int vertex) {
        if (vertex == u) {
            return v;
        } else if (vertex == v) {
            return u;
        } else {
            throw new IllegalArgumentException("Illegal endpoint");
        }
    }
}
