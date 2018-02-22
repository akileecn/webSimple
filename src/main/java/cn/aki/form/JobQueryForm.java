package cn.aki.form;

import cn.aki.entity.Job;
import cn.aki.form.base.BasePageForm;
import lombok.Data;

/**
 * 岗位查询表单
 *
 * @author aki
 * 2016年4月27日 下午6:10:59
 */
@Data
public class JobQueryForm extends BasePageForm {
    private Integer id;                //主键
    private String name;            //岗位名称
    private String recruitType;        //招聘类型
    private String workCity;        //工作城市
    private String education;        //学历
    private String publishDateType;    //发布时间类型

    public Job createJob() {
        Job job = new Job();
        job.setId(id);//查询时不会用到
        job.setName(name);
        job.setRecruitType(recruitType);
        job.setWorkCity(workCity);
        job.setEducation(education);
        return job;
    }

}
