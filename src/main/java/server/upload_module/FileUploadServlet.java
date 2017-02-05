package server.upload_module;

import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


public class FileUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 10);
        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                String line = item.getString("UTF-8");
                String json = new Gson().toJson(parseStringToPersonDto(line));
                response.addHeader("Content-Type", "text/html;charset=UTF-8");
                response.getWriter().write(json);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
    }

    private ArrayList<PersonDTO> parseStringToPersonDto(String str) {
        ArrayList<PersonDTO> persons = new ArrayList<PersonDTO>();
        List<String> lines = new ArrayList<String>(Arrays.asList(str.split("\n")));
        String[] arrayList;
        for (String strin : lines) {
            arrayList = strin.split(",");
            persons.add(new PersonDTO(arrayList[0].trim(), arrayList[1].trim(), arrayList[2].trim()));
        }
        return persons;
    }
}


