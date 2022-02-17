package main.service;


import main.api.response.PostResponse;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    public PostResponse getPost(){
        PostResponse postResponse = new PostResponse();
        postResponse.setCount(0);
        postResponse.setPosts(postResponse.getPosts());
        return postResponse;
    }

}
