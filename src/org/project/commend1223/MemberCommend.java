package org.project.commend1223;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommend {

	void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
