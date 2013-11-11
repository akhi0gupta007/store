package com.akhi.store.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductServiceLog extends Props
    {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String threadName;

    public Long getId()
	{
	return id;
	}

    public String getClassName()
	{
	return className;
	}

    public void setClassName( String className )
	{
	this.className = className;
	}

    public String getThreadName()
	{
	return threadName;
	}

    public void setThreadName( String threadName )
	{
	this.threadName = threadName;
	}

    @Override
    public String toString()
	{
	return "ProductServiceLog [id=" + id + ", className=" + className + ", threadName=" + threadName + "]";
	}

    public ProductServiceLog(String className, String threadName)
	{
	super();
	this.className = className;
	this.threadName = threadName;
	}

    public ProductServiceLog()
	{
	super();
	}

    }
