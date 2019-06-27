package com.loya.springjpaoracledemo.controller;

import com.loya.springjpaoracledemo.entity.Menu;
import com.loya.springjpaoracledemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Menu> getAllMenus() {
        return this.menuService.getAllMenus();
    }


    @RequestMapping(value = "/addmenu", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu addMenu(@RequestBody Menu menu) {
        return this.menuService.addMenu(menu);
    }


    @RequestMapping(value = "/updatemenu", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu updateMenu(@RequestBody Menu menu) {
        LocalDateTime time = LocalDateTime.now();
        menu.setModificationDate(time);
        return this.menuService.updateMenu(menu);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Menu> getMenu(@PathVariable String id) {
        return this.menuService.getMenuById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllMenus() {
        this.menuService.deleteAllMenus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMenu(@PathVariable int id) {
        this.menuService.deleteMenuById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given menu context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a menu-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
