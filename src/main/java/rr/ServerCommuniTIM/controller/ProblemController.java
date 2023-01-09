package rr.ServerCommuniTIM.controller;

import org.springframework.web.bind.annotation.*;
import rr.ServerCommuniTIM.model.Problem;
import rr.ServerCommuniTIM.service.ProblemService;

import java.util.List;

@RestController
@RequestMapping(path="/problems")
public class ProblemController {
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public List<Problem> getAllProblems(){
        return problemService.findAll();
    }
    @PostMapping("/add")
    public void addProblem(@RequestBody Problem problem){
        problemService.addProblem(problem);
    }
}
