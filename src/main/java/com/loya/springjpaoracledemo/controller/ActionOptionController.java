package com.loya.springjpaoracledemo.controller;

import com.loya.springjpaoracledemo.entity.ActionOption;
import com.loya.springjpaoracledemo.service.ActionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/actionOption")
public class ActionOptionController {
    @Autowired
    ActionOptionService actionOptionService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ActionOption> getAllActionOptions() {
        return this.actionOptionService.getAllActionOptions();
    }


    @RequestMapping(value = "/addactionOption", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionOption addActionOption(@RequestBody ActionOption actionOption) {
        return this.actionOptionService.addActionOption(actionOption);
    }


    @RequestMapping(value = "/updateactionOption", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionOption updateActionOption(@RequestBody ActionOption actionOption) {
        LocalDateTime time = LocalDateTime.now();
        actionOption.setModificationDate(time);
        return this.actionOptionService.updateActionOption(actionOption);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ActionOption> getActionOption(@PathVariable String id) {
        return this.actionOptionService.getActionOptionById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllActionOptions() {
        this.actionOptionService.deleteAllActionOptions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteActionOption(@PathVariable int id) {
        this.actionOptionService.deleteActionOptionById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given actionOption context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a actionOption-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
