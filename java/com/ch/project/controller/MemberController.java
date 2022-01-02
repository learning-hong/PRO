package com.ch.project.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.project.model.Member;
import com.ch.project.service.MemberService;
@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@RequestMapping("joinForm")
	public String joininForm() {
		return "main/joinForm";
	}
	@RequestMapping("forgot")
	public String forgot() {
		return "main/forgot";
	}

	/*
	 * @RequestMapping(value="idChk", produces = "text/html;charset=utf-8")
	 * 
	 * @ResponseBody // idChk.jsp로 가지말고 바로 본문을 전달하라. public String idChk(String id)
	 * { String msg = ""; Member member = ms.select(id); if (member == null) msg =
	 * "사용 가능한 아이디입니다"; else msg = "이미 사용중이니 다른 아이디를 사용하세요"; return msg; }
	 */
	@RequestMapping(value="IDChk", produces = "text/html;charset=utf-8")
	@ResponseBody // IDChk로 가지말고 바로 본문을 실행;
	public String IDChk(String id) {
		String msg="";
		Member member = ms.select(id);
		if(member == null) msg = "사용 가능";
		else msg= "이미 사용중인 아이디 입니다";
		return msg;
		
	}
	// 회원 정보 찾기 부분(해결)
	@RequestMapping(value="IDChk2",produces = "text/html;charset=utf-8")
	@ResponseBody // IDChk로 가지말고 바로 본문을 실행;
	public String IDChk2(Member member,HttpSession session) {
		String msg = "";
		Member member2 = ms.select(member.getId());
		if (member2 == null) msg=" 없는 아이디 입니다 "; 
		else msg = "있는 아이디 입니다";
		return msg;
	}
	
	@RequestMapping("forgotPassWord")
	public String forgotPassWord(Member member, Model model) {
		return "main/forgotPassWord";
	}
	
	
	
	@RequestMapping("join")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면에서 입력한 데이터이고 memebr2는 DB에서 id로 읽은 데이터
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			String memberPhoto = member.getFile().getOriginalFilename();
			if (memberPhoto != null && !memberPhoto.equals("")) {			
				member.setMemberPhoto(memberPhoto); 
				String real = 
					session.getServletContext().getRealPath("/resources/images");
				FileOutputStream fos = new FileOutputStream(
						new File(real+"/"+memberPhoto));
				fos.write(member.getFile().getBytes());
				fos.close();			
			} 
			result = ms.insert(member);
		} else result = -1;  // 이미 있으니 입력하지마
		model.addAttribute("result", result);
		return "main/join";
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "main/loginForm";
	}
	
	/*
	 * @RequestMapping("main/loginForm2") public String loginForm2() {
	 * return"main/loginForm2"; }
	 */
	
	
	
	@RequestMapping("login")
	public String login(Member member, Model model, HttpSession session) {
		int result = 0; // 암호가 다름
		Member member2 = ms.select(member.getId());
		if (member2 == null || member2.getDel().equals("y")) 
			result = -1; // 없는 ID 
		else if (member2.getPassword().equals(member.getPassword())) {
			result = 1; // 성공 id와 password가 일치
			session.setAttribute("id", member.getId());
		} 
		model.addAttribute("result", result);
		return "main/login";
	}
	@RequestMapping("view")
	public String view(HttpSession session, Model model) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "view";
	}
	@RequestMapping("updateForm")
	public String updateForm(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "main/updateForm";
	}
	@RequestMapping("update")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
//		fileName는 null일수도 있고 값을 가지고 올 수도 있다
		String memberPhoto = member.getFile().getOriginalFilename();
		if (memberPhoto != null && !memberPhoto.equals("")) {			
			member.setMemberPhoto(memberPhoto);
			String real = 
				session.getServletContext().getRealPath("/resources/images");
			FileOutputStream fos = new FileOutputStream(
					new File(real+"/"+memberPhoto));
			fos.write(member.getFile().getBytes());
			fos.close();			
		} 
		result = ms.update(member);
		model.addAttribute("result", result);
		return "main/update";
	}
	@RequestMapping("delete")
	public String delete(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result = ms.delete(id);
		if (result > 0) session.invalidate();
		model.addAttribute("result", result);
		return "delete";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 데이터 삭제
		return "main/loginForm";
	}
	@RequestMapping("main")
	public String main(Member member, Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null && !id.equals("")) {
			member = ms.select(id);
			model.addAttribute("member", member);
		}
		return "main/main";
	}
	
	
	@RequestMapping("main/memberList")
	   public String memberList(Model model, HttpSession session) {
	      List<Member> memberList = ms.memberList();
	      System.out.println("size = "+memberList.size());
	      model.addAttribute("memberList", memberList);
	      return "main/memberList";   
	   }
	   @RequestMapping("main/memberSelect.do") 
	   public String memberSelect(String id, Model model) {
	      Member member = ms.select(id);
	      model.addAttribute("member", member);
	      return "main/memberSelect";
	   }
	   @RequestMapping("main/admin_main")
	   public String admin_main() {
		   return "main/admin_main";
	   }
	   
	   
	   @RequestMapping("main/admin_loginForm")
		public String admin_login_view() {

			return "main/admin_loginForm";
		}

		@RequestMapping("main/admin_login")
		    public String admin_login(Member member, Model model, HttpSession session) {
				int result = 0; // 암호가 다름
				Member member2 = ms.select(member.getId());
				if (member2 == null || member2.getDel().equals("y")) 
					result = -1; // 없는 ID 
				else if (member2.getPassword().equals(member.getPassword())) {
					result = 1; // 성공 id와 password가 일치
					session.setAttribute("id", member.getId());
				} 
				model.addAttribute("result", result);
				return"main/admin_main";
			}
		
		  @RequestMapping("mypage")
	      public String mypage(HttpSession session, Model model) {
	         String id = (String)session.getAttribute("id");
	         Member member = ms.select(id);
	         model.addAttribute("member", member);
	         return "main/mypage";
	      }

		
		@RequestMapping("main/memberDelete")
		public String delete(String id, Model model, HttpSession session) {
			int result = ms.delete(id);
			if (result > 0) session.invalidate();
			model.addAttribute("result", result);
			return "main/memberDelete";
		}
		// item
		
		
		@RequestMapping("item1")
		public String item1() {
			return "main/item1";
		}
		
		
		@RequestMapping("detail1")
		public String detail1() {
			return "main/detail1";
		}
		@RequestMapping("detail2")
		public String detail2() {
			return "main/detail2";
		}
		@RequestMapping("detail3")
		public String detail3() {
			return "main/detail3";
		}
		@RequestMapping("detail4")
		public String detail4() {
			return "main/detail4";
		}
		@RequestMapping("detail5")
		public String detail5() {
			return "main/detail5";
		}
		@RequestMapping("detail6")
		public String detail6() {
			return "main/detail6";
		}
		@RequestMapping("detail7")
		public String detail7() {
			return "main/detail7";
		}
		@RequestMapping("detail8")
		public String detail8() {
			return "main/detail8";
		}
		@RequestMapping("detail9")
		public String detail9() {
			return "main/detail9";
		}
		@RequestMapping("detail10")
		public String detail10() {
			return "main/detail10";
		}
		@RequestMapping("detail11")
		public String detail11() {
			return "main/detail11";
		}
		@RequestMapping("detail12")
		public String detail12() {
			return "main/detail12";
		}
		@RequestMapping("detail13")
		public String detail13() {
			return "main/detail13";
		}
		@RequestMapping("detail14")
		public String detail14() {
			return "main/detail14";
		}
		@RequestMapping("detail15")
		public String detail15() {
			return "main/detail15";
		}
		@RequestMapping("detail16")
		public String detail16() {
			return "main/detail16";
		}
		@RequestMapping("detail17")
		public String detail17() {
			return "main/detail17";
		}
		@RequestMapping("detail18")
		public String detail18() {
			return "main/detail18";
		}
		@RequestMapping("detail19")
		public String detail19() {
			return "main/detail19";
		}
		@RequestMapping("detail20")
		public String detail20() {
			return "main/detail20";
		}
		@RequestMapping("detail21")
		public String detail21() {
			return "main/detail21";
		}
		@RequestMapping("detail22")
		public String detail22() {
			return "main/detail22";
		}
		@RequestMapping("detail23")
		public String detail23() {
			return "main/detail23";
		}
		@RequestMapping("detail24")
		public String detail24() {
			return "main/detail24";
		}
		@RequestMapping("detail25")
		public String detail25() {
			return "main/detail25";
		}
		@RequestMapping("detail26")
		public String detail26() {
			return "main/detail26";
		}
		@RequestMapping("detail27")
		public String detail27() {
			return "main/detail27";
		}
		@RequestMapping("detail28")
		public String detail28() {
			return "main/detail28";
		}
		@RequestMapping("detail29")
		public String detail29() {
			return "main/detail29";
		}
		@RequestMapping("detail30")
		public String detail30() {
			return "main/detail30";
		}
		@RequestMapping("detail31")
		public String detail31() {
			return "main/detail31";
		}
	
	
//  kakao매핑
//	HttpConnection conn = HttpConnection.getInstance();
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		return "home";
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	//	public String kakao() {
	//	StringBuffer loginUrl = new StringBuffer();
	//	loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
	//	loginUrl.append("<>"); //카카오 앱에 있는 REST KEY
	//	loginUrl.append("&redirect_uri=");
	//	loginUrl.append("http://localhost:8080"); //카카오 앱에 등록한 redirect URL
	//	loginUrl.append("&response_type=code");
		
	//	return "redirect:"+loginUrl.toString();
	//}
	
//	@RequestMapping(value = "/kakaoLogin", method = RequestMethod.GET)
//	public String redirect(@RequestParam String code, HttpSession session) throws IOException {
//		
//		//code
//		//사용자가 취소 누르면 error 파라메터를 받음 
//		// 그때 여기서 구분해야할듯
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("grant_type", "=authorization_code");
//		map.put("client_id", "=<13528d196c9763f952218e1101d8559d>"); //카카오 앱에 있는 REST KEY
//		map.put("redirect_uri", "=http://localhost:8080"); //카카오 앱에 등록한 redirect URL
//		map.put("code", "="+code);
//		
//		String out = conn.HttpPostConnection("https://kauth.kakao.com/oauth/token", map).toString();
//		
//		ObjectMapper mapper = new ObjectMapper();
//		KakaoLoginOutput output = mapper.readValue(out, KakaoLoginOutput.class);
//		
//		System.out.println(output);
//		session.setAttribute("access_token", output.getAccess_token());
//		
//		return "redirect:/";
//	}
	
//	@RequestMapping(value="/logout")
//	public String access(HttpSession session) throws IOException {
//		
//		String access_token = (String)session.getAttribute("access_token");
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("Authorization", "Bearer "+ access_token);
//		
//		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/logout", map).toString();
//		System.out.println(result);
//		
//		return "redirect:/";
//	}
	
	
}