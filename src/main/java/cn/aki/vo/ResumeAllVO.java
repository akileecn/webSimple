package cn.aki.vo;

import cn.aki.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author llh
 * Created on 2018/02/07.
 */
@Data
public class ResumeAllVO implements Serializable {
    private Resume resume;
    private List<ResumeAward> awardList;
    private List<ResumeEducation> educationList;
    private List<ResumeFamily> familyList;
    private List<ResumeStudentCadre> studentCadreList;
    private List<ResumeWork> workList;
    private List<ResumeComputer> computerList;
    private List<ResumeForeignLanguage> foreignLanguageList;
    private List<ResumePractice> practiceList;
    private List<ResumeTrain> trainList;
}
