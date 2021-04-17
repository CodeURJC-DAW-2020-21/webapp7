package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.Service.ImageService;
import com.webapp7.webapp7.Service.PostService;
import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.Post;
import io.swagger.v3.oas.annotations.Parameter;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.sql.Blob;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/posts")
public class PostControllerApi {

    private static final int DEFAULT_SIZE_PAGE = 3;

    interface PostBasic extends Post.Basic {}
    private static final String POSTS_FOLDER = "posts";
    Pageable page = null;

    @Autowired
    private PostService postService;

    @Autowired
    private ImageService imgService;

    @JsonView(PostBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Post>> getEntries(@Parameter(description = "number of the page you want to get") @RequestParam(defaultValue = "0") int Page){
        page = PageRequest.of(Page, DEFAULT_SIZE_PAGE, Sort.by("id").ascending());
        Page<Post> entries = postService.listPostsPageable(page);
        if (!entries.isEmpty()){
            return ResponseEntity.ok(entries.getContent());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(PostBasic.class)
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable long id) {
        Post post = postService.findById(id).orElseThrow();
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @JsonView(PostBasic.class)
    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {

        Post post = postService.findById(id).orElseThrow(null);

        if (post != null){

            URI location = fromCurrentRequest().build().toUri();

            if (!imageFile.isEmpty()) {
                post.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
                post.setImage(true);
            }
            postService.save(post);

            imgService.saveImage(POSTS_FOLDER, post.getId(), imageFile);

            return ResponseEntity.created(location).build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @JsonView(PostBasic.class)
    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {
        return this.imgService.createResponseFromImage(POSTS_FOLDER, id);
    }

    @PostMapping("/")
    public ResponseEntity<Post> addPost(@RequestBody Post post) throws IOException {
        postService.save(post);
        return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
    }



}
