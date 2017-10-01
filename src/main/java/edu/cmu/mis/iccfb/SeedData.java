package edu.cmu.mis.iccfb;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.service.AuthorService;

@Configuration
public class SeedData {

    @Autowired
    private AuthorService authorService;
    
    //private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    @Bean
    public SeedData getBean() throws SQLException {
    	
        
        Author a1 = new Author("Douglas Adams", 1);
        Author a2 = new Author("Gautama Buddha", 2);
        Author a3 = new Author("Albert Einstein", 3);
        
        authorService.save(a1);
        authorService.save(a2);
        authorService.save(a3);
        
//        log.info("Quoates found with findAll():");
//        log.info("-------------------------------");
//        for (Quote m : quoteService.findAll()) {
//            log.info(m.toString());
//        }
        return new SeedData();
    }
}