package main.api.response;

import main.model.Post;

import java.util.ArrayList;

public class PostResponse {
    private int count;

    ArrayList <Post> posts = new ArrayList();


    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public ArrayList<Post> getPosts() { return posts; }
    public void setPosts(ArrayList<Post> posts) { this.posts = posts; }
}
