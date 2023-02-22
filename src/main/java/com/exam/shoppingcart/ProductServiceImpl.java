package com.exam.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

      // get all information
      public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    // public CandidateAcademicInfo updateAcademicInformation(Long id, CandidateAcademicInfo academicInformation){
    //     Optional<CandidateAcademicInfo> academicInformationOptional = academicInfoRepo.findById(id);
    //     if(academicInformationOptional.isPresent()) {
    //         CandidateAcademicInfo existingAcademicInformation = academicInformationOptional.get();
    //         existingAcademicInformation.setCurrentDegree(academicInformation.getCurrentDegree());
    //         existingAcademicInformation.setUserId(academicInformation.getUserId());
    //         existingAcademicInformation.setCgpa(academicInformation.getCgpa());
    //         // existingAcademicInformation.setCertificates(academicInformation.getCertificates());
    //         existingAcademicInformation.setTitle(academicInformation.getTitle());
    //         existingAcademicInformation.setInstitute(academicInformation.getInstitute());
    //         existingAcademicInformation.setFinalYearProject(academicInformation.getFinalYearProject());
    //         existingAcademicInformation.setDegreeProgress(academicInformation.getDegreeProgress());
    //         existingAcademicInformation.setGraduationDate(academicInformation.getGraduationDate());
    //         academicInfoRepo.save(existingAcademicInformation);
    //         return existingAcademicInformation;
    //     }
    //     else {
    //         return null;
    //     }
    // }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }


}
