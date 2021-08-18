package repository;

import model.Blog;

import java.util.ArrayList;

public interface IBlogRepo {
        Blog save(Blog blog);
        ArrayList<Blog> findAll();
        void delete(Blog blog);
        void edit(Blog blog);

}
