package iqmsoft;

import lombok.SneakyThrows;
import lombok.val;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iqmsoft.api.ejb.remote.OnlyRemote;

import java.io.IOException;

import static java.lang.String.format;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class RemoteOnlyClientServlet extends HttpServlet {

	private static final long serialVersionUID = 6621759119315184794L;

	@EJB
	OnlyRemote remote;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("RemoteClientServlet started.");
	}

	@Override
	@SneakyThrows
	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		val writer = response.getWriter();
		writer.println(format("remote EJB client says: %s", remote.getMessage()));
		writer.close();
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("RemoteClientServlet killed.");
	}
}
