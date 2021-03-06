package edu.cmu.mis.iccfb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
    		@PathVariable String applicationName) {
    	return this.discoveryClient.getInstances(applicationName);
    }
    @RequestMapping("/authorId")
    public Author getAuthorName(@RequestParam(value="authorId") long authorId) {
        Author a = authorService.findOne(authorId);
        return a;
    }
    @RequestMapping("/authorName")
    public Author getAuthorId(@RequestParam(value="authorName") String authorName) {
        Author a = authorService.findByName(authorName);
        return a;
    }
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Long saveQuote(@RequestBody Author author) {
        System.out.println("Saving author");
        authorService.save(author);
        return getAuthorId(author.getName()).getId();
    }
}