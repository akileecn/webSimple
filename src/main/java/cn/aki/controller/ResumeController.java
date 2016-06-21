package cn.aki.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.aki.entity.Resume;
import cn.aki.entity.ResumeAward;
import cn.aki.entity.ResumeComputer;
import cn.aki.entity.ResumeEducation;
import cn.aki.entity.ResumeFamily;
import cn.aki.entity.ResumeForeignLanguage;
import cn.aki.entity.ResumePractice;
import cn.aki.entity.ResumeStudentCadre;
import cn.aki.entity.ResumeTrain;
import cn.aki.entity.ResumeWork;
import cn.aki.entity.base.ResumeSubEntity;
import cn.aki.response.DataResponse;
import cn.aki.response.FormResponse;
import cn.aki.response.SimpleResponse;
import cn.aki.service.ResumeService;
import cn.aki.service.ResumeSubService;

/**
 * 简历
 * @author aki
 * 2016年4月29日 上午9:48:40
 */
@Controller
@RequestMapping("/resume")
public class ResumeController extends BaseController{
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private ResumeSubService resumeSubService;
	
	/**
	 * 上传头像
	 */
	@ResponseBody
	@RequestMapping(value = "/photo/upload")
	public SimpleResponse upload(MultipartHttpServletRequest request,Resume resume) {
		SimpleResponse response=new SimpleResponse();
		Iterator<String> itr = request.getFileNames();
		if (itr.hasNext()) {
			MultipartFile mpf = request.getFile(itr.next());
			//上传校验
			if(mpf.getSize()>50*1024){
				response.setMessage("上传文件必须小于50kb");
				return response;
			}
			if(!mpf.getContentType().startsWith("image/")){
				response.setMessage("只能上传图片");
				return response;
			}
			//文件命名
//			String originalFileName=mpf.getOriginalFilename();
//			String newFileName=resume.getId()+originalFileName.substring(originalFileName.indexOf("."));
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM/dd/");
//			String parentName="/upload/"+sdf.format(new Date());
//			File parentDir=new File(servletContext.getRealPath(parentName));
//			if(!parentDir.exists()){
//				parentDir.mkdirs();
//			}
			try {
//				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(new File(parentDir, newFileName)));
//				String webPath=parentName+newFileName;
				resume.setPhoto(mpf.getBytes());
				resumeService.updatePhoto(resume);
				response.setSuccess(true);
				response.setMessage("上传成功");
			} catch (IOException e) {
				e.printStackTrace();
				response.setMessage("上传失败");
			}
		}
		return response;
	}
	
	@RequestMapping(path="/phote/show")
	public void getPhote(Resume resume,HttpServletResponse response){
		resume=resumeService.getPhoto(resume);
//		File photo=null;
		if(resume!=null&&resume.getPhoto()!=null){
//			photo=new File(servletContext.getRealPath(resume.getPhoto()));
//			if(photo.exists()){
				InputStream is=null;
				try {
//					is = new FileInputStream(photo);
					is=new ByteArrayInputStream(resume.getPhoto());
					FileCopyUtils.copy(is , response.getOutputStream());
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(is!=null){
						try {
							is.close();
						} catch (IOException e) {
						}
					}
				}
//			}
		}
	}
	
	@RequestMapping(path="/list",method=GET)
	public String toList(Resume resume,Model model){
		List<Resume> list=resumeService.getList(resume);
		model.addAttribute("resume", resume);
		model.addAttribute("list", list);
		return "resume/list";
	}
	
	@RequestMapping(path="/detail",method=GET)
	public String toDetail(Integer id,String recruitType,Model model){
		model.addAttribute("id", id);
		model.addAttribute("recruitType", recruitType);
		return "resume/detail";
	}
	
	@ResponseBody
	@RequestMapping(path="/save/base",method=POST)
	public FormResponse<Void> saveBase(@Valid Resume form,BindingResult result){
		FormResponse<Void> response=handleFormError(result);
		resumeService.validate(form, response);
		if(response.isSuccess()){
			resumeService.update(form);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(path="/detail/all",method=POST)
	public DataResponse<Resume> handleDetail(Resume resume){
		DataResponse<Resume> response=new DataResponse<Resume>();
		resume=resumeService.get(resume,true);
		response.setData(resume);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(path="/submit",method=POST)
	public SimpleResponse handleSubmit(Resume resume){
		String message=resumeService.submit(resume);
		SimpleResponse response=new SimpleResponse();
		response.setMessage(message);
		response.setSuccess(message==null);
		return response;
	}
	
	/* begin从属信息 */
	@ResponseBody
	@RequestMapping(path="/save/award",method=POST)
	public FormResponse<Integer> saveAward(@Valid ResumeAward form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/award",method=POST)
	public SimpleResponse deleteAward(ResumeAward bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/computer",method=POST)
	public FormResponse<Integer> saveComputer(@Valid ResumeComputer form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/computer",method=POST)
	public SimpleResponse deleteComputer(ResumeComputer bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/education",method=POST)
	public FormResponse<Integer> saveEducation(@Valid ResumeEducation form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/education",method=POST)
	public SimpleResponse deleteEducation(ResumeEducation bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/family",method=POST)
	public FormResponse<Integer> saveFamily(@Valid ResumeFamily form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/family",method=POST)
	public SimpleResponse deleteFamily(ResumeFamily bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/foreignLanguage",method=POST)
	public FormResponse<Integer> saveForeignLanguage(@Valid ResumeForeignLanguage form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/foreignLanguage",method=POST)
	public SimpleResponse deleteForeignLanguage(ResumeForeignLanguage bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/studentCadre",method=POST)
	public FormResponse<Integer> saveStudentCadre(@Valid ResumeStudentCadre form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/studentCadre",method=POST)
	public SimpleResponse deleteStudentCadre(ResumeStudentCadre bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/work",method=POST)
	public FormResponse<Integer> saveWork(@Valid ResumeWork form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/work",method=POST)
	public SimpleResponse deleteWork(ResumeWork bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/practice",method=POST)
	public FormResponse<Integer> savePractice(@Valid ResumePractice form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/practice",method=POST)
	public SimpleResponse deletePractice(ResumePractice bean,BindingResult result){
		return deleteSub(bean);
	}
	@ResponseBody
	@RequestMapping(path="/save/train",method=POST)
	public FormResponse<Integer> saveTrain(@Valid ResumeTrain form,BindingResult result){
		return saveSub(form,result);
	}
	@ResponseBody
	@RequestMapping(path="/delete/train",method=POST)
	public SimpleResponse deleteTrain(ResumeTrain bean,BindingResult result){
		return deleteSub(bean);
	}
	/**
	 * 公共修改方法
	 * @param sub
	 * @param result
	 * @return
	 */
	private FormResponse<Integer> saveSub(ResumeSubEntity sub,BindingResult result){
		FormResponse<Integer> response=handleFormError(result);
		if(response.isSuccess()){
			resumeSubService.saveOrUpdate(sub);
			response.setData(sub.getId());
		}
		return response;
	}
	/**
	 * 公共删除方法
	 * @param sub
	 * @return
	 */
	private SimpleResponse deleteSub(ResumeSubEntity sub){
		SimpleResponse response=new SimpleResponse();
		resumeSubService.delete(sub);
		response.setSuccess(true);
		return response;
	}
	/* end从属信息 */
}
