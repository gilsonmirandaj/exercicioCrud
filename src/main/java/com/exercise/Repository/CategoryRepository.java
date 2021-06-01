package com.exercise.Repository;
import com.exercise.model.Category;
import com.exercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findAllByDescriptionContainingIgnoreCase(String description);
}