package com.data.structures.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickplay.cms.content.model.catalog.CatalogDescriptor;


public class ZipTest {

	private static final String CHARSET = "UTF-8";
    private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static void main(String[] args) throws IOException {
		CatalogDescriptor catalogDescriptor = objectMapper.readValue(new File("F:\\git\\personal\\feed-exporter\\src\\main\\resources\\roku\\rokuAegFeedExporterCatalogDescriptor.json"), CatalogDescriptor.class);
		System.out.println(catalogDescriptor.getTitle());
		String encoded = encode(catalogDescriptor);
		System.out.println(encoded);
		catalogDescriptor = decode(encoded);
        System.out.println(catalogDescriptor.getTitle());
	}


	public static String encode(CatalogDescriptor catalogDescriptor) throws JsonProcessingException, IOException
    {
        String encodedStr = null;
        ByteArrayOutputStream baos = null;
        try
        {
            baos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(baos);
            objectMapper.writeValue(gzip, catalogDescriptor);
            byte[] b64UrlSafe = Base64.encodeBase64URLSafe(baos.toByteArray());
            encodedStr = new String(b64UrlSafe, CHARSET);
        } finally
        {
            IOUtils.closeQuietly(baos);
        }
        return encodedStr;
    }
	
	public static CatalogDescriptor decode(String zippedBase64Str)
            throws IOException
    {
        CatalogDescriptor catalogDescriptor = null;
        byte[] bytes = Base64.decodeBase64(zippedBase64Str);
        GZIPInputStream zi = null;
        try
        {
            zi = new GZIPInputStream(new ByteArrayInputStream(bytes));
            catalogDescriptor = objectMapper.readValue(zi, CatalogDescriptor.class);
        } finally
        {
            IOUtils.closeQuietly(zi);
        }
        return catalogDescriptor;
    }
	
}
