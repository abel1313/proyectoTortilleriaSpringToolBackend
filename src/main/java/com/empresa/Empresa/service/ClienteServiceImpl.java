package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Cliente;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IClienteRepository;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements IClienteService
{
	@Autowired
	private IClienteRepository iClienteRepository;
	public ClienteServiceImpl(IBaseRepository<Cliente, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
