package com.avaya.springjpaoracledemo.controller;

import com.avaya.springjpaoracledemo.entity.Project;
import com.avaya.springjpaoracledemo.service.ProjectsService;
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
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    ProjectsService projectsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Project> getAllProjectss() {
        return this.projectsService.getAllProjectss();
    }


    @RequestMapping(value = "/addprojects", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Project addProjects(@RequestBody Project projects) {
        return this.projectsService.addProjects(projects);
    }


    @RequestMapping(value = "/updateprojects", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Project updateProjects(@RequestBody Project projects) {
        LocalDateTime time = LocalDateTime.now();
        projects.setModificationDate(time);
        return this.projectsService.updateProjects(projects);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Project> getProjects(@PathVariable String id) {
        return this.projectsService.getProjectsById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllProjectss() {
        this.projectsService.deleteAllProjectss();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProjects(@PathVariable int id) {
        this.projectsService.deleteProjectsById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given projects context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a projects-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiavaya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
