package org.filmt.projetagile.posts.controller;

import java.util.List;

import org.filmt.projetagile.posts.model.Post;
import org.filmt.projetagile.posts.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{groupId}")
    public List<Post> getPosts(@PathVariable String groupId) {
        return postService.getPostsByGroupId(groupId);
    }

    @GetMapping(value = "/{groupId}", params = "categoryId")
    public List<Post> getPostsByCategory(@PathVariable String groupId, @RequestParam String categoryId) {
        return postService.getPostByCategory(groupId, categoryId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Post create(Post post) {
        return postService.create(post);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Post update(Post post) {
        return postService.update(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{postId}")
    public void delete(String post) {
        postService.delete(post);
    }
}