package com.tts.TechTalentBlog.BlogPost;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BlogPostController {
	
    @Autowired
    private BlogPostRepository blogPostRepository;
    private static List <BlogPost> posts = new ArrayList<>();
	
    @GetMapping(value = "blogpost")
    public String index(BlogPost blogPost, Model model) {
    	model.addAttribute("posts", posts);
    	return "blogpost/index";
    }
    @GetMapping(value = "/blogpost/new")
    public String newBlog (BlogPost blogPost) {
        return "blogpost/new";
		
    }
  
    
    private BlogPost blogPost;
    @PostMapping(value = "/blogpost/new")
    public String create(BlogPost blogPost, Model model) {
    	blogPostRepository.save(blogPost);
    	posts.add(blogPost);
    	model.addAttribute("title", blogPost.getTitle());
    	model.addAttribute("author", blogPost.getAuthor());
    	model.addAttribute("blogEntry", blogPost.getBlogEntry());
    	return "blogpost/result";
    	}
	public BlogPost getBlogpost() {
		return blogPost;
	}
	public void setBlogpost(BlogPost blogpost) {
		this.blogPost = blogpost;
	}
    
	
	
    }
	


