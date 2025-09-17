// Datei Refractored aus Zip-Datei lt. Aufgabe 10
package de.thwildau.bibinfo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.thwildau.bibinfo.jpa.api.TeamDto;
import de.thwildau.bibinfo.jpa.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamUiController {

    private static final String LIST_TEAMS_VIEW = "team/listTeams";
    private static final String CREATE_TEAM_VIEW = "team/createTeam";

    private final TeamService teamService;

    @Autowired
    public TeamUiController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping({"/", ""})
    public ModelAndView listTeams() {
        ModelAndView modelAndView = new ModelAndView(LIST_TEAMS_VIEW);
        modelAndView.addObject("teamList", this.teamService.getTeams());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createTeam() {
        return new ModelAndView(CREATE_TEAM_VIEW);
    }

    @GetMapping("/create/{id}")
    public ModelAndView createTeam(@PathVariable("id") Integer teamId) {
        ModelAndView modelAndView = createTeam();
        modelAndView.addObject("teamObj", this.teamService.getTeam(teamId).orElse(null));

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createTeam(TeamDto teamDto) {
        ModelAndView modelAndView = createTeam();
        TeamDto dto = this.teamService.addTeam(teamDto);

        if (dto.getId() != null) {
            modelAndView.addObject("success", "Der Eintrag für das Team wurde erfolgreich gespeichert.");
        } else {
            modelAndView.addObject("error", "Es ist ein Fehler bei der Speicherung aufgetreten.");
        }

        return modelAndView;
    }

}
