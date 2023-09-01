package com.novare.eika.dao.shoppingList;

import com.novare.eika.models.ShoppingListItem;

import java.util.List;

public interface IShoppingListItemDao {
        List<ShoppingListItem> findByUser(long userId);
        ShoppingListItem get(long id);
        ShoppingListItem create(ShoppingListItem listItem, long userId);
        ShoppingListItem update(long id);
}

