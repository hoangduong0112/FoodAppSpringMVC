/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hd.controllers;

import com.hd.pojo.Category;
import com.hd.pojo.Menu;
import com.hd.pojo.MenuItems;
import com.hd.pojo.Store;
import com.hd.service.CategoryService;
import com.hd.service.MenuItemsService;
import com.hd.service.MenuService;
import com.hd.service.StoreService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Duong Hoang
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuItemsService menuItemsService;

    @ModelAttribute
    public void commonAttribute(Model model) {
        List<Category> p = this.categoryService.getCategories();
        model.addAttribute("categories", p);
    }

    @RequestMapping(path = {"/", "/store"})
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Store> s = this.storeService.getStores(params);

        model.addAttribute("stores", s);
        return "index";
    }

    @RequestMapping(path = "/store/{storeId}")
    public String details(Model model, @PathVariable(value = "storeId") int id) {
        model.addAttribute("store", this.storeService.getStoreById(id));
        String title = this.storeService.getName(id);
        model.addAttribute("title", title);
        List<Menu> menus = this.menuService.getMenuByStoreId(id);
        List<List<MenuItems>> menuItemsList = new ArrayList<>();
        for (Menu menu : menus) {
            menuItemsList.add(new ArrayList<>(menu.getMenuItemsSet()));
        }
        model.addAttribute("menus", menus);
        model.addAttribute("menuItemsList", menuItemsList);
        return "store-menu";
    }
    
    @RequestMapping(path = "/login")
    public String login(){
        return "login";
    }
    
}