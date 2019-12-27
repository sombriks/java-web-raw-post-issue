package sample.issue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/up")
public class UploadServlet extends HttpServlet {

  private static final long serialVersionUID = -4156500963897721167L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().write("ping");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String fileName = req.getHeader("x-file-name");
    try (InputStream in = req.getInputStream()) {
      File f = new File("/tmp/" + fileName);
      if(!f.exists()) f.createNewFile();
      System.out.println(f);
      try (OutputStream out = new FileOutputStream(f)) {
        IOUtils.copy(in, out, 4096);
      }
    }
  }

}