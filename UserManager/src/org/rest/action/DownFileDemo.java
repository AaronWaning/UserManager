package org.rest.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.rest.stream.BigFileOutputStream;
@Path("/")
public class DownFileDemo {
	/**   
     * 下载对象   
     * @param bucketName   
     * @param objectName   
     * @param request   
     * @return   
     */   
    @Path("/downFile")    
	@GET
	@POST
    @Produces(MediaType.APPLICATION_OCTET_STREAM)    
    public Response downloadObject(@Context HttpServletRequest request)    
    {    
        InputStream fos=null;
		try {
			fos = new FileInputStream(this.getClass().getClassLoader().getResource("").getPath()+"test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        //直接返回输出流    
        return Response.ok(new BigFileOutputStream(fos)).build();  
        }
}
