package cn.aki.controller;

import cn.aki.entity.*;
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.form.validator.BeginAndEndDate;
import cn.aki.response.DataResponse;
import cn.aki.response.FormResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.ResumeService;
import cn.aki.service.ResumeSubService;
import cn.aki.utils.Constants;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 简历
 *
 * @author aki
 *         2016年4月29日 上午9:48:40
 */
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController {
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private ResumeSubService resumeSubService;

	/**
	 * 上传头像
	 */
	@RequestMapping(value = "/photo/upload")
	public void upload(@RequestParam("file") MultipartFile file, Resume resume, HttpServletResponse response) {
		SimpleResponse json = new SimpleResponse();
		if (!file.isEmpty()) {
			//上传校验
			if (file.getSize() > 50 * 1024) {
				json.setMessage("上传文件必须小于50kb");
			} else if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
				json.setMessage("只能上传jpg、png格式图片");
			} else {
				//文件命名
				try {
					resume.setPhoto(file.getBytes());
					resumeService.updatePhoto(resume);
					json.setSuccess(true);
					json.setMessage("上传成功");
				} catch (IOException e) {
					e.printStackTrace();
					json.setMessage("上传失败");
				}
			}
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		try (PrintWriter out = response.getWriter()) {
			out.println(JSON.toJSONString(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/photo/show")
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

	@RequestMapping(path = "/list", method = GET)
	public String toList(Resume resume, Model model) {
		List<Resume> list = resumeService.getList(resume);
		model.addAttribute("resume", resume);
		model.addAttribute("list", list);
		return "resume/list";
	}

	@RequestMapping(path = "/detail", method = GET)
	public String toDetail(Integer id, String recruitType, String applyJobId, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("recruitType", recruitType);
		//应聘岗位id，由岗位页面拦截跳转得到
		model.addAttribute("applyJobId", applyJobId);
		return "resume/detail";
	}

	@ResponseBody
	@RequestMapping(path = "/save/base", method = POST)
	public FormResponse<Void> saveBase(@Valid Resume form, BindingResult result) {
		FormResponse<Void> response = handleFormError(result);
		resumeService.validate(form, response);
		if (response.isSuccess()) {
			resumeService.update(form);
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(path = "/detail/all", method = POST)
	public DataResponse<Resume> handleDetail(Resume resume) {
		DataResponse<Resume> response = new DataResponse<Resume>();
		resume = resumeService.get(resume, true);
		response.setData(resume);
		return response;
	}

	@ResponseBody
	@RequestMapping(path = "/submit", method = POST)
	public SimpleResponse handleSubmit(Resume resume) {
		String message = resumeService.submit(resume);
		SimpleResponse response = new SimpleResponse();
		response.setMessage(message);
		response.setSuccess(message == null);
		return response;
	}

	/* begin从属信息 */
	@ResponseBody
	@RequestMapping(path = "/save/award", method = POST)
	public FormResponse<Integer> saveAward(@Valid ResumeAward form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/award", method = POST)
	public SimpleResponse deleteAward(ResumeAward bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/computer", method = POST)
	public FormResponse<Integer> saveComputer(@Valid ResumeComputer form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/computer", method = POST)
	public SimpleResponse deleteComputer(ResumeComputer bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/education")
	public FormResponse<Integer> saveEducation(String recruitType, @Valid ResumeEducation form, BindingResult result) {
		//@Valid放其他参数会报错
		return saveSub(form, recruitType, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/education", method = POST)
	public SimpleResponse deleteEducation(ResumeEducation bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/family", method = POST)
	public FormResponse<Integer> saveFamily(@Valid ResumeFamily form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/family", method = POST)
	public SimpleResponse deleteFamily(ResumeFamily bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/foreignLanguage", method = POST)
	public FormResponse<Integer> saveForeignLanguage(@Valid ResumeForeignLanguage form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/foreignLanguage", method = POST)
	public SimpleResponse deleteForeignLanguage(ResumeForeignLanguage bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/studentCadre", method = POST)
	public FormResponse<Integer> saveStudentCadre(@Valid ResumeStudentCadre form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/studentCadre", method = POST)
	public SimpleResponse deleteStudentCadre(ResumeStudentCadre bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/work", method = POST)
	public FormResponse<Integer> saveWork(@Valid ResumeWork form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/work", method = POST)
	public SimpleResponse deleteWork(ResumeWork bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/practice", method = POST)
	public FormResponse<Integer> savePractice(@Valid ResumePractice form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/practice", method = POST)
	public SimpleResponse deletePractice(ResumePractice bean, BindingResult result) {
		return deleteSub(bean);
	}

	@ResponseBody
	@RequestMapping(path = "/save/train", method = POST)
	public FormResponse<Integer> saveTrain(@Valid ResumeTrain form, BindingResult result) {
		return saveSub(form, result);
	}

	@ResponseBody
	@RequestMapping(path = "/delete/train", method = POST)
	public SimpleResponse deleteTrain(ResumeTrain bean, BindingResult result) {
		return deleteSub(bean);
	}

	/**
	 * 公共修改方法
	 *
	 * @param sub
	 * @param result
	 * @return
	 */
	private FormResponse<Integer> saveSub(ResumeSubEntity sub, String recruitType, BindingResult result) {
		FormResponse<Integer> response = handleFormError(result);
		if (recruitType != null) {
			final String errInfo = "字段不能为空";
			if (sub instanceof ResumeEducation && !Constants.RECRUIT_TYPE_SOCIETY.equals(recruitType)) {
				Boolean hasBeenCadre = ((ResumeEducation) sub).getHasBeenCadre();
				String gradeRank = ((ResumeEducation) sub).getGradeRank();
				if (hasBeenCadre == null) {
					response.putError("hasBeenCadre", errInfo);
				}
				if (gradeRank == null) {
					response.putError("gradeRank", errInfo);
				}
			}
		}
		if (sub instanceof BeginAndEndDate) {
			Date begin = ((BeginAndEndDate) sub).getBeginDate();
			Date end = ((BeginAndEndDate) sub).getEndDate();
			if (begin != null && end != null && end.getTime() < begin.getTime()) {
				response.putError("endDate", "结束时间必须大于开始时间");
			}
		}
		if (response.isSuccess()) {
			resumeSubService.saveOrUpdate(sub);
			response.setData(sub.getId());
		}
		return response;
	}

	private FormResponse<Integer> saveSub(ResumeSubEntity sub, BindingResult result) {
		return saveSub(sub, null, result);
	}

	/**
	 * 公共删除方法
	 *
	 * @param sub
	 * @return
	 */
	private SimpleResponse deleteSub(ResumeSubEntity sub) {
		SimpleResponse response = new SimpleResponse();
		resumeSubService.delete(sub);
		response.setSuccess(true);
		return response;
	}
	/* end从属信息 */
}
