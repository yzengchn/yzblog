package xyz.yzblog.search.dataobject;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/*
 * 其中，注解解释如下：
@Document(indexName="blob3",type="article")：
    indexName：索引的名称（必填项）
    type：索引的类型
@Id：主键的唯一标识
@Field(index=true,analyzer="ik_smart",store=true,searchAnalyzer="ik_smart",type = FieldType.text)
    index：是否设置分词
    analyzer：存储时使用的分词器
    searchAnalyze：搜索时使用的分词器
    store：是否存储
    type: 数据类型

 */

@Document(indexName="yzblog",type="article")
public class Article implements Serializable{
	/**
	 * ID
	 */
	@Id
	private String id;
	/**
	 * 文章标题
	 */
	@Field(index= true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
	private String title;
	/**
	 * 文章内容
	 */
	@Field(index= true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
	private String content;
	
	/**
	 * 审核状态
	 */
	private String state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
