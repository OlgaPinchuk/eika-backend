package com.novare.eika.dao.shoppingList;

import com.novare.eika.models.ShoppingListItem;
import com.novare.eika.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class ShoppingListItemDao implements IShoppingListItemDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ShoppingListItem> findByUser(long userId) {
        String jpql = "SELECT s FROM ShoppingListItem s LEFT JOIN FETCH s.image WHERE s.user.id = :userId";
        TypedQuery<ShoppingListItem> query = entityManager.createQuery(jpql, ShoppingListItem.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public ShoppingListItem get(long id) {
        return entityManager.find(ShoppingListItem.class, id);
    }

    @Override
    public ShoppingListItem create(ShoppingListItem listItem, long userId) {
        User user = entityManager.find(User.class, userId);
        listItem.setUser(user);
        entityManager.persist(listItem);
        return listItem;
    }

    @Override
    public ShoppingListItem update(long id) {
        ShoppingListItem currentItem = get(id);
        if(currentItem == null) {
            return null;
        }
        currentItem.setCompleted(true);

        entityManager.merge(currentItem);
        return currentItem;
    }
}
