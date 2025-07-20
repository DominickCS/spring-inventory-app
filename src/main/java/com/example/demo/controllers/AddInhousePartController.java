package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class AddInhousePartController {
  @Autowired
  private ApplicationContext context;

  @GetMapping("/showFormAddInPart")
  public String showFormAddInhousePart(Model theModel) {
    InhousePart inhousepart = new InhousePart();
    theModel.addAttribute("inhousepart", inhousepart);
    return "InhousePartForm";
  }

  @PostMapping("/showFormAddInPart")
  public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult,
      Model theModel) {
    theModel.addAttribute("inhousepart", part);
    if (theBindingResult.hasErrors()) {
      return "InhousePartForm";
    }
    if (!part.isValidInv()) {
      theBindingResult.rejectValue("inv", null, "Invalid inventory entered.");
      if (part.getInv() < part.getMinInv()) {
        theBindingResult.rejectValue("minInv", null,
            "The entered inventory is lower than the minimum inventory allowed. (" + part.getMinInv() + ")");
      } else if (part.getInv() > part.getMaxInv()) {
        theBindingResult.rejectValue("maxInv", null,
            "The entered inventory is higher than the maximum inventory allowed. (" + part.getMaxInv() + ")");
      }
      return "InhousePartForm";
    } else {
      InhousePartService repo = context.getBean(InhousePartServiceImpl.class);
      InhousePart ip = repo.findById((int) part.getId());
      if (ip != null)
        part.setProducts(ip.getProducts());
      repo.save(part);

      return "confirmationaddpart";
    }
  }

}
