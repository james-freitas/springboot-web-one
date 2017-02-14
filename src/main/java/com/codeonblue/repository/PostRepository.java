package com.codeonblue.repository;

import com.codeonblue.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
    Post findFirstByOrderByPostedOnDesc();

    List<Post> findAllByOrderByPostedOnDesc();

    Post findBySlug(String slug);

    // AUTHOR ======================================================================================================

    List<Post> findAllByAuthorFirstName(String first);

    List<Post> findAllByAuthorFirstNameIgnoreCase(String first);

    List<Post> findAllByAuthorFirstNameIgnoreCaseOrderByPostedOnDesc(String first);

    List<Post> findAllByAuthorFirstNameAndAuthorLastName(String first,String last);

    // KEYWORDS ====================================================================================================

    List<Post> findAllByKeywords(String keyword);

    // where keyword LIKE '%KEYWORD%'
    List<Post> findAllByKeywordsLikeIgnoreCase(String keyword);

    // ACTIVE ======================================================================================================

    List<Post> findAllByActiveTrue();

    List<Post> findAllByActiveFalse();

    // AUTHOR & KEYWORDS ===========================================================================================

   List<Post> findAllByAuthorFirstNameAndKeywords(String first, String keywords);

   List<Post> findAllByAuthorFirstNameAndKeywordsOrderByPostedOnDesc(String first, String keywords);


    // QUERY =======================================================================================================

    @Query("select p from Post p where p.slug = ?1")
    Post findPostBySlug(String slug);

    @Query("select p from Post p where p.slug = :slug")
    Post findPostBySlugNamedParam( @Param("slug") String slug);

    @Query( value="SELECT * FROM Post where slug = :slug", nativeQuery = true )
    Post findPostBySlugNative( @Param("slug") String slug);
}


