package xyz.yzblog.base.form;

import javax.validation.constraints.NotEmpty;


public class LabelForm {
	
	@NotEmpty(message="标签名称不能为空")
	private String labelname;//标签名称
	
	@NotEmpty(message="状态不能为空")
	private String state;//状态
	
	@NotEmpty(message="是否推荐不能为空")
	private String recommend;//是否推荐

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	
	
	
}	
