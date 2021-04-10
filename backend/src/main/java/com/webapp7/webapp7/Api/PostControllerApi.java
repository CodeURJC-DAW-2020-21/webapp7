package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.Post;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/posts")
public class PostControllerApi {

    interface PostBasic extends Post.Basic {
    }

    @Autowired
    private com.webapp7.webapp7.Service.PostService service;

    @JsonView(PostBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Post>> getPosts() {
        List<Post> posts = service.listPosts();
        if (!posts.isEmpty()) {
            return ResponseEntity.ok(posts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(PostBasic.class)
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable long id) {
        Post post = service.findById(id).orElseThrow();
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/*INTENTO POSTMAPPING CON IMAGEN1
    @JsonView(PostBasic.class)
    @GetMapping("/{id}")
    public ResponseEntity<Category> createCategory(@RequestParam String title,
                                                    @RequestParam String description,
                                                    @RequestParam MultipartFile imageFile) throws IOException {

            if (!imageFile.isEmpty()) {
            post.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            service.save(post);
            return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }
 */

/*INTENTO POSTMAPPING CON IMAGEN2
    @JsonView(PostBasic.class)
    @PostMapping("/")
    public ResponseEntity<Post> addPost(@RequestBody Post post,
                                        @RequestParam MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            post.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            service.save(post);
            return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
 */


    @PostMapping("/")
    public ResponseEntity<Post> addPost(@RequestBody Post post) throws IOException {

        if (post.getImageFile() != null) {
            MultipartFile imageFile = (MultipartFile) post.getImageFile();
            post.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
        }
        service.save(post);
        return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
    }


}
