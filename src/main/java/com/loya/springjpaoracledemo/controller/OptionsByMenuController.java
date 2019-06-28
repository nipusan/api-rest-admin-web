package com.loya.springjpaoracledemo.controller;

import com.loya.springjpaoracledemo.entity.OptionsByMenu;
import com.loya.springjpaoracledemo.service.OptionsByMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/optionsByMenu")
public class OptionsByMenuController {
    @Autowired
    OptionsByMenuService optionsByMenuService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<OptionsByMenu> getAllOptionsByMenus() {
        return this.optionsByMenuService.getAllOptionsByMenus();
    }


    @RequestMapping(value = "/addoptionsByMenu", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OptionsByMenu addOptionsByMenu(@RequestBody OptionsByMenu optionsByMenu) {
        return this.optionsByMenuService.addOptionsByMenu(optionsByMenu);
    }


    @RequestMapping(value = "/updateoptionsByMenu", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OptionsByMenu updateOptionsByMenu(@RequestBody OptionsByMenu optionsByMenu) {
        LocalDateTime time = LocalDateTime.now();
        optionsByMenu.setModificationDate(time);
        return this.optionsByMenuService.updateOptionsByMenu(optionsByMenu);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<OptionsByMenu> getOptionsByMenu(@PathVariable String id) {
        return this.optionsByMenuService.getOptionsByMenuById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllOptionsByMenus() {
        this.optionsByMenuService.deleteAllOptionsByMenus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOptionsByMenu(@PathVariable int id) {
        this.optionsByMenuService.deleteOptionsByMenuById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given optionsByMenu context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a optionsByMenu-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
