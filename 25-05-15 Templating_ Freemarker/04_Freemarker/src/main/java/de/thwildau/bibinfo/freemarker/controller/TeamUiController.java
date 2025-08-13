package de.thwildau.bibinfo.freemarker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.thwildau.bibinfo.freemarker.api.TeamDto;
import de.thwildau.bibinfo.freemarker.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamUiController {

    //Constructor lt Aufgabe

    private final TeamService teamService;

    @Autowired
    public TeamUiController(TeamService teamService) {
        this.teamService = teamService;
    }

    //Methode lt Aufgabe
    @GetMapping("")
    public ModelAndView listTeams() {
        ModelAndView mav = new ModelAndView("team/teamList"); //viewName == Pfad zum html Template
        mav.addObject("teamList", teamService.getTeams());
        return mav;
    }


    //Zusatz 8
    @GetMapping("/add")
    public ModelAndView addTeam() {
        ModelAndView mav = new ModelAndView("team/addTeam");
        mav.addObject("team", new TeamDto());
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView addTeam(TeamDto team) {
        ModelAndView mav = new ModelAndView("team/addTeam");
        try {
            TeamDto newTeam = this.teamService.addTeam(team);
            mav.addObject("successMessage", "Team erfolgreich angelegt");
        } catch (Exception e) {
            mav.addObject("errorMessage", "Fehler beim erstellen: " + e.getMessage());
        }
        return mav;
    }

    //Zusatz 9
    @GetMapping("/add/{id}")
    public ModelAndView addTeam(@PathVariable("id") Integer teamId) {
        ModelAndView mav = new ModelAndView("team/addTeam");
        mav.addObject("team", this.teamService.getTeam(teamId).orElse(null));
        return mav;
    }

}
