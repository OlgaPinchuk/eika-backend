package com.novare.eika.controllers;

import com.novare.eika.models.Image;
import com.novare.eika.models.ShoppingListItem;
import com.novare.eika.models.ShoppingListItemRequest;
import com.novare.eika.services.ShoppingListItemService;
import com.novare.eika.services.UserService;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("shopping-list")
public class ShoppingListItemController {

    @Autowired
    ShoppingListItemService listService;

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public List<ShoppingListItem> getShoppingListByUserId(@PathVariable long userId) {
        return listService.getShoppingList(userId);
    }

    @PostMapping("/{userId}")
    public ShoppingListItem create(@ModelAttribute ShoppingListItemRequest request, @PathVariable long userId) throws SQLException, IOException {
        MultipartFile imageFile = request.getImage();
        byte[] bytes = imageFile.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        Image image = new Image();
        image.setImage(blob);

        ShoppingListItem listItem = new ShoppingListItem();
        listItem.setUser(userService.get(userId));

        listItem.setTitle(request.getTitle());
        listItem.setPrice(request.getPrice());
        listItem.setImage(image);
        listItem.setCompleted(false);

        return listService.create(listItem, userId);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<?> updateShoppingListItem(@PathVariable long itemId) {
        ShoppingListItem updatedItem = listService.update(itemId);

        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        }
    }


}
