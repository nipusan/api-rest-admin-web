/**
 * 
 */
package com.avaya.proccess.dao;

import org.springframework.data.repository.CrudRepository;

import com.avaya.proccess.entity.User;

/**
 * @author devnix
 * @category Interface Generic
 *
 */
public interface IGenericDao extends CrudRepository<User, Integer> {
	
}
