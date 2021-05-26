package com.empresa.Empresa.service;

import org.springframework.stereotype.Service;

import com.empresa.Empresa.module.Mensaje;
import com.empresa.Empresa.repository.IBaseRepository;

@Service
public class MensajeServiceImpl extends BaseServiceImpl<Mensaje, Integer>
implements IMensajeService
{

	public MensajeServiceImpl(IBaseRepository<Mensaje, Integer> iBaseRepository) {
		super(iBaseRepository);
		// TODO Auto-generated constructor stub
	}
	

}
