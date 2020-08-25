package com.bcaf.ic.SpringTest.Controller;

import com.bcaf.ic.SpringTest.Entity.Item;
import com.bcaf.ic.SpringTest.Util.ItemDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerItem {
    private ItemDao itemDao;

    public ControllerItem(){
        this.itemDao = new ItemDao();
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Item> listItem = itemDao.doSelectAllItems();
        model.addAttribute("listItem", listItem);

        return "index";
    }
}
