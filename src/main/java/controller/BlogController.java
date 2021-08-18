package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogService;

import java.util.ArrayList;

@Controller
public class BlogController {
    ArrayList<Blog> list = new ArrayList<>();

    @Autowired
    IBlogService iBlogService;

    @RequestMapping("/blog")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        list = iBlogService.findAll();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return new ModelAndView("redirect:/blog");
    }
    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog",list.get(index));
        return modelAndView;
    }
    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Blog blog){
        iBlogService.edit(blog);
        return new ModelAndView("redirect:/blog");
    }
    @GetMapping("/delete/{index}")
    public ModelAndView delete(@PathVariable int index){
        iBlogService.delete(list.get(index));
        return new ModelAndView("redirect:/blog");
    }
    @GetMapping("/read/{index}")
    public ModelAndView read(@PathVariable int index, Model model){
        ModelAndView modelAndView = new ModelAndView("/view");
      model.addAttribute("list", list.get(index) );
      return modelAndView;
    }

}
