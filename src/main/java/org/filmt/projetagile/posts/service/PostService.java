package org.filmt.projetagile.posts.service;

import java.util.List;

import org.filmt.projetagile.posts.model.Post;

public interface PostService {

    Post getPostById(String postId);

    List<Post> getPostsByGroupId(String groupId);

    List<Post> getPostByCategory(String groupId, String categoryId);

    List<Post> getPostsBySchoolIdAndTitle(String schoolId, String title);

    List<Post> getPostsByGroupIdAndTitle(String groupId, String title);

    List<Post> getPostsByUserId(String userId);

    Post create(Post post);

    Post update(Post post);

    void delete(String id);
}
