package edu.cmu.mis.iccfb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.service.AuthorService;

@RestController
public class AuthorController {    
    @Autowired
    private AuthorService authorService;    
    
    @RequestMapping("/authorId")
    public String getAuthorName(@RequestParam(value="authorId") long authorId) {
        Author a = authorService.findOne(authorId);
        return a.getName();
    }
    @RequestMapping("/authorName")
    public Long getAuthorId(@RequestParam(value="authorName") String authorName) {
        Author a = authorService.findByName(authorName);
        return a.getId();
    }
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public void saveQuote(@RequestBody Author author) {
        System.out.println("Saving author");
        authorService.save(author);
    }
}