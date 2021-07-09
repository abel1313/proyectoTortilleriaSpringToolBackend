package com.empresa.Empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.EstatusPedido;
import com.empresa.Empresa.repository.IBaseRepository;
import com.empresa.Empresa.repository.IEstatusPedidoRepository;

@Service
public class EstatusPedidoServiceImpl extends BaseServiceImpl<EstatusPedido, Integer> implements IEstatusPedidoService
{

	@Autowired
	private IEstatusPedidoRepository iEstatusPedidoRepository;
	
	public EstatusPedidoServiceImpl(IBaseRepository<EstatusPedido, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}

}
