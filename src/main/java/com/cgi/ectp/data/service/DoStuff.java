//package com.cgi.ectp.data.service;
//
//import com.cgi.ectp.data.dao.PetJPARepository;
//import com.cgi.ectp.data.dao.PetRepository;
//import com.cgi.ectp.data.model.PetModel;
//import lombok.val;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.stream.StreamSupport;
//
//@Service
//public class DoStuff implements Runnable {
//
//	@Autowired private PetRepository petRepository;
//	@Autowired private PetJPARepository petJPARepository;
//
//	@PostConstruct
//	public void postConstruct() {
//		new Thread(this).start();
//	}
//
//	@Override
//	public void run() {
//		val pet = PetModel.of("Eli", "dog", "mixed", 'F');
//		pet.setId(1);
//		petRepository.save(pet);
//
//		System.out.println(petRepository.findById(1).get());
//
//		val iterator1 = petRepository.findAll();
//		iterator1.forEach(p -> System.out.println(p.getName()));
//
//		val iterator2 = petRepository.findAll();
//		StreamSupport.stream(iterator2.spliterator(), false)
//			.map(p -> p.getName())
//			.forEach(n -> System.out.println(n));
//
//		if (petRepository.existsById(4)) {
//			petRepository.deleteById(4);
//		}
//	}
//}
