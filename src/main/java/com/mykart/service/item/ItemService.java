package com.mykart.service.item;

import com.mykart.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public ItemDTO getItem(int itemId);
    public ItemDTO updateItem(int itemId, int quantity);
}