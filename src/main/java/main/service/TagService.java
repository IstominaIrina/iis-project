package main.service;

import main.api.response.TagResponse;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    public TagResponse getTag(){
        TagResponse tagResponse = new TagResponse();
        tagResponse.setTags(tagResponse.getTags());
        return tagResponse;
    }
}
