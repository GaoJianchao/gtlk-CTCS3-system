package com.gtlk.util;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@SuppressWarnings("rawtypes")
public class MySessionContext {
	private static MySessionContext instance;
	private HashMap mymap;

	private MySessionContext() {
		mymap = new HashMap();
	}

	public static MySessionContext getInstance() {
		if (instance == null) {
			instance = new MySessionContext();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public synchronized void AddSession(HttpSession session) {
		if (session != null) {
			mymap.put(session.getId(), session);
		}
	}

	public synchronized void DelSession(HttpSession session) {
		if (session != null) {
			mymap.remove(session.getId());
		}
	}

	public synchronized HttpSession getSession(String session_id) {
		if (session_id == null)
			return null;
		return (HttpSession) mymap.get(session_id);
	}

}
