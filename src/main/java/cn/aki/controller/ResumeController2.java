package cn.aki.controller;

import cn.aki.entity.*;
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.form.validator.BeginAndEndDate;
import cn.aki.service.ResumeService;
import cn.aki.service.ResumeSubService;
import cn.aki.utils.Constants;
import cn.aki.utils.Response;
import cn.aki.utils.UserUtils;
import cn.aki.vo.ResumeAllVO;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 简历
 *
 * @author aki
 * 2016年4月29日 上午9:48:40
 */
@RestController
@RequestMapping("/resume2")
public class ResumeController2 extends BaseController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ResumeSubService resumeSubService;

    /**
     * 上传头像
     */
    @PostMapping("/photo/upload")
    public Response<Void> upload(@RequestParam("file") MultipartFile file, Resume resume) {
        Response<Void> response = Response.fail("上传失败");
        if (!file.isEmpty()) {
            //上传校验
            if (file.getSize() > 50 * 1024) {
                response.setMessage("上传文件必须小于50kb");
            } else if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
                response.setMessage("只能上传jpg、png格式图片");
            } else {
                try {
                    resume.setPhoto(file.getBytes());
                    resumeService.updatePhoto(resume);
                    response.setSuccess(true);
                    response.setMessage("上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    @GetMapping("/photo/show")
    public void getPhoto(Resume resume, HttpServletResponse response) {
        resume = resumeService.getPhoto(resume);
        if (resume != null && resume.getPhoto() != null) {
            try (InputStream is = new ByteArrayInputStream(resume.getPhoto())) {
                FileCopyUtils.copy(is, response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/list")
    public Response<List<Resume>> list(String resumeType) {
        Resume condition = new Resume();
        condition.setRecruitType(resumeType);
        condition.setUserId(UserUtils.getUserId());
        return Response.success(resumeService.getList(condition));
    }

    @PostMapping("/save/base")
    public Response<Void> saveBase(@Valid Resume form, BindingResult result) {
        Response<Void> response = handleFormError(result);
        resumeService.validate(form, response);
        if (response.getSuccess()) {
            resumeService.update(form);
        }
        return response;
    }

    @GetMapping("/detail/all")
    public Response<ResumeAllVO> handleDetail(Resume resume) {
        return Response.success(resumeService.getAll(resume));
    }

    @PostMapping("/submit")
    public Response handleSubmit(Resume resume) {
        Response response = new Response();
        String message = resumeService.submit(resume);
        response.setMessage(message);
        response.setSuccess(Strings.isNullOrEmpty(message));
        return response;
    }

    /* begin从属信息 */
    @PostMapping("/save/award")
    public Response<Integer> saveAward(@Valid ResumeAward form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/award")
    public Response deleteAward(ResumeAward bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/computer")
    public Response<Integer> saveComputer(@Valid ResumeComputer form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/computer")
    public Response deleteComputer(ResumeComputer bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/education")
    public Response<Integer> saveEducation(String recruitType, @Valid ResumeEducation form, BindingResult result) {
        //@Valid放其他参数会报错
        return saveSub(form, recruitType, result);
    }

    @PostMapping("/delete/education")
    public Response deleteEducation(ResumeEducation bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/family")
    public Response<Integer> saveFamily(@Valid ResumeFamily form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/family")
    public Response deleteFamily(ResumeFamily bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/foreignLanguage")
    public Response<Integer> saveForeignLanguage(@Valid ResumeForeignLanguage form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/foreignLanguage")
    public Response deleteForeignLanguage(ResumeForeignLanguage bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/studentCadre")
    public Response<Integer> saveStudentCadre(@Valid ResumeStudentCadre form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/studentCadre")
    public Response deleteStudentCadre(ResumeStudentCadre bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/work")
    public Response<Integer> saveWork(@Valid ResumeWork form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/work")
    public Response deleteWork(ResumeWork bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/practice")
    public Response<Integer> savePractice(@Valid ResumePractice form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/practice")
    public Response deletePractice(ResumePractice bean) {
        return deleteSub(bean);
    }

    @PostMapping("/save/train")
    public Response<Integer> saveTrain(@Valid ResumeTrain form, BindingResult result) {
        return saveSub(form, result);
    }

    @PostMapping("/delete/train")
    public Response deleteTrain(ResumeTrain bean) {
        return deleteSub(bean);
    }

    /**
     * 公共修改方法
     */
    private Response<Integer> saveSub(ResumeSubEntity sub, String recruitType, BindingResult result) {
        Response<Integer> response = handleFormError(new Response<>(), result);
        if (!response.getSuccess()) {
            return response;
        }
        if (recruitType != null) {
            if (sub instanceof ResumeEducation && !Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)) {
                Boolean hasBeenCadre = ((ResumeEducation) sub).getHasBeenCadre();
                String gradeRank = ((ResumeEducation) sub).getGradeRank();
                if (hasBeenCadre == null) {
                    response.setSuccess(false);
                    response.setMessage("是否担任过学生干部不能为空");
                    return response;
                }
                if (gradeRank == null) {
                    response.setSuccess(false);
                    response.setMessage("年级排名不能为空");
                    return response;
                }
            }
        }
        if (sub instanceof BeginAndEndDate) {
            Date begin = ((BeginAndEndDate) sub).getBeginDate();
            Date end = ((BeginAndEndDate) sub).getEndDate();
            if (begin != null && end != null && end.getTime() < begin.getTime()) {
                response.setSuccess(false);
                response.setMessage("结束时间必须大于开始时间");
                return response;
            }
        }
        resumeSubService.saveOrUpdate(sub);
        response.setData(sub.getId());
        return response;
    }

    private Response<Integer> saveSub(ResumeSubEntity sub, BindingResult result) {
        return saveSub(sub, null, result);
    }

    /**
     * 公共删除方法
     */
    private Response deleteSub(ResumeSubEntity sub) {
        resumeSubService.delete(sub);
        return Response.success();
    }
    /* end从属信息 */
}
