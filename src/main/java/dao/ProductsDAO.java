package dao;

import java.util.List;

import entities.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductsDAO {
    
    private EntityManagerFactory emf;

    public ProductsDAO() {
        emf = Persistence.createEntityManagerFactory("JPA_SQL_SERVER");
    }

    public void closeEntityManagerFactory() {
        emf.close();
    }

    public void create(Products product) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            System.out.println("Thêm mới thành công");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Thêm mới thất bại");
        } finally {
            em.close();
        }
    }

    public List<Products> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        List<Products> productList = null;
        try {
            productList = em.createQuery("SELECT p FROM Products p", Products.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return productList;
    }

    public Products getProductById(String productId) {
        EntityManager em = emf.createEntityManager();
        Products product = null;
        try {
            product = em.find(Products.class, productId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return product;
    }

    public void updateProduct(Products product) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
            System.out.println("Cập nhật sản phẩm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Cập nhật sản phẩm thất bại");
        } finally {
            em.close();
        }
    }

    public void deleteProduct(String productId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Products product = em.find(Products.class, productId);
            em.remove(product);
            em.getTransaction().commit();
            System.out.println("Xóa sản phẩm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            System.out.println("Xóa sản phẩm thất bại");
        } finally {
            em.close();
        }
    }
}
