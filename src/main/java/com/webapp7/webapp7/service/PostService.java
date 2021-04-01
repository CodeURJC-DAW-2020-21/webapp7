package com.webapp7.webapp7.service;

import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.webapp7.webapp7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;

@Service("postService")
public class PostService {

    @Autowired
    @Qualifier("postRepository")
    private PostRepository posts;


    public List<Post> listPosts() {
        return posts.findAll();
    }

    public Post save(Post post) {
        return posts.save(post);
    }

    public void deletePost(long id) {
        posts.deleteById(id);
    }

    public Optional<Post> findById(long id) {
        return posts.findById(id);
    }


    public ArrayList<Post> findPost(Pageable pageable){
        Page<Post> p=posts.findAll(pageable);
        ArrayList<Post> aux=new ArrayList<Post>();
        p.forEach(post->{
                aux.add(post);
        });
        return aux;
    }
}
