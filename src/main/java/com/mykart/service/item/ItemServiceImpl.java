package com.mykart.service.item;

import com.mykart.dto.ItemDTO;
import com.mykart.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate template;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ItemService itemService;
    @Override
    public ItemDTO getItem(int itemId) {

        ResponseEntity<ItemDTO> result=template.getForEntity("http://itemservice:7070/v1/warehouse/"+itemId,ItemDTO.class);
        ItemDTO item=result.getBody();
        System.out.println(item.toString());
        return item;
    }

    @Override
    public ItemDTO updateItem(int itemId, int quantity) {
        ResponseEntity<ItemDTO> result=template.getForEntity("http://itemservice:7070/v1/warehouse/"+itemId,ItemDTO.class);
        ItemDTO item=result.getBody();
        System.out.println(item.toString());
        item.setInStock(item.getInStock()-quantity);
       template.put("http://itemservice:7070/v1/warehouse",item);
        return item;
    }
}
