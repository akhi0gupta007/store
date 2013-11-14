package com.akhi.store.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.akhi.store.general.ProductServiceLog;

@Repository
public class ProductLoggerDao extends GenericHibernateDAO<ProductServiceLog, Long>
								implements
								LoggerDao
    {

    @Override
    public List<ProductServiceLog> findByExample( ProductServiceLog exampleInstance )
	{
	// TODO Auto-generated method stub
	return null;
	}


    }
