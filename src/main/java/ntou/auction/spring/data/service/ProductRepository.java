package ntou.auction.spring.data.service;

import ntou.auction.spring.data.entity.Product;
import ntou.auction.spring.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,
        JpaSpecificationExecutor<Product> {

    Product findByProductName(String productName);

    Product findById(long id);

    @Query("select p from Product p " +
            "where p.productName like  :productName") //string-like
    List<User> findAllByProductName(@Param("productName") String productName);


}
