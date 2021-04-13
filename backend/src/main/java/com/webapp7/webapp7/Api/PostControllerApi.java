package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.Service.ImageService;
import com.webapp7.webapp7.Service.PostService;
import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.Post;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
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

    interface PostBasic extends Post.Basic {}
    private static final String POSTS_FOLDER = "posts";

    @Autowired
    private PostService postService;
    @Autowired
    private ImageService imgService;

/*

    private final UserService userService;
    private final PostService postService;
    private final ModelMapper modelMapper;


    public  PostControllerApi(UserService userService, PostService postService, ModelMapper modelMapper) {
        this.userService = userService;
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

 */

    @JsonView(PostBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Post>> getPosts() {
        List<Post> posts = postService.listPosts();
        if (!posts.isEmpty()) {
            return ResponseEntity.ok(posts);
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

    @PostMapping("/{id}/image")
    public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
            throws IOException {

        Post post = postService.findById(id).orElseThrow(null);

        if (post != null) {

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

    @GetMapping("/{id}/image")
    public ResponseEntity<Object> downloadImage(@PathVariable long id) throws MalformedURLException {

        return this.imgService.createResponseFromImage(POSTS_FOLDER, id);
    }
//INTENTO POSTMAPPING SIN IMAGEN (FUNCIONA)
    @PostMapping("/")
    public ResponseEntity<Post> addPost(@RequestBody Post post) throws IOException {
        postService.save(post);
        return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
    }



/*
//INTENTO POSTMAPPING CON IMAGEN1
    @JsonView(PostBasic.class)
    @GetMapping("/{id}")
    public ResponseEntity<Post> createPost(@RequestParam String title,
                                                    @RequestParam String description,
                                                    @RequestParam MultipartFile imageFile) throws IOException {
            Post post = new Post();
            post.setTitle(title);
            post.setDescription(description);
            //post.setImageFile((Blob)imageFile);

            if (!imageFile.isEmpty()) {
            post.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            postService.save(post);
            return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }


     */
/*
//INTENTO POSTMAPPING CON IMAGEN2
    @JsonView(PostBasic.class)
    @PostMapping("/")
    public ResponseEntity<Post> addPost(@RequestBody Post post,
                                        @RequestParam MultipartFile imageFile) throws IOException {

        downloadImage(post.getId());
        if (!imageFile.isEmpty()) {
            post.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
            postService.save(post);
            return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }



 */





/*INTENTO POSTMAPPING CON PostDTO
    @PostMapping("/")
    public ResponseEntity<Post> addPost(@RequestBody PostDTO entryDTO, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        User user = userService.findByName(principal.getName());
        Post post = modelMapper.map(entryDTO, Post.class);
        postService.save(post);
        return ResponseEntity.created(fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri()).body(post);
    }

 */


}
