package me.eun.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.eun.model.AdminAttachVO;
import me.eun.model.Criteria;
import me.eun.model.ProductVO;
import me.eun.service.ProductService;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	/* 관리자 메인 페이지 이동 */
    @RequestMapping(value="main", method = RequestMethod.GET)
    public void adminMainGET() throws Exception{
    }
    
    /* 상품 등록 페이지 접속 */
    @RequestMapping(value = "productAdd", method = RequestMethod.GET)
    public String productAddGET() throws Exception{
    	return "admin/productAdd";    //상품이 등록된다면 관리페이지로 넘김
    }
    
    @RequestMapping(value = "productAdd", method = RequestMethod.POST)
    public String productAddPost(ProductVO product,RedirectAttributes rttr) throws Exception{
    	productService.productAdd(product); //상품 등록 쿼리 수행
    	rttr.addFlashAttribute("product_result",product.getProductName()); //등록 성공 메세지 (상품 이름)
    	return "redirect:/admin/productControl";    //상품이 등록된다면 관리페이지로 넘김
    }
    
    /* 상품 관리 페이지 접속 */
    @RequestMapping(value = "productControl", method = RequestMethod.GET)
    public String productControlGET(Criteria criteria, Model model) throws Exception{
    	/*상품 목록 출력 데이터*/
    	List<ProductVO> list = productService.productGetList(criteria);
    	model.addAttribute("list",list);
    	return "admin/productControl";
    }
    
    /* 상품 관리 페이지 접속 */
    @RequestMapping(value = "productControl", method = RequestMethod.POST)
    public String goodsEnrollPOST() throws Exception{
    	return null;
    }
    
    /*상품 상세 조회 페이지*/
    @GetMapping("/productInfo")
    public String productInfo(int productCode, Model model) {
    	model.addAttribute("productInfo",productService.productInfo(productCode));
    	return "admin/productInfo";
    }
  
    
    /* 첨부 파일 업로드 */
    @PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<List<AdminAttachVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {	
    	/* 이미지 파일 체크 */
		for(MultipartFile multipartFile: uploadFile) {
			File checkfile = new File(multipartFile.getOriginalFilename());
			String type = null;
			try {
				type = Files.probeContentType(checkfile.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(!type.startsWith("image")) {
				
				List<AdminAttachVO> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
			}
		}//for end
		String uploadFolder = "C:\\upload";
	
		/*날짜 폴더 경로*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		String datePath = str.replace("-", File.separator);
	
		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder, datePath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}	
		/* 이미지 정보 담는 객체 */
		List<AdminAttachVO> list = new ArrayList();
		
		//for 문
		for(MultipartFile multipartFile : uploadFile) { 
			
			/*이미지 정보 객체*/
			AdminAttachVO vo = new AdminAttachVO();
			/* 파일 이름 */
			String uploadFileName = multipartFile.getOriginalFilename();
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);
			
			/* uuid 적용 파일 이름 */
			String uuid = UUID.randomUUID().toString();
			vo.setUuid(uuid);
			uploadFileName = uuid + "_" + uploadFileName;
			
			/* 파일 위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);
			
			/* 파일 저장 */
			try {
				multipartFile.transferTo(saveFile);
				/*썸네일 */
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
				BufferedImage bo_image = ImageIO.read(saveFile);
				//비율 
				double ratio = 3;
				//넓이 높이
				int width = (int) (bo_image.getWidth() / ratio);
				int height = (int) (bo_image.getHeight() / ratio);					
				Thumbnails.of(saveFile)
		        .size(width, height)
		        .toFile(thumbnailFile);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			 list.add(vo);
			
		} //for end
		ResponseEntity<List<AdminAttachVO>> result = new ResponseEntity<List<AdminAttachVO>>(list, HttpStatus.OK);
		return result;
	}
    /* 이미지 파일 삭제 */
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName){
		File file = null;
		try {
			/* 썸네일 파일 삭제 */
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			/* 원본 파일 삭제 */
			String originFileName = file.getAbsolutePath().replace("s_", "");
			file = new File(originFileName);
			file.delete();
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
    
    
}
// get 메서드 사용시 리턴할 실제 주소 값(문자열로 반환)
//    /WEB-INF/views/ admin/productAdd  .jsp"