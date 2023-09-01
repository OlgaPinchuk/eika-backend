package com.novare.eika.services;

import com.novare.eika.dao.shoppingList.IShoppingListItemDao;
import com.novare.eika.models.ShoppingListItem;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListItemService {
    @Autowired
    IShoppingListItemDao iShoppingListItemDao;

    @Autowired
    private ImageService imageService;

    public List<ShoppingListItem> getShoppingList(long userId){
        return iShoppingListItemDao.findByUser(userId);
    }
    public ShoppingListItem get(long id){
        ShoppingListItem item = iShoppingListItemDao.get(id);
        if (item == null) {
            throw new EntityNotFoundException("Shopping list item with ID " + id + " not found");
        }
        return item;
    }

    public ShoppingListItem create(ShoppingListItem listItem, long userId) {

        return iShoppingListItemDao.create(listItem, userId);
    }

    public ShoppingListItem update(long id) {
        return iShoppingListItemDao.update(id);
    }
}
