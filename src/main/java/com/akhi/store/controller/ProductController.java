package com.akhi.store.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.akhi.store.general.User;
import com.akhi.store.product.ProductVO;
import com.akhi.store.service.ProductService;

@Controller
@RequestMapping(value = { "/product" })
@SessionAttributes(value = { "customer" })
public class ProductController {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(ProductController.class);

	@Value("${upload.location}")
	private String uploadLocation;
	
	@Inject
	private ProductService service; 

	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
	public String addProduct(ModelMap model,
			@RequestParam(value = "cat", defaultValue = "NAP") String cat,
			HttpSession session) {
		String result = "customer";

		if (session.getAttribute("customer") != null) {
			User user = (User) session.getAttribute("customer");

			if (user != null) {
				ProductVO product = new ProductVO();
				product.setId(user.getId());
				model.addAttribute("product", product);

				log.warn("Dash board , session is present for " + user);
				result = "addProduct";
			}
		}

		return result;
	}

	@RequestMapping(value = { "/newProduct" }, method = RequestMethod.POST)
	public String putProduct(ModelMap model, HttpSession session,
			@ModelAttribute("product") ProductVO product, BindingResult bresult) {
		String result = null;
		
		
		if (session.getAttribute("customer") != null) {
			User user = (User) session.getAttribute("customer");

			if (user != null) {
				product.setId(user.getId());
				log.warn("Adding product:    :::::::::::::" + product);
				service.persistProduct(product);
			}
		}
		
/*		InputStream inputStream = null;
		OutputStream outputStream = null;
	
	
		MultipartFile file = product.getFile();
		if (file != null) {
			log.warn("File Name: " + file.getName() + ", original name: "
					+ file.getOriginalFilename());
			try {
				inputStream = file.getInputStream();

				log.warn("Uploading at :::::::::::::::::::" + uploadLocation);
				File newFile = new File(uploadLocation
						+ file.getOriginalFilename());
				if (!newFile.exists()) {
					newFile.createNewFile();
				}
				outputStream = new FileOutputStream(newFile);
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}*/

		result = "addProduct";
		return result;
	}


}
