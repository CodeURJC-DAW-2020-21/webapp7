package com.webapp7.webapp7.Service;

import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.model.User;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.webapp7.webapp7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
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
    public Page<Post> listPostsPageable (Pageable pageable){return posts.findAll(pageable);};

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
        p.forEach(post->{ aux.add(post); });
        return aux;
    }

    public void updatePostImage(Post post, MultipartFile image) throws IOException, SQLException {
        if(!image.isEmpty()){
            post.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
        } else {
            //Post post = findById(post.getId()).orElseThrow();
            if (post.getImageFile().length() == 0){
                post.setImageFile(BlobProxy.generateProxy(post.getImageFile().getBinaryStream(), post.getImageFile().length()));
            }
        }
    }
}
