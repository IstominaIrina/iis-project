package main.api.response;
import main.model.Tag;

import java.util.ArrayList;

public class TagResponse {
    ArrayList<Tag> tags = new ArrayList();

    public ArrayList<Tag> getTags() { return tags; }
    public void setTags(ArrayList<Tag> tags) { this.tags = tags; }
}
