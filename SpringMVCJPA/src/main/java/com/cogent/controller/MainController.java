package com.cogent.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cogent.dao.FormDao;
import com.cogent.entity.FormEntity;
import com.cogent.entity.LanguageEntity;
import com.cogent.entity.NameEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	EntityManager manager = null;
	ModelAndView mv = null;

	void init() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud");
		manager = factory.createEntityManager();
		mv = new ModelAndView("home");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public ModelAndView index() {
		if (manager == null) {
			init();
		}

		mv.addObject("data1", getAllData());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = { "/insert", "/update/insert" })
	public ModelAndView home(@RequestParam("file") MultipartFile file, FormDao dao, HttpServletRequest request) {

		System.out.println("HOme Method");
		boolean check = UploadImage(file);
		if (check) {
			// 1 means persist entity into table
			System.out.println();
			if (request.getServletPath().equals("/insert")) {
				InsertInTable(file, dao);

			} else {
				UpdateInTable(file, dao);
			}

		} else {
			System.out.println("File not UPloaded");
		}

		return index();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/update/{email}")
	public ModelAndView update(@PathVariable("email") String email) {

		FormDao formdao = GetSingleRecord(email);
		mv.addObject("data2", formdao);

		return index();
	}

	private FormDao GetSingleRecord(String email) {

		Query query = manager.createQuery("from FormEntity where email = :email", FormEntity.class);
		query.setParameter("email", email);

		FormEntity entity = (FormEntity) query.getSingleResult();
		return FormDao.builder().fname(entity.getNameEntity().getFName()).mname(entity.getNameEntity().getMName())
				.lname(entity.getNameEntity().getLName()).email(entity.getEmail()).password(entity.getPassword())
				.gender(entity.getGender()).dob(entity.getDob()).education(entity.getEducation())
				.english(entity.getLanguageEntity().getEnglish()).hindi(entity.getLanguageEntity().getHindi())
				.none(entity.getLanguageEntity().getNone()).mobile(entity.getMobile()).Imagefile(entity.getImageUrl())
				.build();

	}

	@RequestMapping(method = RequestMethod.GET, path = "/delete/{email}")
	public ModelAndView delete(@PathVariable("email") String email) {

		if (manager != null) {
			Query query = manager.createNativeQuery("delete from form where email = :email", FormEntity.class);
			query.setParameter("email", email);
//			FormEntity fe = manager.find(FormEntity.class, id);
			manager.getTransaction().begin();
			query.executeUpdate();
//			manager.remove(fe);
			manager.getTransaction().commit();
			return index();
		} else {
			init();
			return delete(email);
		}

	}

	private FormEntity getEntity(MultipartFile file, FormDao dao) {

		NameEntity ne = NameEntity.builder().fName(dao.getFname()).mName(dao.getMname()).lName(dao.getLname()).build();

		LanguageEntity le = LanguageEntity.builder().english(dao.getEnglish() == null ? "" : "English")
				.hindi(dao.getHindi() == null ? "" : "Hindi").none(dao.getNone() == null ? "" : "None of Above")
				.build();

		FormEntity fe = FormEntity.builder().nameEntity(ne).email(dao.getEmail()).password(dao.getPassword())
				.mobile(dao.getMobile()).dob(dao.getDob()).gender(dao.getGender()).languageEntity(le)
				.education(dao.getEducation()).imageUrl(file.getOriginalFilename()).build();

		return fe;
	}

	private List<FormDao> getAllData() {
		if (manager != null) {
			Query query = manager.createQuery("from FormEntity", FormEntity.class);
			List<FormEntity> data = query.getResultList();

			List<FormDao> datadao = data.stream()
					.map((fe) -> FormDao.builder().fname(fe.getNameEntity().getFName())
							.mname(fe.getNameEntity().getMName()).lname(fe.getNameEntity().getLName())
							.email(fe.getEmail()).password(fe.getPassword()).mobile(fe.getMobile()).dob(fe.getDob())
							.gender(fe.getGender()).education(fe.getEducation())
							.english(fe.getLanguageEntity().getEnglish()).hindi(fe.getLanguageEntity().getHindi())
							.none(fe.getLanguageEntity().getNone()).Imagefile(fe.getImageUrl()).build())
					.collect(Collectors.toList());

			System.out.println(datadao);
			return datadao;
		} else {
			init();
			return getAllData();
		}
	}

	// insert methodi
	private void InsertInTable(MultipartFile file, FormDao dao) {

		if (manager != null) {

			manager.getTransaction().begin();
			manager.persist(getEntity(file, dao));
			manager.getTransaction().commit();

		} else {
			init();
			InsertInTable(file, dao);
		}
	}

	private void UpdateInTable(MultipartFile file, FormDao dao) {

		if (manager != null) {
			Query query = manager.createQuery("from FormEntity where email = :email", FormEntity.class);
			query.setParameter("email", dao.getEmail());
			FormEntity fe = (FormEntity) query.getSingleResult();
			System.out.println("MY Entity " + fe);
			if (fe.getId() > 0) {

				manager.getTransaction().begin();
				manager.persist(getEntity(file, dao, fe));
				manager.getTransaction().commit();

			}
		} else {
			init();
			UpdateInTable(file, dao);
		}
	}

	private FormEntity getEntity(MultipartFile file, FormDao dao, FormEntity fe) {

		NameEntity ne = fe.getNameEntity();
		ne.setFName(dao.getFname());
		ne.setMName(dao.getMname());
		ne.setLName(dao.getLname());

		LanguageEntity le = fe.getLanguageEntity();

		le.setEnglish(dao.getEnglish() == null ? "" : "English");
		le.setHindi(dao.getHindi() == null ? "" : "Hindi");
		le.setNone(dao.getNone() == null ? "" : "None of Above");

		fe.setNameEntity(ne);
		fe.setEmail(dao.getEmail());
		fe.setPassword(dao.getPassword());
		fe.setMobile(dao.getMobile());
		fe.setDob(dao.getDob());
		fe.setGender(dao.getGender());
		fe.setLanguageEntity(le);
		fe.setEducation(dao.getEducation());
		fe.setImageUrl(file.getOriginalFilename());

		return fe;
	}

	private boolean UploadImage(MultipartFile file) {

		String path = "C:\\Users\\Cogent\\eclipse-workspace\\SpringMVCJPA\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
				+ file.getOriginalFilename();
		System.out.println(path);
		try {
			FileOutputStream fout = new FileOutputStream(path);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			bout.write(file.getBytes());
			bout.flush();
			bout.close();
			fout.flush();
			fout.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
}
