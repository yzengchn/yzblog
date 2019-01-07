package xyz.yzblog.base.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import xyz.yzblog.base.dataobject.Label;
import xyz.yzblog.base.repository.LabelRepository;
import xyz.yzblog.base.service.LabelService;
import xyz.yzblog.common.utils.IdWorker;

@Service
public class LabelServiceImpl implements LabelService{

	@Autowired 
	private LabelRepository labelRepository;
	
	@Autowired
	private IdWorker idWorker;
	
	@Override
	public List<Label> findAll() {
		return labelRepository.findAll();
	}

	@Override
	public Label findById(String id) {
		return labelRepository.findById(id).get();
	}

	@Override
	public void add(Label label) {
		label.setId(idWorker.nextId()+"");
		labelRepository.save(label);
	}

	@Override
	public void update(Label label) {
		labelRepository.save(label);
	}

	@Override
	public void deleteById(String id) {
		labelRepository.deleteById(id);
	}
	
	
	private Specification<Label> genSpecification(Map<String, String> searchMap){
		return new Specification<Label>() {

			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicatesList = new ArrayList<>();
				
				if((searchMap.get("labelname")!=null && !"".equals(searchMap.get("labelname")))) {
					predicatesList.add(criteriaBuilder.like(root.get("labelname").as(String.class), "%"+ String.valueOf(searchMap.get("labelname")) +"%"));
				}
				
				if((searchMap.get("state")!=null && !"".equals(searchMap.get("state")))) {
					predicatesList.add(criteriaBuilder.equal(root.get("state").as(String.class), String.valueOf(searchMap.get("state")) ));
				}
				
				if((searchMap.get("recommend")!=null && !"".equals(searchMap.get("recommend")))) {
					predicatesList.add(criteriaBuilder.equal(root.get("recommend").as(String.class), String.valueOf(searchMap.get("recommend")) ));
				}
				
				return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
			}
		};
	}

	@Override
	public List<Label> findSearch(Map<String, String> searchMap) {
		Specification<Label> specification = genSpecification(searchMap);
		return labelRepository.findAll(specification);
	}

	@Override
	public Page<Label> findSearch(Map<String, String> searchMap, int page, int size) {
		Specification<Label> specification = genSpecification(searchMap);
		PageRequest pageRequest = PageRequest.of(page-1, size);
		return labelRepository.findAll(specification, pageRequest);
	}
}
