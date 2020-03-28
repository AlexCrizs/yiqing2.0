package com.nwnu.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nunu.common.utils.AjaxJson;
import com.nwnu.pojo.Teacher;
import com.nwnu.service.MannagerService;
import com.nwnu.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private MannagerService mannagerService;

	/**
	 * ��ѯ�б�
	 * 
	 * @param student
	 * @param model
	 * @param session
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/listTeacher")
	public String listTeacher(Teacher teacher, Model model, HttpSession session,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer rows) {
		model.addAttribute("teacher", session.getAttribute("USER_SESSION"));
		model.addAttribute("page", teacherService.findTeacherList(teacher, page, rows));
		/*
		 * ��������ͨ���ֵ��ǩʵ�� //�Ա��ֵ� List<Dict> sexList=dictService.dictList("sex");
		 * model.addAttribute("sexList", sexList); //�����ֵ� List<Dict>
		 * nationList=dictService.dictList("nation"); model.addAttribute("nationList",
		 * nationList);
		 */
		// ���Ұ༶
		// List<Clazz> clazzList=clazzService.findClazzAll();
		// model.addAttribute("clazzList", clazzList);

		model.addAttribute("teacher", teacher);

		return "teacher";
	}

	/**
	 * ִ�б���
	 * 
	 * @param student
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/saveTeacher")
	@ResponseBody
	public AjaxJson saveTeacher(Teacher teacher, HttpSession session) {
		AjaxJson aj = new AjaxJson();
		String message = "�����ɹ�";
		Integer rows = null;
		try {
			if (StringUtils.isEmpty(teacher.getT_code())) {
				Teacher teacher1 = (Teacher) session.getAttribute("USER_SESSION");
				teacher1.setT_work_place(teacher1.getT_work_place());
				teacher1.setT_time(new Date());
				teacher1.setT_name(teacher1.getT_name());
				teacher1.setT_code(teacher1.getT_code());
				teacher1.setT_number(teacher1.getT_number());
				teacher1.setT_province(teacher1.getT_province());
				teacher1.setT_city(teacher1.getT_city());
				teacher1.setT_area(teacher1.getT_area());
				teacher1.setAm(teacher1.getAm());
				teacher1.setBm(teacher1.getBm());
				teacher1.setCm(teacher1.getCm());
				teacher1.setDm(teacher1.getDm());
				teacher1.setEm(teacher1.getEm());
				teacher1.setFm(teacher1.getFm());
				teacher1.setGm(teacher1.getGm());
				rows = this.teacherService.insertTeacher(teacher1);
				message = "�ύ�ɹ�";
			} else {
				// rows = this.studentService.updateStudent(student);
				message = "�ύ���� ";
			}

			if (rows < 0) {
				message = "����ʧ��";
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			message = "����ϵ����Ա";
			aj.setSuccess(false);
		}
		aj.setMsg(message);
		return aj;
	}

}
