package dev.omuzalevska.toyfactory.model;

public class BadToy extends Toy  {
    private String contents;

    public BadToy(String id, String name, String category, String contents) {
            setId(id);
            setName(name);
            setCategory(category);
            this.contents = contents;
        }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    
}
