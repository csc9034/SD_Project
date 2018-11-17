package com.hbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;

import org.apache.commons.io.IOUtils;
//import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbc.domain.CompanyVO;
import com.hbc.domain.PageMaker;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.service.CompanyService;
import com.hbc.util.MediaUtils;
import com.hbc.util.EmpUploadFileUtils;

/**
 * 기관 뷰 컨트롤러
 * 
 * @author 정준호
 *
 */

@Controller
@RequestMapping("/admin/company/")
@MultipartConfig
public class AdminCompanyController {
	private static final Logger logger = LoggerFactory.getLogger(AdminCompanyController.class);

	/**
	 * 기관 서비스 객체
	 */
	@Inject
	private CompanyService service;

	/**
	 * 파일을 업로드하기 위해 리소스 어노테이션을
	 * 단 업로드 경로를 선언함
	 */
	@Resource(name = "empUploadPath")
	private String uploadPath;

	/**
	 * 기관 리스트 뷰로 이동하는 메소드
	 * 
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") AppSearchCriteria cri, Model model) throws Exception {
		
		// 기관 서비스단에서 검색된 기관 리스트를 가져옴
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		// 페이지메이커 객체 인스턴스 생성 후
		PageMaker pageMaker = new PageMaker();
		// 페이지메이커 객체의 크리테리아를 초기화함
		pageMaker.setCri(cri);

		// 검색결과 행의 개수를 페이지메이커에 넣어줌
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		// 뷰에 페이지메이커를 전달함
		model.addAttribute("pageMaker", pageMaker);

	}

	/**
	 * 기관 등록 뷰로 이동함
	 * @param company
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(@ModelAttribute("cri") AppSearchCriteria cri, CompanyVO company, Model model) throws Exception {
	}

	/**
	 * 기관을 등록하는 과정을 처리함
	 * @param company
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(CompanyVO company, RedirectAttributes rttr) throws Exception {
		
		// 기관 정보를 등록함
		service.register(company);
		
		// 메시지에 SUCCESS를 달아서
		// 리스트로 이동할 때 얼럿창이 표시되게 함
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/company/list";
	}
	
	/**
	 * 기관 정보를 삭제하는 과정을
	 * 처리하는 메소드
	 * @param compnum
	 * @param cri
	 * @param rttr
	 * @return 기관 리스트로 이동
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("compnum") int compnum, AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		// 기관 번호를 받아서 기관 정보를 삭제함
		service.remove(compnum);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/company/list";
	}

	/**
	 * 기관 수정 뷰로 이동
	 * @param compnum
	 * @param cri
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPageingGET(@RequestParam("compnum") int compnum, @ModelAttribute("cri") AppSearchCriteria cri,
			Model model) throws Exception {

		// 서비스로부터 기관 하나를 읽어온 뒤 뷰에 전달함
		model.addAttribute("company", service.read(compnum));

	}

	/**
	 * 기관 정보를 수정하는 과정을
	 * 처리하는 메소드
	 * @param company
	 * @param cri
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPage(CompanyVO company, @ModelAttribute("cri") AppSearchCriteria cri, RedirectAttributes rttr)
			throws Exception {
		
		// 뷰에서 기관 객체를 받아서 서비스로
		// 수정 작업을 넘김
		service.modify(company);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		// 기관 리스트로 이동
		return "redirect:/admin/company/list";

	}

	/**
	 * 업로드할 파일의 확장자를 검사하는 메소드
	 * 
	 * @param filepath
	 * @return
	 */
	public static boolean isImage(String filepath) {
		String[] extensions = { ".jpg", ".png", ".jpeg", ".JPG", ".PNG", ".JPEG" };
		for (String extension : extensions) {
			if (filepath.endsWith(extension)) {
				System.out.println("Its an image");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * AJAX로 파일 이름을 받아서
	 * 파일을 삭제하는 메소드
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) throws Exception {
		
		// 파일 이름으로부터 확장자를 받아서 formatName에 초기화함
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

		// 확장자를 파라미터로 넘겨서 미디어타입을 초기화함
		MediaType mType = MediaUtils.getMediaType(formatName);

		// 초기화한 미디어타입 객체가 널이 아니면 
		if (mType != null) {
			
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);

			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();

		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		service.deleteAttach(fileName);

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files) {

		logger.info("delete all files: " + files);

		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}

		for (String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			if (mType != null) {

				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}

			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	/**
	 * 업로드된 파일의 이름을 리턴시켜주는 메소드 항상 파일 하나를 넘겨주지만 페이지에서 사용하는 jquery 코드에서 list로 받기때문에
	 * 확장성을 위해 list 형식으로 넘겨줄것
	 * 
	 * @param empnum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttach/{compnum}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("compnum") Integer compnum) throws Exception {
		List<String> fileList = new ArrayList<String>();
		fileList.add(service.getAttach(compnum));

		return fileList;
	}
	
	

	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8", headers = ("content-type=multipart/*"))
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		System.out.println("originalName: " + file.getOriginalFilename());

		logger.info("originalName: " + file.getOriginalFilename());
		
		// 확장자가 jpg, png 종류가 아니면 null을 반환하도록 함
		if (!isImage(file.getOriginalFilename())) {
			return null;
		}

		return new ResponseEntity<>(EmpUploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME: " + fileName);

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	private String uploadFile(String originalName, byte[] fileData) throws IOException {
		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

		return savedName;
	}
}