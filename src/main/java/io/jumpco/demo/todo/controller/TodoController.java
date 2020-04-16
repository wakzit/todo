package io.jumpco.demo.todo.controller;

import io.jumpco.demo.todo.model.EntityNotFoundException;
import io.jumpco.demo.todo.model.Todo;
import io.jumpco.demo.todo.model.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//imports of the example
//end of imports of the example

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo/create")
    public ModelAndView startCreate() {
        ModelAndView result = new ModelAndView("add-edit");
        result.addObject("mode", "add");
        result.addObject("modeTitle", "Create");
        result.addObject("todo", new Todo());
        return result;
    }

    @GetMapping("/todo/edit/{id}")
    public ModelAndView startEdit(@PathVariable("id") Long id) throws EntityNotFoundException {
        Todo item = todoService.find(id);
        ModelAndView result = new ModelAndView("add-edit");
        result.addObject("mode", "update");
        result.addObject("modeTitle", "Update");
        result.addObject("todo", item);
        return result;
    }

    @PostMapping(params = "cancel", path = "/todo/add")
    public String cancelAdd() {
        return home();
    }

    @PostMapping(params = "cancel", path = "/todo/update")
    public String cancelUpdate() {
        return home();
    }

   @PostMapping("/todo/update")
    public ModelAndView update(@Valid @ModelAttribute Todo todo, BindingResult bindingResult, Model model) throws EntityNotFoundException {
        if (bindingResult.hasErrors()) {
            ModelAndView result = new ModelAndView("add-edit");
            result.addObject("mode", "update");
            result.addObject("modeTitle", "Update");
            result.addAllObjects(model.asMap());
            return result;
        }
        todoService.update(todo);
        return new ModelAndView(home());
    }

    @PostMapping("/todo/add")
    public ModelAndView create(@Valid @ModelAttribute Todo todo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ModelAndView result = new ModelAndView("add-edit");
            result.addObject("mode", "add");
            result.addObject("modeTitle", "Create");
            result.addAllObjects(model.asMap());
            return result;
        }
        todoService.create(todo);
        return new ModelAndView(home());
    }

    @GetMapping(value = "/todo/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return home();
    }

    @GetMapping(value = "/todo/complete/{id}")
    public String complete(@PathVariable("id") Long id) throws EntityNotFoundException {
        todoService.complete(id);
        return home();
    }

    private String home() {
        return "redirect:/";
    }
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView result = new ModelAndView("index");
        result.addObject("todos", todoService.list(null));
        return result;
    }
   /* ModelAndView mav = null;
    @ModelAttribute("gradingList")
    public Map<String, String> gradingList(){
        Map<String, String> gradingList = new HashMap<String, String>();
        gradingList.put("inc", "INCOMPLETE");
        gradingList.put("pc", "PARTIAL_COMPLETE");
        gradingList.put("c", "COMPLETE");
        return gradingList;
    }*/
/*example below*/
//ModelAndView mav = null;
    @ModelAttribute("gradingList")
    public List getGrading()
    {
        List gradingList = new ArrayList();

        gradingList.add("INCOMPLETE");
        gradingList.add("PARTIAL-COMPLETE");
        gradingList.add("COMPLETE");
        return gradingList;
    }
                    //DropdownExample
    @RequestMapping("/GradingExample")
    public String dispForm(Map model)
    {
        //DropdownBean db = new DropdownBean();
        Todo db = new Todo();
        model.put("db",db);
        return "add-edit";

    }
                    //processCountry
    @RequestMapping("/processGrading")                      //DropdownBean
    public String processForm(@Valid @ModelAttribute("db") Todo db1,BindingResult result)
    {
        if(result.hasErrors())
        {
            System.out.println("Validation Failed");
            return "add-edit";
        }
        else
        {
            System.out.println("Validated Successfully");
            return "index";
        }
    }

}
