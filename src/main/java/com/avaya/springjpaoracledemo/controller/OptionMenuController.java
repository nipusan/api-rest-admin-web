package com.avaya.springjpaoracledemo.controller;

import com.avaya.springjpaoracledemo.entity.OptionMenu;
import com.avaya.springjpaoracledemo.service.OptionMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "*",  methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/optionMenu")
public class OptionMenuController {
    @Autowired
    OptionMenuService optionMenuService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<OptionMenu> getAllOptionMenus() {
        return this.optionMenuService.getAllOptionMenus();
    }


    @RequestMapping(value = "/addoptionMenu", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OptionMenu addOptionMenu(@RequestBody OptionMenu optionMenu) {
        return this.optionMenuService.addOptionMenu(optionMenu);
    }


    @RequestMapping(value = "/updateoptionMenu", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OptionMenu updateOptionMenu(@RequestBody OptionMenu optionMenu) {
        LocalDateTime time = LocalDateTime.now();
        optionMenu.setModificationDate(time);
        return this.optionMenuService.updateOptionMenu(optionMenu);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<OptionMenu> getOptionMenu(@PathVariable String id) {
        return this.optionMenuService.getOptionMenuById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllOptionMenus() {
        this.optionMenuService.deleteAllOptionMenus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOptionMenu(@PathVariable int id) {
        this.optionMenuService.deleteOptionMenuById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given optionMenu context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a optionMenu-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiavaya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
