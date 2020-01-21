//package com.services.itemservice.controller;
//
//import com.services.itemservice.exceptions.ResourceAlreadyPresentException;
//import com.services.itemservice.exceptions.ResourceNotFoundException;
//import com.services.itemservice.model.ItemModel;
//import com.services.itemservice.model.dto.ItemDTO;
//import com.services.itemservice.service.ItemService;
//import com.services.itemservice.controller.ItemController;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.BeanUtils;
//
//import static org.junit.Assert.assertEquals;
//
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ItemControllerTest {
//  @InjectMocks
//  ItemController itemController;
//
//  @Mock
//  ItemService itemService;
//
//
//  @Test
//  public void getAllItems() throws Exception {
//    List<ItemModel> list = new ArrayList<ItemModel>();
//    ItemModel itemModel = mock(ItemModel.class);
//    when(itemModel.getItemId()).thenReturn(101);
//    list.add(itemModel);
//    when(itemService.getAllItems()).thenReturn(list);
//    itemController.getAllItems();
//    assertEquals(101,itemModel.getItemId());
//    verify(itemService,times(1)).getAllItems();
//  }
//  @Test
//  public void getItemById() throws ResourceNotFoundException {
//    ItemModel itemModel = mock(ItemModel.class);
//    when(itemModel.getItemId()).thenReturn(101);
//    when(itemService.getItemById(101)).thenReturn(java.util.Optional.ofNullable(itemModel));
//    itemController.getItemById(101);
//    assertEquals(101,itemModel.getItemId());
//    verify(itemService,times(1)).getItemById(101);
//  }
//
////  @Test
////  public void createItem() throws ResourceAlreadyPresentException, URISyntaxException {
////    ItemModel itemModel=mock(ItemModel.class);
////    ItemDTO itemDTO=mock(ItemDTO.class);
////    when(itemModel.getItemId()).thenReturn(101);
////    when(itemService.addItem(itemModel)).thenReturn(itemModel);
////    itemController.createItem(itemDTO);
////    assertEquals(101,itemModel.getItemId());
////    verify(itemService,times(1)).addItem(itemModel);
////  }
////
////  @Test
//// public void updateItem() {
////
////  }
////
////  @Test
////public  void deleteItem() {
//
//  }
//
//}