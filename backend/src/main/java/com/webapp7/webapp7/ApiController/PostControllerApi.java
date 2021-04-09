package com.webapp7.webapp7.ApiController;

import com.webapp7.webapp7.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/posts")
public class PostControllerApi {

    @Autowired
    private com.webapp7.webapp7.Service.PostService service;
    @Autowired
    private com.webapp7.webapp7.Service.CourseService courseService;
    @Autowired
    private com.webapp7.webapp7.Service.UserService userService;


    @GetMapping("/")
    public ResponseEntity<Collection<Post>> getPosts() {
        List<Post> posts = service.listPosts();
        if (!posts.isEmpty()) {
            return ResponseEntity.ok(posts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost( @PathVariable long id) {
        Post post = service.findById(id).orElseThrow();
        if (post!=null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

@PostMapping("/")
public ResponseEntity<Post> addPost(@RequestBody Post post)  {
    service.save(post);
    /*if(post.getImageFile()!=null){
        service.updatePostImage(post,post.getImageFile());
    }*/
    return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
}

}
