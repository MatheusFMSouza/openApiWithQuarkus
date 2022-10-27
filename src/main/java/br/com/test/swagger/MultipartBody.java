package br.com.test.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jboss.resteasy.reactive.PartType;

import java.io.InputStream;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipartBody {

    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream file;

    @FormParam("fileName")
    @PartType(MediaType.TEXT_PLAIN)
    public String fileName;
}