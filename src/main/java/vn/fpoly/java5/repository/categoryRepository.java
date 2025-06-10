package vn.fpoly.java5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fpoly.java5.entity.Product;

@Repository
public interface categoryRepository extends JpaRepository<Product,Long> {
}
