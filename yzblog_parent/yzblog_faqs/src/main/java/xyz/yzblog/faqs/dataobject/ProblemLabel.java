package xyz.yzblog.faqs.dataobject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 问答服务-问题-标签中间表 
 * @author  <a href="http://www.yzblog.xyz">yzblog</a>
 * @version  [1.0, 2019年1月7日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
@Entity
@Table(name="problem_label")
public class ProblemLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    /**
    * 问题id
    */
    private String problemId;

    /**
    * 标签id
    */
    private String labelId;

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}

    
}