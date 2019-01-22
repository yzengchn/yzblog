package xyz.yzblog.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import xyz.yzblog.user.dataobject.User;

public interface UserDao extends JpaRepository<User, String>,JpaSpecificationExecutor<User>{

	@Query("select u from User u where u.mobile = ?1 or u.loginName = ?1")
	User findByloginNameOrMobile(String username);
}
