package ca.sheridancollege.crud.Controllers;

import ca.sheridancollege.crud.Beans.Avenger;
import ca.sheridancollege.crud.databaseaccess.AvengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class HomeController {

    List<Avenger> avengerList = new ArrayList<>();

    private AvengerRepository avengerRepository;

    public HomeController(AvengerRepository avengerRepository) {

        this.avengerRepository = avengerRepository;
    }

    @GetMapping("/")
    public String goHome(Model model) {

        avengerList = avengerRepository.findAll();

        model.addAttribute("avengerList", avengerList);
        return "index";
    }

    @GetMapping("/addPage")
    public String addPage(Model model) {
        model.addAttribute("avenger", new Avenger());
        return "add_avenger";
    }

    @PostMapping("/addAvenger")
    public String addAvenger(@ModelAttribute Avenger avenger) {
        // SAVE THIS AVENGER TO THE DATABASE
        try {
            avengerRepository.save(avenger);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    @GetMapping("/deleteAvenger/{id}")
    public String deleteAvenger(@PathVariable Long id) {
        log.info("Trying to delete avenger from the database with id {}", id);
        //try {
        avengerRepository.deleteById(id);/*
        }catch (Exception e){
            return "failure";
        }*/
        //log.info("Database operation returned the value {}",returnValue);

        return "redirect:/";
    }

    @GetMapping("/editAvenger/{id}")
    public String editAvenger(@PathVariable Long id, Model model) {
        log.info("Trying to edit avenger from the database with id {}", id);
        Optional<Avenger> avenger = avengerRepository.findById(id);
        if (!avenger.isPresent()) {
            log.error("Avenger not found");
            return "redirect:/"; // or u can return an error page
        }
        model.addAttribute("avenger", avenger.get());
        return "edit_avenger";
    }

    @PostMapping("/updateAvenger")
    public String updateAvenger(@ModelAttribute Avenger avenger) {
        log.info("Trying to update avenger {}", avenger);
        avengerRepository.save(avenger);
        //log.info("Avenger {} was updated with the return value {}",avenger,returnValue);
        return "update_success";
    }

}
