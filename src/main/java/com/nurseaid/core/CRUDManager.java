package com.nurseaid.core;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.nurseaid.protocol.Message;

public interface CRUDManager<T> {
	
	public Message create(T obj, HttpSession sess);
	public Message update(T obj);
	public Message delete(String id);
	public T getById(String id);
	
	public Set<T> getAll();
}
