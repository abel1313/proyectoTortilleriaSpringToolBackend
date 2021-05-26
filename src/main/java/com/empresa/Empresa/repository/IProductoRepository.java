package com.empresa.Empresa.repository;

import org.springframework.stereotype.Repository;

import com.empresa.Empresa.module.Producto;

@Repository
public interface IProductoRepository extends IBaseRepository<Producto, Integer>
{

}
