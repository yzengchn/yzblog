package xyz.yzblog.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import xyz.yzblog.base.dataobject.Label;

/*
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 */

public interface LabelRepository extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label>{
	
}
