package com.empresa.Empresa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.empresa.Empresa.module.Base;

@NoRepositoryBean
public interface IBaseRepository<T extends Base, ID extends Serializable> 
extends JpaRepository<T, ID>
{

}
