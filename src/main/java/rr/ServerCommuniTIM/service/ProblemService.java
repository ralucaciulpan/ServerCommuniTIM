package rr.ServerCommuniTIM.service;

import org.springframework.stereotype.Service;
import rr.ServerCommuniTIM.model.Problem;
import rr.ServerCommuniTIM.repository.ProblemRepository;
import rr.ServerCommuniTIM.repository.UserRepository;

import java.util.List;

@Service
public class ProblemService {
    private ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository){
        this.problemRepository = problemRepository;
    }
    public Problem addProblem(Problem problem){
        if(problem.getCategory()!=null && problem.getSubcategory()!=null && (problem.getLatitude()!=0) && (problem.getLongitude()!=0)){
           return problemRepository.save(problem);
        }
        else return null;
    }

    public List<Problem> findAll(){
        return problemRepository.findAll();
    }
}
