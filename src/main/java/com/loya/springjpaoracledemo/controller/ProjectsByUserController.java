package com.loya.springjpaoracledemo.controller;

import com.loya.springjpaoracledemo.entity.ProjectsByUser;
import com.loya.springjpaoracledemo.service.ProjectsByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/projectsByUser") 
public class ProjectsByUserController {
    @Autowired
    ProjectsByUserService projectsByUserService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProjectsByUser> getAllProjectsByUsers() {
        return this.projectsByUserService.getAllProjectsByUsers();
    }


    @RequestMapping(value = "/addprojectsByUser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectsByUser addProjectsByUser(@RequestBody ProjectsByUser projectsByUser) {
        return this.projectsByUserService.addProjectsByUser(projectsByUser);
    }


    @RequestMapping(value = "/updateprojectsByUser", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProjectsByUser updateProjectsByUser(@RequestBody ProjectsByUser projectsByUser) {
        LocalDateTime time = LocalDateTime.now();
        projectsByUser.setModificationDate(time);
        return this.projectsByUserService.updateProjectsByUser(projectsByUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ProjectsByUser> getProjectsByUser(@PathVariable String id) {
        return this.projectsByUserService.getProjectsByUserById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllProjectsByUsers() {
        this.projectsByUserService.deleteAllProjectsByUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProjectsByUser(@PathVariable int id) {
        this.projectsByUserService.deleteProjectsByUserById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given projectsByUser context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a projectsByUser-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
